package org.ucm.tp1.p1.logic;

import java.util.Random;

import org.ucm.tp1.p1.objetos.Player;
import org.ucm.tp1.p1.objetos.Vampire;
import org.ucm.tp1.p1.objetos.VampireList;
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
		Vampire.inicializarNivel(level);
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
		if((x < (dim_x - 1) && x >= 0) && (y < dim_y && y >= 0)) {
			if((this.board.buscarSlayer(x, y) == null) && (this.board.buscarVampire(x, y) == null)) {
				if(this.player.puedeComprar()) {
					this.player.comprar();
					this.board.addS(x, y);
					return true;
				}
			}
		}
		return false;
	}
	
	public void addVampire() {
		if((Vampire.VampRest() > 0) && Vampire.doesAdd(this.rand)) {
			int x = this.dim_x - 1;  
			int y = rand.nextInt(this.dim_y);
			if(this.board.buscarVampire(x, y) == null) {
				this.board.addV(x, y);
			}
		}
	}
	
	
	public void update() {		
		this.player.addCoins();
		this.board.update();
		this.addVampire(); 
		this.contadorCiclos += 1;
		if(Vampire.VampPres() == 0 && Vampire.VampRest() == 0) {
			setGO(true);
		}
	}
	
	
	public void attackV(int x, int y,int harm) {
		this.board.attackV(x, y, harm);
	}
	public boolean attackS(int x, int y,int  harm) {
		return this.board.attackS(x,y,harm);
	}
	public void draw() {
		System.out.println("Number of cycles: " + this.contadorCiclos);
		System.out.println("Coins: " + this.player.mostrarCoins());
		System.out.println("Remaining vampires: " + Vampire.VampRest());
		System.out.println("Vampires on the board: " + Vampire.VampPres());
		System.out.println(this.printer.toString());
		
	}
	
	public void setGO(boolean acabado){
		this.GameOver = acabado;	
	}
	
	public boolean getGO(){
		return this.GameOver;
	}
	
}
