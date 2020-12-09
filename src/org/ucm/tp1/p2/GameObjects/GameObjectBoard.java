package org.ucm.tp1.p2.GameObjects;

public class GameObjectBoard {
		private GameObjectList gameobjects;
		
		public GameObjectBoard(GameObject g) {
			this.gameobjects.add(null);
		}
		
		public void update(){
			
			this.gameobjects.move();
			this.gameobjects.attack();
			this.gameobjects.removeDead();
		}
		
		
		public void add(GameObject g){
			this.gameobjects.add(g);
		}
		
		public GameObject getObjectInPosition(int x,int y) {
			return this.gameobjects.getObjectPosition(x, y);
		}
		
		public boolean isPositionEmpty(int x,int y) {
			return this.gameobjects.isPositionEmpty(x, y);
			
		}
		
		public String positionToString(int x, int y) {
			GameObject g = this.gameobjects.getObjectPosition(x, y);
		
			return g.toString();
		}
		
		
		
		public IAttack getAttackableInPosition(int x, int y) {//no creo que esté bien.
			return this.gameobjects.getObjectPosition(x, y);
			
		}
			
		
}
