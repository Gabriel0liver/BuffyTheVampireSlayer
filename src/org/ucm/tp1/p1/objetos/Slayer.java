package org.ucm.tp1.p1.objetos;


import org.ucm.tp1.p1.logic.Game;

public class Slayer {
	private int x,y;
	private int life= 3;
	private Game game;
	private boolean alive;
	public static final int COST= 50;
	public static final int HARM = 1; //da�o
	
	
	
	public Slayer(Game game, int x, int y) {
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
	public boolean attack(VampireList vampireList, int i) { // el game tiene que ejecutar el ataque
		//busca al vampiro que has disparado y devuelve que vampiro fue disparado, 
		
		
		 i = 0; //ubicacion
		int shot = this.x;
		boolean success = false;
		while(shot < this.game.level.dimensionx()  || success== false) { // longitud de x, esta en this.game.
			
			Vampire localVampire = vampireList.getV(i);
			//DUDA : si manipulo el local vampire entonces tambi�n manipulo vampiros[i]?
			//considerar� que se puede ya que "insertar argumento punteros"
			
			while( i<vampireList.getContador() || success == false) {
				
				int xLocal =localVampire.getX();
				int yLocal = localVampire.getY();
				
				if(yLocal == this.y && xLocal==shot) {
					success= true;
					localVampire.decreaseLife(this.HARM);
				}
			
				i++;
			}
			shot++;
		}
		i--;
		return success;
	}
	
	
	
	public void toString{
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
}
