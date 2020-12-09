package org.ucm.tp1.p2.GameObjects;
import java.util.Random;
import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.logic.Level;

public class Vampire extends GameObject {
			
		public static final int HARM=1; //dagno
		public static  final int SPEED = 1; // avanza 1 casilla cada 2 ciclos; //hay que ponerle el final.
		private int nextStep;
		private static Level level = null;
		private static int vampirosPorSalir;
		private static int vampirosEnElTablero = 0;
		boolean alive;
		private Game game;
		
		public Vampire(int x, int y, Game game, int life, String s) {
			super(x, y, life, s);
			this.alive = true;
			this.game= game;
			this.nextStep = Vampire.SPEED;
			Vampire.vampirosEnElTablero ++;
			Vampire.vampirosPorSalir --;
			//el contador de vampiros no deberia estar en la clase game o gameObjectBoard?
		}
		
		public static void inicializarNivel(Level level) {
			if(Vampire.level == null) {
				Vampire.level = level;
				vampirosPorSalir = level.getNumV();
			}
		}
		
		public static int VampRest() {
			return Vampire.vampirosPorSalir;
		}
		
		public static int VampPres() {
			return Vampire.vampirosEnElTablero;
		}
		
		public static boolean doesAdd(Random rand) {
			return (rand.nextDouble() <= Vampire.level.getVampF());
		}
		
	
		
		
		public void move() {
			int x = getX();
			if(this.nextStep <= 0) {
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

		public void attack() {
			if(isAlive()) {
				IAttack other = game.getAttackableInPosition(getX()-1,getY()); 
				//no tengo ni idea que tengo que hacer con getAttackableInPosition
				
				if(other != null) {
					other.receiveVampireAttack(HARM);
				}
			}
		}

		//recibir Ataque
		default boolean receiveSlayerAttack(int damage) {
			decreaseLife(damage);
			return true;
			}
		default boolean receiveVampireAttack(int damage) {
			
			return false;
			}
		default boolean receiveLightFlash(){
			return false;
			}
		default boolean receiveGarlicPush(){
			return false;
			}
		default boolean receiveDraculaAttack(){
			return false;
			}
			
		

		
		public boolean quedanPorSalir() {
			return(Vampire.vampirosPorSalir > 0);
		}
		

	public int getLife() {
		return this.life;
	}
		
	
}
