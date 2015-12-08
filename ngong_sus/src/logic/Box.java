package logic;

public abstract class Box implements IRenderable{
	int minX;
	int length;
	
	public Box(){
		
	}
	
	public boolean isBarOn(){
		if(MainLogic.instance.bar.x-minX <= length){
			return true;
		}
		else return false;
	}
	
	
}
