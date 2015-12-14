package logic;

public class RunnableThread implements Runnable {
	private RedBox r;
	private int bouncedCount;

	public RunnableThread(RedBox r) {
		super();
		this.r = r;
		this.bouncedCount = 0;

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
				synchronized (r) {
					r.move();
					if (!r.isMoving()) {
						r.wait();
					}
					if (r.isBouncing()){
						r.flipDirection();
						bouncedCount++;
					}
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public void setBouncedCount(int bouncedCount) {
		if (bouncedCount < 0) bouncedCount = 0;
		this.bouncedCount = bouncedCount;
	}

	public int getBouncedCount() {
		return bouncedCount;
	}

}
