package org.ucm.tp1.p1.objetos;

import org.ucm.tp1.p1.logic.Game;

public class Vampire {
	private int x;
	private int y;
	private int life= 5;
	private Game game;
	public static final int HARM=1; //daño
	public static final int SPEED = 2; // avanza 1 casilla cada 2 ciclos;
	private Random rand;
	boolean alive;
	
	public Vampire(Game game,int x, int y) {
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
		this.life= this.life -harm;
		
		isAlive();
	}
	
	
	public void move() {
		// recuerda que el vampiro pasa por encima de los cazadores muertos
		
		
		
		
	}
	public void attack(SlayerList slayerList, int i) {// el game tiene que ejecutar el ataque
		
		
		
		
	}
	public void toString{
		
	}
	
	
	public int getX() {
		
		return this.x;
	}
public int getY() {
		
		return this.y;
	}
	
}
