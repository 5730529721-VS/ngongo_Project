package render;

import java.awt.Graphics2D;

public interface IRenderable {
	void draw(Graphics2D g2d);
	int getZ();
	boolean isVisible();
	boolean isDestroyed();
}
