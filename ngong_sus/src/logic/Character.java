package logic;

import render.IRenderable;

public abstract class Character implements IRenderable {

	protected int life;
	protected int maxLife;
	protected int minAttack;
	protected int maxAttack;
	protected boolean isVisible;
	protected boolean isDestroyed;

	protected boolean isDead;
	protected boolean isAttack;
	protected int x,y,z;

	

	public Character(int minAttack, int maxAttack, int maxLife) {
		this.minAttack = minAttack;
		this.maxAttack = maxAttack;
		this.maxLife = maxLife;
		this.isDestroyed = false;
		this.isAttack = false;
		this.isDead = false;
		this.isVisible = true;
	}

	public void decreaseLife(int amount) {
		life -= amount;
		if (life <= 0) {
			life = 0;
			isDead=true;
		}
	}
	
	public void attack(Character c){
		/////////////////////////// chage attack
		c.decreaseLife(minAttack);
		isAttack = true;
	}
	
	

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDesTroyed(boolean b) {
		isDestroyed = b;
	}

}
