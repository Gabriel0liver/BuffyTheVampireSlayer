package org.ucm.tp1.p1.objetos;

import java.util.Random;
import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.logic.Level;

public class Vampire {
	private int x;
	private int y;
	private int life= 5;
	private Game game;
	public static final int HARM=1; //dagno
	public static  final int SPEED = 1; // avanza 1 casilla cada 2 ciclos; //hay que ponerle el final.
	private int nextStep;
	private static Level level = null;
	private static int vampirosPorSalir;
	private static int vampirosEnElTablero = 0;
	boolean alive;
	
	public Vampire(Game game,int x, int y) {
		this.x=x;
		this.y=y;
		this.game = game;
		this.alive = true;
		this.nextStep = Vampire.SPEED;
		Vampire.vampirosEnElTablero ++;
		Vampire.vampirosPorSalir --;
	}
	
	public static void inicializarNivel(Level level) {
		if(Vampire.level == null) {
			Vampire.level = level;
			vampirosPorSalir = level.getNumV();
		}
	}
	
	public static int VampRest() {
		return Vampire.vampirosPorSalir;
	}
	
	public static int VampPres() {
		return Vampire.vampirosEnElTablero;
	}
	
	public static boolean doesAdd(Random rand) {
		return (rand.nextDouble() <= Vampire.level.getVampF());
	}
	
public boolean isAlive() {
		
		if (this.life <= 0 && this.alive) {
			this.alive = false;
			Vampire.vampirosEnElTablero --;
		}
		
	return this.alive;	
	}
	public void decreaseLife(int harm) {
		this.life= this.life -harm;
	}
	
	
	public void move() {
		if(this.nextStep <= 0) {
			this.x --;
			this.nextStep = Vampire.SPEED;
			if(this.x < 0) {
				this.game.setGO(true);
			}
		}else {
			this.nextStep --;
		}
		
	}
	
	
	public void attack() {// el game tiene que ejecutar el ataque
		this.game.attackV(this.x-1,this.y,Vampire.HARM);
		
	}
	public String toString(){
		String s = "V ["+this.life+"]";
		
		return s;
				
	}
	
	public boolean quedanPorSalir() {
		return(Vampire.vampirosPorSalir > 0);
	}
	
	
	public int getXV() {
		
		return this.x;
	}
public int getYV() {
		
		return this.y;
	}

public int getLife() {
	return this.life;
}
	
}
