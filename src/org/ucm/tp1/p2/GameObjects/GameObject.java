package org.ucm.tp1.p2.GameObjects;


public abstract class GameObject implements IAttack {

	private int x;
	private int y;
	
	protected int life;
	private String symbol;
	
	
	public GameObject(int x, int y, int life, String s){
		this.x = x;
		this.y = y;
		this.life = life;
		this.symbol= s;
	}
	
	abstract public void move();
	
	
	public void decreaseLife(int harm) {
		this.life= this.life - harm;
	}
	public void kill() {
		this.life= 0;
	}
	
	
	public boolean isAlive() {
		boolean alive = true;
		if (this.life <= 0) {
			alive = false;
		}
		
	return alive;	
	}


	public int getX() {
		return this.x;
	
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y=y;
	}

	public String toString() {
		String s= this.symbol+"["+this.life+"]";
		return s;
	}
 
 
 }
