package br.com.mars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mars.exception.InvalidMovementException;
import br.com.mars.exception.ResponseException;
import br.com.mars.model.Grid;
import br.com.mars.model.Robot;

@RestController
public class MarsController {
	
    @PostMapping("/rest/mars/{command}")
    public ResponseEntity<String> moveRobot(@PathVariable String command) {
    	
    	Grid grid = new Grid(5, 5);
    	Robot robot = new Robot();
    	RobotService rService = new RobotService(robot, grid);
    	String position = null;
		try {
			rService.move(command);
			position = rService.getRobot().getPosition();
		} catch (InvalidMovementException e) {
			throw new ResponseException(e.getMessage());
		}
        return new ResponseEntity<>(position, HttpStatus.OK);
    }


}
