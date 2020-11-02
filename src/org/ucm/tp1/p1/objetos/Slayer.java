package org.ucm.tp1.p1.objetos;


import org.ucm.tp1.p1.logic.Game;

public class Slayer {
	private int x,y;
	private int life= 3;
	private Game game;
	private boolean alive;
	public static final int COST= 50;
	public static final int HARM = 1; //da�o
	
	
	
	public Slayer(Game game, int x, int y) {
		this.x=x;
		this.y=y;
		this.game = game;
		this.alive = true;
		
	}
	public boolean isAlive() {
		
		if (this.life <= 0) {
			this.alive = false;
		}
		
	return this.alive;	
	}

	
	public void decreaseLife(int harm) {
		this.life= this.life - harm;
	}
	
	public void attack() { // el game tiene que ejecutar el ataque
		int ubicacion = this.x+1;
		boolean atacado=false;
		
		while(!atacado && ubicacion < this.game.level.dimensionx()) {
			int harm = this.HARM;
			atacado = this.game.attackS(ubicacion,this.y,harm);
			ubicacion++;
		}
	}
		
	
	public String toString(){
		String s = "S ["+this.life+"]";
		
		return s;
				
	}
	
	public int getLife() {
		return this.life;
	}
	
	
public int getXS(){
	return this.x;	
}
public int getYS(){
	return this.y;	
}
	

}
