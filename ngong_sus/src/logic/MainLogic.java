package logic;

import java.util.ArrayList;
import input.InputUtility;
import render.RenderableHolder;
import logic.HighScoreUtility;

public class MainLogic {
	public static int boxZ;
	private static int zBox = 0;
	public static ArrayList<Box> boxes;
	private static boolean isPause;

	public int creationDelay;
	public int creationDelayCounter;

	private Knight knight;
	private Enemy enemy;
	private Bar bar;
	private PlayerStatus player;
	private boolean isPurpleOn;

	public static RedBox redbox = new RedBox(3, 25);
	public static RunnableThread runBox = new RunnableThread(redbox);
	private Thread runThread = new Thread(runBox);

	public MainLogic() {
		boxes = new ArrayList<Box>();
		knight = new Knight(10, 40, 50);
		enemy = new Enemy(2, 7, 50);
		bar = new Bar(50);
		player = new PlayerStatus();
		setPause(false);
		setPurpleOn(false);
		creationDelay = 70;
		creationDelayCounter = 0;
		RenderableHolder.getInstance().add(bar);
		RenderableHolder.getInstance().add(enemy);
		RenderableHolder.getInstance().add(knight);
		RenderableHolder.getInstance().add(player);
		RenderableHolder.getInstance().add(redbox);
		runThread.start();
	}

	public void update() {
		if (!isPause) {
			 // PAUSE
			 if (InputUtility.isEnterTriggered() && !isPause()) {
			 setPause(true);
			 
			 System.out.println("pause");
			 }
			 if (InputUtility.isEnterTriggered() && isPause()) {
			 setPause(false);
			 System.out.println("unpause");
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
								b.setDesTroyed(true);
								RenderableHolder.getInstance().getRenderableList().remove(b);
								boxes.remove(b);
							} else if (b instanceof YellowBox) {

								knight.attack(enemy);
								b.setDesTroyed(true);
								RenderableHolder.getInstance().getRenderableList().remove(b);
								boxes.remove(b);

								synchronized (redbox) {
									if (!redbox.isMoving()) {
										redbox.setMoving(true);
										redbox.notifyAll();
									}
								}
							} else if (b instanceof PurpleBox) {
								b.setDesTroyed(true);
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
				enemy = new Enemy(10, 20, 50);
				RenderableHolder.getInstance().add(enemy);
				player.addScore(1);
				runBox.setBouncedCount(0);
			}

			// GAME OVER CHANGE TO INTRO
			if (knight.isDestroyed) {
				// knight.setDesTroyed(false);
				// knight.isDead = false;
				setPause(true);
				HighScoreUtility.recordNewHighScore(player.getScore());
				Main.Main.changeScreen(Main.Main.INTRO);
			}
		}
	}

	public synchronized void generateBox() {
		double rand = Math.random() * 10;
		if (rand > 0 && rand < 2) {
			GreenBox g = new GreenBox(25, zBox);
			RenderableHolder.getInstance().add(g);
			boxes.add(g);
		} else if (rand < 3 && !isPurpleOn) {
			PurpleBox p = new PurpleBox(25, zBox);
			RenderableHolder.getInstance().add(p);
			boxes.add(p);
			setPurpleOn(true);
		} else {
			YellowBox y = new YellowBox(25, zBox);
			RenderableHolder.getInstance().add(y);
			boxes.add(y);
		}
		// UPDATE Z VALUE
		zBox++;
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

	public void setPurpleOn(boolean isPurpleOn) {
		this.isPurpleOn = isPurpleOn;
	}

	public static boolean isPause() {
		return isPause;
	}

	public static void setPause(boolean isPause) {
		MainLogic.isPause = isPause;
	}
}