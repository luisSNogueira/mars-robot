package br.com.mars.controller;

import br.com.mars.exception.InvalidMovementException;
import br.com.mars.model.Grid;
import br.com.mars.model.Robot;

public class RobotService {
	
	private Robot robot;
	private Grid grid;
	
	public RobotService(Robot robot, Grid grid) {
		this.robot = robot;
		this.grid = grid;
	}
	
	public char getCardinalPos(char direction) {
		char result = ' ';
		char[] cardinalPoints = getRobot().getCardinalPoints();
		int index = findIndex(cardinalPoints, getRobot().getCurrDirection());
		if (direction == 'L') {
			index -= 1;
			try {
				result = cardinalPoints[index];
			} catch (ArrayIndexOutOfBoundsException e) {
				result = cardinalPoints[3];
			}
		} else if (direction == 'R') {
			index += 1;
			try {
				result = cardinalPoints[index];
			} catch (ArrayIndexOutOfBoundsException e) {
				result = cardinalPoints[0];
			}
		}
		return result;
	}

	public int findIndex(char[] array, char direction) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == direction) {
				index = i;
			}
		}
		return index;
	}
	
	private boolean isPossibleToMove(Grid grid) {
		boolean result = false;
		final String template = "(%1$d, %2$d)";
		String GridPos = String.format(template, getRobot().getXPos(), getRobot().getYPos());
		outerloop:
		for(String[] pos: grid.getGrid()) {
			for(String elem: pos) {
				if(elem.equals(GridPos)) {
					result = true;
					break outerloop;
				}
			}
		}
		
		return result;
	}

	public void move(String command) throws InvalidMovementException {
		String position = robot.getPosition();
		if(!command.equals("INITPOS")) {
			final String template = "(%1$d, %2$d, %3$c)";
			char[] commandList = command.toCharArray();
			int x, y = 0;
			for (int i = 0; i < commandList.length; i++) {
				if (commandList[i] == 'L' || commandList[i] == 'R') {
					getRobot().setCurrDirection(getCardinalPos(commandList[i]));
				} else if (commandList[i] == 'M') {
					switch (getRobot().getCurrDirection()) {
					case 'N':
						y = getRobot().getYPos();
						getRobot().setYPos(y += 1);
						break;
					case 'S':
						y = getRobot().getYPos();
						getRobot().setYPos(y -= 1);
						break;
					case 'E':
						x = getRobot().getXPos();
						getRobot().setXPos(x += 1);
						break;
					case 'W':
						x = getRobot().getXPos();
						getRobot().setXPos(x -= 1);
						break;
					default:
						break;
					}
				} else {
					throw new InvalidMovementException("This is not a valid command.");
				}
			}
			if(isPossibleToMove(grid)) {
				position = String.format(template, getRobot().getXPos(), getRobot().getYPos(), getRobot().getCurrDirection());
				getRobot().setPosition(position);
				
			} else {
				throw new InvalidMovementException("this is not a valid position on the grid.");
			}
		}
	}

	public Robot getRobot() {
		return robot;
	}

}
