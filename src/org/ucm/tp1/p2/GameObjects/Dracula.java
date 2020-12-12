package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class Dracula extends Vampire {

	public Dracula(int x, int y, Game game, int life, String s) {
		super(x, y, game, life, s);
		// TODO Auto-generated constructor stub
	}
	
	public void attack() {
		if(isAlive()) {
			IAttack other = this.game.getAttackableInPosition(getX()-1,getY()); 
			if(other != null) {
				other.receiveDraculaAttack();
			}
		}
	}
	
	public boolean receiveLightFlash() {
		return false;
	}

}
