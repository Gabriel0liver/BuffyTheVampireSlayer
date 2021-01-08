package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class Bank extends GameObject{
	private Game game;
	public static final int COST= 50;
	public static final int HARM = 1;
	
	
	public Bank(int x, int y,int life, Game game, int z, String s) {
		super(x, y, life, s);
		this.nextStep = z;
		this.game= game;
		
	}
	
	public void move() {
		this.game.bank(this.nextStep/10);
	}
	
	public void attack() {}
	
	//Recibir ataque

	 public boolean receiveVampireAttack(int damage) {
		this.kill();
		return true;
		}
	
	public boolean receiveDraculaAttack(){
		this.kill();
		return true;
		}
}
