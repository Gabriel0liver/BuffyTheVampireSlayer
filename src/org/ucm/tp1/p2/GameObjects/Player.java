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
	    
	    public void bank(int n) {
	    	//ahora divide enrtre 10 en la clase de blood bank
	    	this.coins= this.coins+n;
	    }


	    public boolean puedeComprar(int n) {
	        if(this.coins>= n) {
	            return true;
	        }else {
	        	return false;
	        }
	    }
	    
	    
	    public void comprar(int n) {
	    	this.coins -= n;
	    }

	    public int mostrarCoins() {
	        return this.coins;
	    }

	

}
