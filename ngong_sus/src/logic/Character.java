package logic;

import render.IRenderable;

public abstract class Character implements IRenderable{
	
	protected int life;
	protected int maxLife;
	protected int minAttack;
	protected int maxAttack;
	protected boolean isVisible;
	protected boolean isDestroyed;
	protected int z;
	
	
	public Character(int minAttack, int maxAttack, int maxLife){
		this.minAttack = minAttack;
		this.maxAttack = maxAttack;
		this.maxLife = maxLife;
	}
	
	public void decreaseLife(int amount){
		life-=amount;
		if(life<=0){
			life = 0;
			isDestroyed = true;
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}
	
	
}
