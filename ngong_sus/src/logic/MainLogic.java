package logic;

import java.util.ArrayList;

import render.RenderableHolder;

public class MainLogic {
	public static int boxZ;
	public int creationDelay;
	public int creationDelayCounter;
	private ArrayList<Box> boxes;
	private Knight knight;
	private Enemy enemy;
	private Bar bar;
	private boolean isPause;

	public MainLogic() {
		boxes = new ArrayList<Box>();
		knight = new Knight(1, 5, 50);
		enemy = new Enemy(2, 7, 50);
		bar = new Bar();
		setPause(false);
		creationDelay = 5;
		creationDelayCounter = 0;

	}

	// public void start(){
	// while(true){
	// try {
	// Thread.sleep(20);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	//
	// }
	// }

	public void update() {
		if (creationDelayCounter != creationDelay) {
			creationDelayCounter++;
			return;
		}
		creationDelayCounter = 0;
		if (knight.isDead) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			knight.isDestroyed = true;
		}
		if (enemy.isDead) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			enemy.isDestroyed = true;
		}
		generateBox();
		// if(InputUtility.getKeyPressed()){
		for (int i = boxes.size(); i >= 0; i--) {
			Box b = boxes.get(i);
			if (b.isBarOn()) {
				if (b instanceof GreenBox) {
					knight.heal(10);
					b.setDesTroyed(true);
				} else if (b instanceof YellowBox) {
					knight.attack(enemy);
					b.setDesTroyed(true);
				} else if (b instanceof RedBox) {
					b.setDesTroyed(true);
				} /*
					 * else if(b instanceof PurpleBox){ b.setDesTroyed(true);
					 * synchronized (b) { try { b.wait(); } catch
					 * (InterruptedException e) { // TODO Auto-generated catch
					 * block e.printStackTrace(); } } }
					 */
				for (Box b1 : boxes) {
					if (b1 instanceof RedBox) {
						((RedBox) b1).move();
						if (b1.minX <= 0) {
							b1.setDesTroyed(true);
							enemy.attack(knight);
						}
					}
				}
				break;
			}
			for (Box b1 : boxes) {
				if (b1 instanceof RedBox) {
					((RedBox) b1).move();
					if (b1.minX <= 0) {
						b1.setDesTroyed(true);
						enemy.attack(knight);
					}
				}
			}
			// }

		}

	}

	public void generateBox() {
		double rand = Math.random() * 4;
		if (rand > 0 && rand < 1) {
			RenderableHolder.getInstance().add(new RedBox((int) (Math.random() * 10), (int) (Math.random() * 5)));
		} else if (rand < 2) {
			RenderableHolder.getInstance().add(new GreenBox((int) (Math.random() * 20)));
		} else if (rand < 3) {
			RenderableHolder.getInstance().add(new PurpleBox((int) (Math.random() * 10)));
		} else {
			RenderableHolder.getInstance().add(new YellowBox((int) (Math.random() * 30)));
		}
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
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

}
