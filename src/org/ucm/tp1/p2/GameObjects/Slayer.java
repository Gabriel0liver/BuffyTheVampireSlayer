package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class Slayer extends GameObject{

	
	private Game game;
	private boolean alive;
	public static final int COST= 50;
	public static final int HARM = 1;
	
	
	public Slayer(int x, int y, Game game, int life, String s) {
		super(x, y, life, s);
		this.alive=true;
		this.game= game;
		
	}
	
	public void move() {}
	
	public void attack() {
		if(isAlive()) {
			int y = getY();
			for(int i = getX() + 1; i < this.game.getDimX(); i++) {
				IAttack  other = this.game.getObjectInPosition(i,y);
				if(other != null) {
					other.receiveSlayerAttack(this.HARM);
				}
					
			}
		}
		
	}
	
	//Recibir ataque
	 public boolean receiveVampireAttack(int damage) {
		decreaseLife(damage);
		return true;
		}
	
	public boolean receiveDraculaAttack(){
		alive = false;
		return true;
		}

	
}
