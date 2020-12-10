package org.ucm.tp1.p2.GameObjects;

import java.util.ArrayList;

import org.ucm.tp1.p2.logic.Game;

public class GameObjectList {
	private ArrayList<GameObject> gameObjects;
	
	
	public GameObjectList() {
		this.gameObjects = new ArrayList<GameObject>();
	}
	
	
	public void move() {
		for(int i=0; i<this.gameObjects.size();i++) {
			GameObject g = this.gameObjects.get(i);
			g.move();
		}
		
	}
	public void attack(){
		for(int i=0; i<this.gameObjects.size();i++) {
			GameObject g = this.gameObjects.get(i);
			g.attack();
		}
		
	}
	public void removeDead() {
		GameObject g;
		for(int i=0; i<this.gameObjects.size();i++) {
			 g = this.gameObjects.get(i);
			if(g.isAlive()== false) {
				this.gameObjects.remove(i);
				i--;					//como has quitado un objeto del array, entonces en la misma ubicaci�n est� el obj siguiente
			}
		}
		
	}
	
	
	
	public void add (GameObject g){
		this.gameObjects.add(g);
	}
	
	public GameObject getObjectPosition(int x, int y) {
		int i=0;
		GameObject g= null;
		boolean encontrado= false;
		
		while(!encontrado && i<this.gameObjects.size()) {
			GameObject gameObject= null;
			gameObject = this.gameObjects.get(i);
			 if(x == gameObject.getX() && y == gameObject.getY()) {
				 encontrado = true;
				 g = gameObject;
			 }
			i++;
		}
		
		
		return g;
		
	}
	
	public boolean isPositionEmpty(int x, int y) {
		boolean empty = false;
		GameObject g;
		
		g = getObjectPosition(x,y);
		
		if(g == null) {
			empty = true;
		}

		return empty;
	}
	
	
	
	public int getSize() {
		return this.gameObjects.size();
	}
	
	
	
	
}
