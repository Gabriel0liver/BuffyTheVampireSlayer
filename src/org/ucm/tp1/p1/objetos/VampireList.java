package org.ucm.tp1.p1.objetos;


import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.logic.Level;

public class VampireList {
	private int MAX= 1000;
	private int cont = 0;

	private Vampire [] vampiros;
	
		
	
	public VampireList() {	// inicializador de la lista vampire
		this.vampiros = new Vampire[MAX];
		
	}
	
	public void addV(Game game, int x, int y) {
		this.vampiros[this.cont] = new Vampire(game,x,y);
		this.cont++;
	}
	
	public void limpiar(int ubicacion) {
		int i=ubicacion;
		while(i< this.cont) {
			vampiros[i]=vampiros[i+1];
			i++;
		}
		this.cont--;
	}
	
	
	
	public int getContador() {
		return this.cont;
	}
	
	public Vampire getV(int x) {
		return this.vampiros[x];
	}
	
	
}
