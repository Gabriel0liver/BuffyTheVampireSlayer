package org.ucm.tp1.p1.logic;

import java.util.Random;

import org.ucm.tp1.p1.objetos.Player;
import org.ucm.tp1.p1.utils.GameObjectBoard;
import org.ucm.tp1.p1.view.GamePrinter;

public class Game {
	public GameObjectBoard board;
	private int dim_x;
	private int dim_y;
	private int contadorCiclos;
	private GamePrinter printer;
	private boolean GameOver;
	private Random rand;
	private Player player;
	public Long seed;
	public Level level;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.dim_x = this.level.dimensionx();
		this.dim_y = this.level.dimensiony();
		this.printer = new GamePrinter(this, this.dim_x, this.dim_y);
		this.rand = new Random(seed);
		this.player = new Player(this.rand);
		this.board = new GameObjectBoard(this);
		this.contadorCiclos = 0;
		this.GameOver = false;
	}
	
	public boolean addSlayer(int x, int y) {
		
		return true;
	}
	
	public void addVampire() {
		
	}
	
	
	public void update() {		
		this.player.addCoins();
		this.addVampire(); 
		this.board.update();
		this.contadorCiclos += 1;
		
	}
	
	
	public boolean attackV(int x, int y,int harm) {
		return this.board.attackV(x, y, harm);
	}
	public boolean attackS(int x, int y,int  harm) {
		return this.board.attackS(x,y,harm);
	}
	public void draw() {
		System.out.println("Number of cycles: " + this.contadorCiclos);
		System.out.println("Coins: " + this.player.mostrarCoins());
		System.out.println("Remaining vampires: ");
		System.out.println("Vampires on the board: ");
		System.out.println(this.printer.toString());
		
	}
	
	public void setGO(boolean acabado){
		this.GameOver = acabado;	
	}
	
	public boolean getGO(){
		return this.GameOver;
	}
	
}
