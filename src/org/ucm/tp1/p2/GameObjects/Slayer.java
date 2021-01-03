package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class Slayer extends GameObject{

	
	private Game game;
	public static final int COST= 50;
	public static final int HARM = 1;
	
	
	public Slayer(int x, int y, Game game, int life, String s) {
		super(x, y, life, s);
		this.game= game;
		
	}
	
	public void move() {}
	
	public void attack() {
		if(isAlive()) {
			int y = getY();
			int x = getX() + 1;
			IAttack  other = null;
			while(x < this.game.getDimX() && other == null) {
				other = this.game.getObjectInPosition(x,y);
				if(other != null) {
					other.receiveSlayerAttack(this.HARM);
				}
				x++;
			}	
		}
	}
	
	//Recibir ataque

	 public boolean receiveVampireAttack(int damage) {

		decreaseLife(damage);
		return true;
		}
	
	public boolean receiveDraculaAttack(){
		this.kill();
		return true;
		}

	
}
