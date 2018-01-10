package br.com.mars.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.exception.InvalidMovementException;
import br.com.mars.model.Grid;
import br.com.mars.model.Robot;

public class RobotServiceUnitTest {
	Grid grid;
	Robot robot;
	RobotService rService;
	
	@Before
	public void init() {
		grid = new Grid(5, 5);
		robot = new Robot();
		rService = new RobotService(robot, grid);
	}

	@Test
	public void testInitPos() throws Exception{
		MoveRobot("(0, 0, N)", "INITPOS");
	}
	
	@Test
	public void moveRobotLowerRightEdge() throws Exception {
		MoveRobot("(4, 0, E)", "RMMMM");
	}
	
	@Test
	public void moveRobotTopLeftWithRotation() throws Exception {
		MoveRobot("(0, 4, W)", "RMMMMLMMMMLMMMM");
	}
	
	@Test
	public void moveRobotToTheCenter() throws Exception {
		MoveRobot("(2, 2, N)", "MMRMML");
	}
	
	@Test(expected=InvalidMovementException.class)
	public void testInvalidMovement() throws Exception {
		rService.move("LMM");
	}
	
	@Test(expected=InvalidMovementException.class)
	public void testInvalidCommand() throws Exception {
		rService.move("ABC");
	}
	
	private void MoveRobot(String expected, String command) throws Exception{
		rService.move(command);
		assertEquals(expected, robot.getPosition());
	}

}
