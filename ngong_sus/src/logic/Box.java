package logic;

import render.IRenderable;
import render.RenderableHolder;

public abstract class Box implements IRenderable {
	protected int minX, z;
	protected int length;
	protected boolean isDestroyed;
	protected boolean isVisible;

	public Box(int length, int z) {
		this.length = length;
		this.z = z;
	}

	public boolean isBarOn() {
		for (IRenderable r : RenderableHolder.getInstance().getRenderableList()) {
			if (r instanceof Bar) {
				if (((Bar) r).getX() - minX <= length && ((Bar) r).getX() >= minX)
					return true;
			}
		}
		return false;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	

}
