package logic;

import java.util.ArrayList;

import Main.Main;
import render.GameScreen;
import render.RenderableHolder;
import ui.HighScoreUtility;
import ui.InputUtility;

public class MainLogic {
	private static int zBox = 0;
	public static ArrayList<Box> boxes;
	private static boolean isPause, isStart;

	public static int creationDelay;
	public static int creationDelayCounter;

	private static Knight knight;
	private static Enemy enemy;
	private static Bar bar;
	private static PlayerStatus player;
	private static boolean isPurpleOn;

	public static RedBox redbox = new RedBox(3, 45);
	public static RunnableThread runBox = new RunnableThread(redbox);
	private static Thread runThread = new Thread(runBox);

	public MainLogic() {
		initialize();
	}

	public void update() {
		if (!isPause && isStart) {
			// PAUSE
			if (InputUtility.isEnterTriggered() && !isPause()) {
				setPause(true);
				synchronized (redbox) {
					if (redbox.isMoving())
						redbox.setMoving(false);
				}
				System.out.println("pause");
				GameScreen.isPause = true;
				render.Resource.pauseSound.play();
				return;
			}

			// reset attack
			knight.isAttack = false;
			enemy.isAttack = false;

			// moving bar
			bar.move();

			// HIT SPACE
			if (InputUtility.isSpaceTriggered()) {

				if (boxes.size() != 0) {

					for (int i = boxes.size() - 1; i >= 0; i--) {
						Box b = boxes.get(i);
						if (b.isBarOn()) {
							if (b instanceof GreenBox) {
								knight.heal(10);
								b.setDestroyed(true);
								RenderableHolder.getInstance().getRenderableList().remove(b);
								boxes.remove(b);
							} else if (b instanceof BlackBox) {

								knight.attack(enemy);
								b.setDestroyed(true);
								RenderableHolder.getInstance().getRenderableList().remove(b);
								boxes.remove(b);

								synchronized (redbox) {
									if (!redbox.isMoving()) {
										redbox.setMoving(true);
										redbox.notifyAll();
									}
								}
							} else if (b instanceof PurpleBox) {
								b.setDestroyed(true);
								setPurpleOn(false);
								RenderableHolder.getInstance().getRenderableList().remove(b);
								boxes.remove(b);

								synchronized (redbox) {
									if (redbox.isMoving())
										redbox.setMoving(false);
								}
							}

							return;
						}

					}
				}
				enemy.attack(knight);
			}

			if (runBox.getBouncedCount() == 3) {
				runBox.setBouncedCount(0);
				enemy.attack(knight);
			}

			// DELAY
			if (creationDelayCounter != creationDelay) {
				creationDelayCounter++;
				return;
			}
			creationDelayCounter = 0;

			// CHECK DEAD
			if (knight.isDead) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				knight.isDestroyed = true;
			}
			if (enemy.isDead) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				enemy.isDestroyed = true;
			}
			// GENERATE BOX
			generateBox();

			// CREATE NEW ENEMY
			if (enemy.isDestroyed) {
				enemy = new Enemy(enemy.attack + 1, 50);
				RenderableHolder.getInstance().add(enemy);
				player.addScore(1);
				runBox.setBouncedCount(0);
			}

			// GAME OVER CHANGE TO INTRO
			if (knight.isDestroyed) {
				// knight.setDesTroyed(false);
				// knight.isDead = false;
				knight = new Knight(10, 50);
				RenderableHolder.getInstance().add(knight);
				setPause(true);
				HighScoreUtility.recordNewHighScore(player.getScore());
				Main.changeScreen(Main.INTRO);
			}
		}
		if (InputUtility.isEnterTriggered() && isPause()) {
			setPause(false);
			GameScreen.isPause = false;
			System.out.println("unpause");
			synchronized (redbox) {
				if (!redbox.isMoving()) {
					redbox.setMoving(true);
					redbox.notifyAll();
				}
			}
		}
	}

	public synchronized void generateBox() {
		double rand = Math.random() * 10;
		if (rand > 0 && rand < 2) {
			GreenBox g = new GreenBox(45, zBox);
			RenderableHolder.getInstance().add(g);
			boxes.add(g);
		} else if (rand < 3 && !isPurpleOn) {
			PurpleBox p = new PurpleBox(45, zBox);
			RenderableHolder.getInstance().add(p);
			boxes.add(p);
			setPurpleOn(true);
		} else {
			BlackBox y = new BlackBox(45, zBox);
			RenderableHolder.getInstance().add(y);
			boxes.add(y);
		}
		// UPDATE Z VALUE
		zBox++;
	}

	private static void initialize() {
		boxes = new ArrayList<Box>();
		knight = new Knight(10, 50);
		enemy = new Enemy(2, 50);
		bar = new Bar(50);
		player = new PlayerStatus();
		setPause(false);
		setPurpleOn(false);
		creationDelay = 70;
		creationDelayCounter = 0;
		redbox = new RedBox(3, 45);
		runBox = new RunnableThread(redbox);
		runThread = new Thread(runBox);
		RenderableHolder.getInstance().add(bar);
		RenderableHolder.getInstance().add(enemy);
		RenderableHolder.getInstance().add(knight);
		RenderableHolder.getInstance().add(player);
		RenderableHolder.getInstance().add(redbox);
	}

	public static void startgame() {
		isStart = true;
		isPause = false;
		initialize();
		runThread.start();
	}

	public static void endGame() {

		isStart = false;
		isPause = false;
		redbox.setDestroyed(true);
		RenderableHolder.getInstance().clear();
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public Knight getKnight() {
		return knight;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public Bar getBar() {
		return bar;
	}

	public PlayerStatus getPlayer() {
		return player;
	}

	public boolean isPurpleOn() {
		return isPurpleOn;
	}

	public static void setPurpleOn(boolean isPurpleOn) {
		MainLogic.isPurpleOn = isPurpleOn;
	}

	public static boolean isPause() {
		return isPause;
	}

	public static void setPause(boolean isPause) {
		MainLogic.isPause = isPause;
	}
}