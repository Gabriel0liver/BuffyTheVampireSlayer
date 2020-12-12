package org.ucm.tp1.p2.GameObjects;

import org.ucm.tp1.p2.logic.Game;

public class ExplosiveVampire extends Vampire{

	public ExplosiveVampire(int x, int y, Game game, int life, String s) {
		super(x, y, game, life, s);
		// TODO Auto-generated constructor stub
	}
	
	public boolean receiveSlayerAttack(int damage) {
		decreaseLife(damage);
		if(this.life < 0) {
			IAttack up = this.game.getAttackableInPosition(getX(),getY()-1);
			IAttack down = this.game.getAttackableInPosition(getX(),getY()+1);
			IAttack left = this.game.getAttackableInPosition(getX()-1,getY());
			IAttack right = this.game.getAttackableInPosition(getX()+1,getY());
			if(up != null)up.receiveExplosion();
			if(down != null)down.receiveExplosion();
			if(left != null)left.receiveExplosion();
			if(right != null)right.receiveExplosion();
		}
		return true;
	}
	


}
