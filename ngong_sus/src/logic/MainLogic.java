package logic;

import java.util.ArrayList;

import input.InputUtility;
import render.GameScreen;
import render.IRenderable;
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
	private static int zBox=0;

	public MainLogic() {
		boxes = new ArrayList<Box>();
		knight = new Knight(1, 5, 50);
		enemy = new Enemy(2, 7, 50);
		bar = new Bar(0);
		setPause(false);
		creationDelay = 50;
		creationDelayCounter = 0;
		RenderableHolder.getInstance().add(bar);
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
		// moving jaa
		bar.move();
		for (Box b1 : boxes) {
			if (b1 instanceof RedBox) {
				((RedBox) b1).move();

			}
		}

		// HIT SPACE
		if (InputUtility.isSpaceTriggered()) {

			if (boxes.size() != 0) {

				for (int i = boxes.size() - 1; i >= 0; i--) {
					Box b = boxes.get(i);
					if (b.isBarOn()) {
						if (b instanceof GreenBox) {
							knight.heal(10);
							b.setDesTroyed(true);
							System.out.println("yeah");
						} else if (b instanceof YellowBox) {

							knight.attack(enemy);
							b.setDesTroyed(true);
							
						} else if (b instanceof RedBox) {
							b.setDesTroyed(true);
							
						} else if (b instanceof PurpleBox) {
							b.setDesTroyed(true);
							
//							synchronized (b) {
//								try {
//									b.wait();
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//							}
						}

						for (Box b1 : boxes) {
							if (b1 instanceof RedBox) {

								if (b1.minX >= GameScreen.screenWidth) {
									b1.setDesTroyed(true);
									enemy.attack(knight);
								}
							}
						}
						break;
					}
					for (Box b1 : boxes) {
						if (b1 instanceof RedBox) {

							if (b1.minX >= GameScreen.screenWidth) {
								b1.setDesTroyed(true);
								enemy.attack(knight);
							}
						}
					}
				}
			}

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
		// GENERATE
		generateBox();
		// if(InputUtility.getKeyPressed()){
		if (boxes.size() != 0) {
			for (int i = boxes.size()-1; i >= 0; i--) {
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
			}
			// }

		}


	}

	public synchronized void generateBox() {
		double rand = Math.random() * 4;
		if (rand > 0 && rand < 1) {
			RedBox r = new RedBox((int) (Math.random() * 2), (int) (Math.random() * 20),zBox);
			RenderableHolder.getInstance().add(r);
			boxes.add(r);
		} else if (rand < 2) {
			GreenBox g = new GreenBox((int) (Math.random() * 20),zBox);
			RenderableHolder.getInstance().add(g);
			boxes.add(g);
		} else if (rand < 3) {
			PurpleBox p = new PurpleBox((int) (Math.random() * 10),zBox);
			RenderableHolder.getInstance().add(p);
			boxes.add(p);
		} else {
			YellowBox y = new YellowBox((int) (Math.random() * 30),zBox);
			RenderableHolder.getInstance().add(y);
			boxes.add(y);
		}
		
		zBox++;
		//redbox higher than others  ?
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
