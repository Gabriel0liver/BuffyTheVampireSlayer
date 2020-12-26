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
<<<<<<< HEAD
	    public void addCoins(int n) {
=======
	    public void bank(int n) {
	    	n= n/10;
>>>>>>> 4cfed7462539d150bc29440279b9920904a0b437
	    	this.coins= this.coins+n;
	    }


<<<<<<< HEAD
	    public boolean puedeComprar(int z) {
	      
	         if(this.coins>= z ) {
	        	return true;
	        }
	        else
	            return false;
=======
	    public boolean puedeComprar(int n) {
	        if(this.coins>= n) {
	            return true;
	        }else {
	        	return false;
	        }
>>>>>>> 4cfed7462539d150bc29440279b9920904a0b437
	    }
	    
	    
	    public void comprar(int n) {
<<<<<<< HEAD
	    	
	    		this.coins -= n;
	    	
=======
	    	this.coins -= n;
>>>>>>> 4cfed7462539d150bc29440279b9920904a0b437
	    }

	    public int mostrarCoins() {
	        return this.coins;
	    }

	

}
