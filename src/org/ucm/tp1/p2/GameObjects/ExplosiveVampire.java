package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class ExplosiveVampire extends Vampire{

	public ExplosiveVampire(int x, int y, Game game, int life, String s) {
		super(x, y, game, life, s);
	}
	
	public boolean receiveSlayerAttack(int damage) {
		decreaseLife(damage);
		explode();
		return true;
	}
	
	public boolean receiveExplosion() {
		super.receiveExplosion();
		explode();
		return true;
	}
	
	public boolean receiveLightFlash() {
		super.receiveLightFlash();
		explode();
		return true;
	}
	
	private void explode() {
		if(this.life <= 0) {
			int x = getX();
			int y = getY();
			for(int i = x-1; i<=x+1; i++) {
				for(int z = y-1; z<=y+1; z++) {
					if(!(i == x && z == y)) {
						IAttack g = this.game.getAttackableInPosition(i,z);
						if(g != null)g.receiveExplosion();
					}
					
				}
			}
		}
	}


}
