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
	
public void addV() {
		this.vampireList.addV(this.game,);
		
	}
	
public void addS (int x, int y) {
	this.slayerList.addS(this.game,x, y);
}

public Vampire getV(int x) {
	return this.vampireList.getV(x);
}
public Slayer getS(int x) {
	return this.slayerList.getS(x);
}
	
	
	
	
}
