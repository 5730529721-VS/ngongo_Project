package logic;

import render.IRenderable;

public interface IMovable extends IRenderable{
	boolean isMoving();
	void move();
	
}
