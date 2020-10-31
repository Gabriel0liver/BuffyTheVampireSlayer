package org.ucm.tp1.p1.objetos;

import org.ucm.tp1.p1.logic.Game;

public class SlayerList {
	private int MAX= 1000;
	private int cont = 0;

	private Slayer [] slayers;
	
		
	
	public SlayerList() {	// inicializador de la lista slayer
		this.slayers = new Slayer[MAX];
	}
	
	public void addS(Game game, int x, int y) {
		this.slayers[this.cont] = new Slayer(game,x,y);
		
		this.cont++;
	}

	public void limpiar(int ubicacion) {
		int i=ubicacion;
		while(i< this.cont) {
			slayers[i]=slayers[i+1];
			i++;
		}
		this.cont--;
	}
	
	
	
	
	public int getContador() {	
		return this.cont;
	}
	
	public Slayer getS(int x) {
		return this.slayers[x];
	}
	
	
}
