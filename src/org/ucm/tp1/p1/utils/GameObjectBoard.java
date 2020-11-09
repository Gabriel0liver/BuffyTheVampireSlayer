package org.ucm.tp1.p1.utils;

import org.ucm.tp1.p1.objetos.Slayer;
import org.ucm.tp1.p1.objetos.SlayerList;
import org.ucm.tp1.p1.objetos.Vampire;
import org.ucm.tp1.p1.objetos.VampireList;
import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.logic.Level;

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
	
	
	
	public void update() {//actualiza los objetos
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
			if(vampiroLocal.isAlive()) {
				vampiroLocal.attack();		
			}	
		}	
	}
	private void move() {	
		for(int i=0;i<this.vampireList.getContador();i++){
			Vampire vampiroLocal = this.vampireList.getV(i);
			int j=0;
			boolean puede=true;
			while( j<this.slayerList.getContador() && puede) {
				Slayer slayerLocal = this.slayerList.getS(j);
				if(slayerLocal.getXS()== (vampiroLocal.getXV()-1) && slayerLocal.getYS() == vampiroLocal.getYV()) {
					puede = false;
				}
				j++;
			}
			if(puede) {
				vampiroLocal.move();
			}
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
	
	
	public boolean attackS(int x, int y,int harm) {//el slayer pega un tiro al vampiro
		boolean encontrado=false;
		Vampire vampiroLocal= this.buscarVampire(x, y);
		if(vampiroLocal != null) {
			vampiroLocal.decreaseLife(harm);
			encontrado=true;
		}
		return encontrado;
	
	}
	public void attackV(int x, int y,int harm) {//el vampiro muerde al slayer
		Slayer slayerLocal= this.buscarSlayer(x, y);
		if(slayerLocal != null) {
			slayerLocal.decreaseLife(harm);
		}
	}
	
	
	public Vampire buscarVampire(int x, int y) {
		boolean  encontrado=false;
		int i=0;
		while(i<this.vampireList.getContador() && !encontrado) {
			Vampire vampiroLocal = this.vampireList.getV(i);
			if( vampiroLocal.getXV() == x && vampiroLocal.getYV() == y) {
				 encontrado = true; 
				 return this.vampireList.getV(i);
			}
			i++;
		}	
			return null;	
	}
	public Slayer buscarSlayer (int x, int y) {
		boolean  encontrado=false;
		int i=0;
		while(i<this.slayerList.getContador() && !encontrado) {
			Slayer SlayerLocal = this.getS(i);
			if( SlayerLocal.getXS() == x &&SlayerLocal.getYS() == y) {
				 encontrado = true;
				 return this.slayerList.getS(i);
			}
			i++;
		}
		return null;
		
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
