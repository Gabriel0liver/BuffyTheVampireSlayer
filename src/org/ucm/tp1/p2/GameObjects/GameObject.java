package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;
public abstract class GameObject implements IAttack {

	protected int x;
	protected int y;
	protected Game game;
	protected int life;
	protected String symbol;
	
	
	public GameObject(int x, int y, Game game, int life, String s){
		this.x = x;
		this.y = y;
		this.game= game;
		this.symbol= s;
		
		
	}
	
	abstract public void move();
	
	
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

 public String toString() {
	 String s= this.symbol+"["+this.life+"]";
	 return s;
 }
 
 
 }
