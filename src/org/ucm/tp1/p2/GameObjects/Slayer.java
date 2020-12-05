package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p1.logic.Game;

public class Slayer extends GameObject{
	// lo de harm depende de cada slayer. parte 2 práctica
	
	private boolean alive;
	public static final int COST= 50;
	public static final int HARM = 1;
	
	
	public void Slayer(int x, int y, Game game, int life, String symblol) {
		super( x,  y,  game, life, symblol);
		
	}
	
	public void attack() {
		
		
		for(int i = x + 1; i < this.game.getDimX(); i++) {
			GameObject other = this.game.getObjectInPosition(i, y);
			if(other != null && other.receiveSlayerAttack(HARM)) {
				
			}
		
		
	}
}
