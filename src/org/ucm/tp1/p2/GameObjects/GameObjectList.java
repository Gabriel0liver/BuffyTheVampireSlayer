package org.ucm.tp1.p2.GameObjects;

import java.util.ArrayList;



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
				i--;					
				
			}
		}
		
	}
	
	
	
	public void add (GameObject g){
		this.gameObjects.add(g);
	}
	
	public void garlicPush(int dimX,int dimY) {
		GameObject g;
		
		
		for(int i=0; i-1<dimX;i++) {
			for(int j=0; j-1<dimY;j++) {
			 g = getObjectPosition(i,j);
			 if(g != null) {
			 g.receiveGarlicPush();
			 }
			}	 
		}
		
		
	}
	
	public void lightFlash() {
		for(int i=0; i<this.gameObjects.size();i++) {
			GameObject g = this.gameObjects.get(i);
			g.receiveLightFlash();
		}
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
