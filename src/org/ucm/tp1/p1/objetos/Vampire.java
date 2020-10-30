package org.ucm.tp1.p1.objetos;

import java.util.Random;
import org.ucm.tp1.p1.logic.Game;

public class Vampire {
	private int x;
	private int y;
	private int life= 5;
	private Game game;
	public static final int HARM=1; //da�o
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
	
	
	public void move(SlayerList lista) {
		// recuerda que el vampiro pasa por encima de los cazadores muertos
		int i=0;
		boolean encontrado=false;
		
		while(!encontrado && i<lista.getContador()) {
			Slayer slayerLocal = lista.getS(i);
			if(slayerLocal.getXS() ==(this.x-1) && slayerLocal.getYS() == this.y) {
				encontrado = true;
				attack(slayerLocal);
			}
			
		}
		if(encontrado == false) {
			this.x--;
		}
		
		
		
		
	}
	public void attack(Slayer slayer) {// el game tiene que ejecutar el ataque
		
		
		
		
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
