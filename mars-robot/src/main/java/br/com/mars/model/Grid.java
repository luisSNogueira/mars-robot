package br.com.mars.model;

public class Grid {
	
private String[][] grid;
	
	public Grid(int x, int y) {
		this.grid = new String[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				grid[i][j] = "(" + i + ", " + j + ")";
			}
		}
		
	}
	
	public String[][] getGrid() {
		return this.grid;
	}

}
