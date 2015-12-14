package logic;

public class RunnableThread implements Runnable {
	IMovable m;

	public RunnableThread(IMovable m) {

		this.m = m;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (m) {
				m.move();
				if (!m.isMoving() && m instanceof RedBox){
					try {
						((RedBox)m).wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
