package org.ucm.tp1.p1.utils;

import org.ucm.tp1.p1.objetos.Slayer;
import org.ucm.tp1.p1.objetos.SlayerList;
import org.ucm.tp1.p1.objetos.Vampire;
import org.ucm.tp1.p1.objetos.VampireList;
import org.ucm.tp1.p1.logic.Game;

public class GameObjectBoard {
	
	
	private VampireList vampireList;
	private SlayerList slayerList;
	private Game game;
		
	public GameObjectBoard(Game game) {	
		this.vampireList = new VampireList();
		this.slayerList = new SlayerList();
		this.game = game;
	}
	
	public void addV(int x, int y) {
			this.vampireList.addV(this.game, x, y);
			
		}
		
	public void addS (int x, int y) {
		this.slayerList.addS(this.game,x, y);
	}
	
	
	
	public void update() {
		
		move();
		attack();
		limpiar();
		
		
		
		
	}
	private void attack() {
		
		for(int i = 0; i<this.slayerList.getContador();i++) {
			Slayer slayerLocal = this.slayerList.getS(i);
			slayerLocal.attack();
		}
		
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampiroLocal = this.vampireList.getV(i);
			vampiroLocal.attack();			
		}	
	}

	private void move() {

		boolean puede=true;
		int j=0;
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampiroLocal = this.vampireList.getV(i);
			while( j<this.slayerList.getContador() && !puede) {
				Slayer slayerLocal = this.slayerList.getS(j);
				if(slayerLocal.getXS()== (vampiroLocal.getXV()-1) && slayerLocal.getYS() == vampiroLocal.getYV()) {
					puede = false;
				}
				j++;
			}
			if(puede) {
				vampiroLocal.move();
			}
				
			puede = true;
		}	
	}

	private void limpiar() {
		for(int i = 0; i<this.slayerList.getContador();i++) {
			Slayer slayerLocal = this.slayerList.getS(i);
			if(!slayerLocal.isAlive()) {
				this.slayerList.limpiar(i);
			}
		}
		
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampiroLocal = this.vampireList.getV(i);
			if(!vampiroLocal.isAlive()) {
				this.vampireList.limpiar(i);
			}
		}	
	}
	public boolean attackS(int x, int y) {//el slayer pega un tiro
		boolean encontrado=false;
		int ubicacion =0;
		encontrado = this.vampireList.encontrarVampiroDisparado(x, y, ubicacion);
		
		if (encontrado = true) {
		
		}
		
		return encontrado;
	
	}
	public void attackV(int x, int y) {
		
	}
	
	public Vampire getV(int x) {
		return this.vampireList.getV(x);			
	}
	public Slayer getS(int x) {
		return this.slayerList.getS(x);
	}
	
	public VampireList getVL() {
		return this.vampireList;
	}
	public SlayerList getSl() {
		return this.slayerList;
	}
	
}
