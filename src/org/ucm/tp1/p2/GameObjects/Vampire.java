package org.ucm.tp1.p2.GameObjects;
import java.util.Random;
import org.ucm.tp1.p2.logic.Game;
import org.ucm.tp1.p2.logic.Level;

public class Vampire extends GameObject {
			
		public static final int HARM=1; //dagno
		public static  final int SPEED = 1; // avanza 1 casilla cada 2 ciclos; //hay que ponerle el final.
		private int nextStep;
		private static Level level = null;
		private static int vampirosPorSalir;
		private static int vampirosEnElTablero = 0;
		boolean alive;
		boolean pushed;
		private Game game;
		
		public Vampire(int x, int y, Game game, int life, String s) {
			super(x, y, life, s);
			this.alive = true;
			this.game= game;
			this.nextStep = Vampire.SPEED;
			Vampire.vampirosEnElTablero ++;
			Vampire.vampirosPorSalir --;
			this.pushed=false;
		}
		
		public static void inicializarNivel(Level level) {
			if(Vampire.level == null) {
				Vampire.level = level;
				vampirosPorSalir = level.getNumberOfVampires();
			}
		}
		
		public static int VampRest() {
			return Vampire.vampirosPorSalir;
		}
		
		
		public static int VampPres() {
			return Vampire.vampirosEnElTablero;
		}
		
		public static boolean doesAdd(Random rand) {
			return (rand.nextDouble() <= Vampire.level.getVampireFrequency());
		}
		
	
		
		
		public void move() {
			int x = getX();
			int y = getY();
			if(this.nextStep <= 0 && game.getObjectInPosition(x-1, y) == null) {
				x --;
				this.nextStep = Vampire.SPEED;
				setX(x);
				
				if(x < 0) {
					this.game.setGO(true);
				}
			}
			else {
				this.nextStep --;
			}
			
		}
		public void push(){
			
			
			int x = getX();
			int y = getY();
			int limX = game.getDimX();
			if(pushed == false) {
				if(game.getObjectInPosition(x+1, y) == null ) {
					
					if(x-1>= limX) {//el vampiro muere 
						this.decreaseLife(100000);
					}
					
					x ++;
					setX(x);
					nextStep = 1;
					pushed = true;
				}
				
			}
			else
				pushed = false;

		}
		

		public void attack() {
			if(isAlive()) {
				IAttack other = game.getAttackableInPosition(getX()-1,getY()); 
				
				if(other != null) {
					other.receiveVampireAttack(HARM);
				}
			}
		}


		public boolean receiveSlayerAttack(int damage) {
			decreaseLife(damage);
			return true;
			}
		public boolean receiveGarlicPush(){
			push();
			return true;
		};
		
		public boolean quedanPorSalir() {
			return(Vampire.vampirosPorSalir > 0);
		}
		

		
		
	
}
