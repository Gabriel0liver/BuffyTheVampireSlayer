package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class Bank extends GameObject{
	private int z;
	private Game game;
	public static final int COST= 50;
	public static final int HARM = 1;
	
	
	public Bank(int x, int y,int z, Game game, int life, String s) {
		super(x, y, z, s);
		this.z = z;
		this.game= game;
		
	}
	
	public void move() {
		this.game.bank(this.z);
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
