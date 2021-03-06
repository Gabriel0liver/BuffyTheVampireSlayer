package org.ucm.tp1.p2.logic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import org.ucm.tp1.p2.GameObjects.Player;
import org.ucm.tp1.p2.GameObjects.Slayer;
import org.ucm.tp1.p2.GameObjects.Bank;
import org.ucm.tp1.p2.GameObjects.Dracula;
import org.ucm.tp1.p2.GameObjects.ExplosiveVampire;
import org.ucm.tp1.p2.GameObjects.Vampire;
import org.ucm.tp1.p2.GameObjects.GameObjectBoard;
import org.ucm.tp1.p2.GameObjects.GameObject;
import org.ucm.tp1.p2.GameObjects.IAttack;
import org.ucm.tp1.p2.view.GamePrinter;
import org.ucm.tp1.p2.view.*;
import org.ucm.tp1.p3.exception.*;

public class Game implements IPrintable {
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
		this.dim_x = this.level.getDimX();
		this.dim_y = this.level.getDimY();
		this.printer = new GamePrinter(this, this.dim_x, this.dim_y);
		this.rand = new Random(seed);
		this.player = new Player(this.rand);
		this.board = new GameObjectBoard();
		this.contadorCiclos = 0;
		this.GameOver = false;
	}

	public String getPositionToString(int x, int y) {
		GameObject g = getObjectInPosition(x, y);
		if (g == null) {
			return "";
		} else {
			return g.toString();
		}
	}

	public String getInfo() {
		if (this.board.isDAlive()) {
			return "Dracula is alive";
		} else {
			return "";
		}

	}


	public void addSlayer(int x, int y) throws InvalidPositionException, NotEnoughCoinsException {
		
		if (!((x < (dim_x - 1) && x >= 0) && (y < dim_y && y >= 0) && this.board.isPositionEmpty(x, y)))
			throw new InvalidPositionException("Position (" + x + "," + y + "): Invalid position");

		if (!this.player.puedeComprar(50))
			throw new NotEnoughCoinsException(" Slayer cost is 50: Not enough coins");

		this.player.comprar(50);
		GameObject g = new Slayer(x, y, this, 3, "S");
		this.board.add(g);

	}

	public void addBank(int x, int y, int z) throws InvalidPositionException, NotEnoughCoinsException {
		
		if (!((x < (dim_x - 1) && x >= 0) && (y < dim_y && y >= 0) && this.board.isPositionEmpty(x, y)))
			throw new InvalidPositionException("Position (" + x + "," + y + "): Invalid position");

		if (!this.player.puedeComprar(z))
			throw new NotEnoughCoinsException(" Bank cost is" + z + ": Not enough coins");

		this.player.comprar(z);
		GameObject g = new Bank(x, y, 1, this, z, "B");
		this.board.add(g);
	}

	public void bank(int n) {
		this.player.bank(n);
	}

	public void garlicPush() throws NotEnoughCoinsException {
		if (!this.player.puedeComprar(10))
			throw new NotEnoughCoinsException("Garlic Push cost is 10: Not enough coins");

		this.player.comprar(10);
		this.board.garlicPush(dim_x, dim_y);

	}

	public void lightFlash() throws NotEnoughCoinsException {
		if (!this.player.puedeComprar(50))
			throw new NotEnoughCoinsException("Light flash cost is 50: Not enough coins");

		this.player.comprar(50);
		this.board.lightFlash();

	}

	public void addVampire() {
		if ((Vampire.VampRest() > 0) && Vampire.doesAdd(this.rand)) {
			int x = this.dim_x - 1;
			int y = rand.nextInt(this.dim_y);
			if (this.board.isPositionEmpty(x, y)) {
				GameObject g = new Vampire(x, y, this, 5, "V");
				this.board.add(g);
			}
		}

		if ((Vampire.VampRest() > 0) && Vampire.doesAdd(this.rand)) {
			int x = this.dim_x - 1;
			int y = rand.nextInt(this.dim_y);
			if (this.board.isPositionEmpty(x, y) && !this.board.isDAlive()) {
				GameObject g = new Dracula(x, y, this, 5, "D");
				this.board.add(g);
			}
		}

		if ((Vampire.VampRest() > 0) && Vampire.doesAdd(this.rand)) {
			int x = this.dim_x - 1;
			int y = rand.nextInt(this.dim_y);
			if (this.board.isPositionEmpty(x, y)) {
				GameObject g = new ExplosiveVampire(x, y, this, 5, "EV");
				this.board.add(g);
			}
		}
	}

	public void addCustomVampire(int x, int y, String type)	throws NoMoreVampiresException, DraculaIsAliveException, InvalidPositionException {
		if (!(this.board.isPositionEmpty(x, y) && (x < (dim_x) && x >= 0) && (y < dim_y && y >= 0)))
			throw new InvalidPositionException("Position (" + x + "," + y + "): Invalid position");

		if (!(Vampire.VampRest() > 0))
			throw new NoMoreVampiresException(" No more remaining vampires left");

		switch (type) {
		case "v":
			GameObject v = new Vampire(x, y, this, 5, "V");
			this.board.add(v);

		case "d":
			if (this.board.isDAlive())
				throw new DraculaIsAliveException("Dracula is already on board");

			GameObject d = new Dracula(x, y, this, 5, "D");
			this.board.add(d);

		case "e":
			GameObject ev = new ExplosiveVampire(x, y, this, 5, "EV");
			this.board.add(ev);
		}

	}

	public void update() {
		this.player.addCoins();
		this.board.update();
		this.addVampire();

		this.contadorCiclos += 1;
		if (Vampire.VampPres() == 0 && Vampire.VampRest() == 0) {
			System.out.println("Player wins");
			setGO(true);
		}

	}

	public GameObject getObjectInPosition(int x, int y) {
		return board.getObjectInPosition(x, y);
	}

	public IAttack getAttackableInPosition(int x, int y) {
		GameObject g = board.getObjectInPosition(x, y);
		return g;
	}

	public void draw() {
		System.out.println("Number of cycles: " + this.contadorCiclos);
		System.out.println("Coins: " + this.player.mostrarCoins());
		System.out.println("Remaining vampires: " + Vampire.VampRest());
		System.out.println("Vampires on the board: " + Vampire.VampPres());
		System.out.println(this.printer.toString());

	}

	public void setGO(boolean acabado) {
		this.GameOver = acabado;
	}

	public boolean getGO() {
		return this.GameOver;
	}

	public int getDimX() {
		return this.dim_x;
	}

	public int getDimY() {
		return this.dim_y;
	}

	public void resetGame() {
		Vampire.inicializarNivel(level);
		this.rand = new Random(seed);
		this.player = new Player(this.rand);
		this.board = new GameObjectBoard();
		this.contadorCiclos = 0;
		this.GameOver = false;
		Dracula.resetDracula();
	}
	
	public String serialize() {
		String ans = "";
		ans += "Cycles: " + this.contadorCiclos + System.getProperty("line.separator");
		ans += "Coins: " + this.player.mostrarCoins() + System.getProperty("line.separator");
		ans += "Level: " + this.level + System.getProperty("line.separator");
		ans += "Remaining Vampires: " + Vampire.VampRest() + System.getProperty("line.separator");
		ans += "Vampires on Board: " + Vampire.VampPres() + System.getProperty("line.separator");
		ans += System.getProperty("line.separator");
		ans += "GameObjectList: " + System.getProperty("line.separator");
		ans += board.serialize();
		return ans;
	}

	public void store(BufferedWriter outStream) throws IOException {
		try {
			outStream.write(this.serialize());
		} catch (IOException e) {
			throw new IOException();
		}
	}
}