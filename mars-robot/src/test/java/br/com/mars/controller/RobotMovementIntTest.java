package br.com.mars.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RobotMovementIntTest {
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Test
	public void movementToTheRightTest() {
		ResponseEntity<String> result = MoveRobot("MMRMMRMM");
		String expected = "(2, 0, S)";
		String actual = result.getBody();
		assertEquals(expected, actual);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	public void movementToTheLeftTest() {
		ResponseEntity<String> result = MoveRobot("MML");
		String expected = "(0, 2, W)";
		String actual = result.getBody();
		assertEquals(expected, actual);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	public void movementToTheLeftRepeatTest() {
		ResponseEntity<String> result = MoveRobot("MML");
		String expected = "(0, 2, W)";
		String actual = result.getBody();
		assertEquals(expected, actual);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	public void invalidCommandTest() {
		ResponseEntity<String> result = MoveRobot("AAA");
		assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
	}
	
	@Test
	public void invalidPositionTest() {
		ResponseEntity<String> result = MoveRobot("MMMMMMMMMMMMMMMMMMMMMMMM");
		assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
	}
 

	public ResponseEntity<String> MoveRobot(String command) {
		String template = "http://localhost:8080/rest/mars/%s";
		ResponseEntity<String> responseEntity = restTemplate.
				postForEntity(String.format(template, command), null, String.class);
		
		return responseEntity;
	}

}
