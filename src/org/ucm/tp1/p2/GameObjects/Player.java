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
	    public void blank(int n) {
	    	n= n/10;
	    	this.coins= this.coins+n;
	    }


	    public boolean puedeComprar(int n,int z) {
	        if(this.coins>= 50 && n==1) {
	            return true;
	        }
	        else if(this.coins>= 10 && n==2) {
	        	return true;
	        }
	        else if(this.coins>= z && n==2) {
	        	return true;
	        }
	        else
	            return false;
	    }
	    
	    
	    public void comprar(int n,int z) {
	    	if (n==1) {
	    		this.coins -= 50;
	    	}
	    	else if(n==2) {
	    		this.coins -= 10;
	    	}
	    	else if(n==3) {
	    		this.coins -= z;
	    	}
	    }

	    public int mostrarCoins() {
	        return this.coins;
	    }

	

}
