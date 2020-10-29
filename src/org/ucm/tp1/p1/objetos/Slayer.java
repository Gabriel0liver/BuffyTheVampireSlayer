package org.ucm.tp1.p1.objetos;


import org.ucm.tp1.p1.logic.Game;

public class Slayer {
	private int x,y;
	private int life= 3;
	private Game game;
	private boolean alive;
	public static final int COST= 50;
	public static final int HARM = 1;
	
	
	
	public Slayer(Game game, int x, int y) {
		this.x=x;
		this.y=y;
		this.game = game;
		this.alive = true;
		
	}
	public boolean isAlive( int i) {
		
		if (i <= 0) {
			this.alive = false;
		}
		
	return this.alive;	
	}

	
	public void decreaseLife() {
		this.life--;
		
		isAlive(this.life);
	}
	public void attack() {
		int i = 0;
		int shot = this.x;
		boolean success = false;
		while(shot < this.game.level.dimx  || success== false) { // longitud de x, esta en this.game.
		while( i >this.game.board.vampireList.cont || success == false) {
			if(this.game.board.vampireList.vampiros[i].y.equals(this.y) && this.game.board.vampireList.vampiros[i].x.equals(shot)) {
				success= true;
			}
			
			i++;
		}
		shot++;
		}
	}
	public void toString{
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
