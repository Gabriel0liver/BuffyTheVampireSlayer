package org.ucm.tp1.p1.objetos;

import java.util.Random;
import org.ucm.tp1.p1.logic.Game;

public class Vampire {
	private int x;
	private int y;
	private int life= 5;
	private Game game;
	public static final int HARM=1; //dagno
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
		if(this.x != 0) {
			nextStep();
			if(this.SPEED == 0) {
				this.x--;
				nextStep();
			}
		}
		else{
			//game over
		}
		
		
	}
	public void nextStep() {
		if(this.SPEED != 0) {
			this.SPEED--;
		}
		else
			this.SPEED = 2;
	}
	
	
	public void attack() {// el game tiene que ejecutar el ataque
		this.game.attackV();
	}
	public void toString{
		
	}
	
	
	public int getXV() {
		
		return this.x;
	}
public int getYV() {
		
		return this.y;
	}
	
}
