package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class Dracula extends Vampire {
	
	private static boolean isAlive;

	public Dracula(int x, int y, Game game, int life, String s) {
		super(x, y, game, life, s);
		Dracula.isAlive = true;
	}
	
	public void attack() {
		if(isAlive()) {
			IAttack other = this.game.getAttackableInPosition(getX()-1,getY()); 
			if(other != null) {
				other.receiveDraculaAttack();
			}
		}
	}
	
	public static boolean isDAlive() {
		return Dracula.isAlive;
	}
	
	public static void resetDracula() {
		Dracula.isAlive = false;
	}
	
	public boolean receiveSlayerAttack(int harm){
		super.receiveSlayerAttack(harm);
		if (!isAlive()) Dracula.isAlive=false;
		return true;
	}
	
	public boolean receiveLightFlash() {
		return false;
	}

	public boolean receiveGarlicPush() {
		super.receiveGarlicPush();
		if (!isAlive()) Dracula.isAlive=false;
		return true;
	}
	
	public boolean receiveExplosion() {
		super.receiveExplosion();
		if (!isAlive()) Dracula.isAlive=false;
		return true;
	}
	
}
