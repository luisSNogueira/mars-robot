package br.com.mars.model;

public class Robot {
	
	private int x, y;
	private char currDirection;
	private String position;
	private char cardinalPoints[];

	public Robot() {
		this.x = 0;
		this.y = 0;
		this.currDirection = 'N';
		this.position = "(0, 0, N)";
		this.cardinalPoints = new char[4];
		cardinalPoints[0] = 'N';
		cardinalPoints[1] = 'E';
		cardinalPoints[2] = 'S';
		cardinalPoints[3] = 'W';
	}
	
	public int getXPos() {
		return this.x;
	}
	
	public void setXPos(int x) {
		this.x = x;
	}
	
	public int getYPos() {
		return this.y;
	}
	
	public void setYPos(int y) {
		this.y = y;
	}
	
	public char getCurrDirection() {
		return this.currDirection;
	}
	
	public void setCurrDirection(char currDirection) {
		this.currDirection = currDirection;
	}
	
	public char[] getCardinalPoints() {
		return this.cardinalPoints;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
