package logic;

import render.IRenderable;
import render.RenderableHolder;

public abstract class Box implements IRenderable{
	int minX;
	int length;
	
	public Box(int length){
		this.length = length;
	}
	
	public boolean isBarOn(){
		for(IRenderable r : RenderableHolder.getInstance().getRenderableList()){
			if (r instanceof Bar){
				if (((Bar)r).x-minX <= length)
			return true;
			}
		}
		return false;
	}
	
	
}
