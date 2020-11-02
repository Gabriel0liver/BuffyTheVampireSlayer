package org.ucm.tp1.p1.view;

import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.objetos.Slayer;
import org.ucm.tp1.p1.objetos.Vampire;
import org.ucm.tp1.p1.utils.MyStringUtils;

public class GamePrinter {
	
	Game game;
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public GamePrinter (Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;
		this.board = new String[numCols][numRows];
	}
	
	private void encodeGame(Game game) {
		
		for(int i = 0; i < numCols; i++) {
			for(int j = 0; j < numRows; j++) {
				Slayer s = game.board.buscarSlayer(i, j);
				Vampire v = game.board.buscarVampire(i, j);
				if(s != null) {
					this.board[i][j] = "S ["+s.getLife()+"]";
				}
				else if(v != null) {
					this.board[i][j] = "V ["+v.getLife()+"]";
				}
				else {
					this.board[i][j] = "";
				}
			}
		}
	}
	
	 public String toString() {
		encodeGame(this.game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(this.board[j][i], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	    }
	 
	 public void getBoard() {
		 
		 
	 }
	 
}
