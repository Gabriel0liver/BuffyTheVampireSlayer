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


	    public boolean puedeComprar(int n) {
	        if(this.coins>= 50 && n==1) {
	            return true;
	        }
	        else if(this.coins>= 10 && n==2) {
	        	return true;
	        }
	        else
	            return false;
	    }
	    
	    
	    public void comprar(int n) {
	    	if (n==1) {
	    		this.coins -= 50;
	    	}
	    	else if(n==2) {
	    		this.coins -= 10;
	    	}
	    }

	    public int mostrarCoins() {
	        return this.coins;
	    }

	

}
