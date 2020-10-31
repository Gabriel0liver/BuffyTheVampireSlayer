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
	private Random rand;
	private Player player;
	public Long seed;
	public Level level;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.dim_x = this.level.dimensionx();
		this.dim_y = this.level.dimensiony();
		this.printer = new GamePrinter(this, this.dim_y, this.dim_x);
		this.rand = new Random(seed);
		this.player = new Player(this.rand);
		this.board = new GameObjectBoard(this);
		this.contadorCiclos = 0;
	}
	
	public boolean addSlayer(int x, int y) {
		
		return true;
	}
	
	public void addVampire() {
		
	}
	
	public void update() {
		this.player.addCoins();
		this.board.update();
		this.contadorCiclos += 1;
		this.addVampire(); // esto seria mejor si lo pusiese dentro del board.update... Creo.
	}
	
	
	public boolean attackV(int x, int y,int harm) {
		return this.board.attackV(x, y, harm);
	}
	public boolean attackS(int x, int y,int  harm) {
		return this.board.attackS(x,y,harm);
	}
	public void draw() {
		this.printer.toString();
	}
	
	
}
