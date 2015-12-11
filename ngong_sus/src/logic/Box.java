package logic;

import render.IRenderable;
import render.RenderableHolder;

public abstract class Box implements IRenderable {
	int minX, z;
	int length;
	boolean isDestroyed;
	boolean isVisible;

	public Box(int length, int z) {
		this.length = length;
		this.z = z;
	}

	public boolean isBarOn() {
		for (IRenderable r : RenderableHolder.getInstance().getRenderableList()) {
			if (r instanceof Bar) {
				if (((Bar) r).x - minX <= length )
					return true;
			}
		}
		return false;
	}

	public void setDesTroyed(boolean b) {
		isDestroyed = b;

	}

}
