package org.ucm.tp1.p2.GameObjects;

import java.util.Random;

public class Player {
	    private int coins;
	    private Random rand;


	    public Player(Random rand) {
	        this.coins = 50;
	        this.rand = rand;

	    }

	    public void addCoins() {
	        if(this.rand.nextFloat() > 0.5) {
	            this.coins = this.coins + 10;
	        }
	    }


	    public boolean puedeComprar() {
	        if(this.coins>= 50) {
	            return true;
	        }
	        else
	            return false;
	    }
	    
	    public void comprar() {
	    	this.coins -= 50;
	    }

	    public int mostrarCoins() {
	        return this.coins;
	    }

	

}
