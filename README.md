# mars-robot
An app to simulate the movement off a robot on Mars

How to Build
mvn clean install

how to Run
java -jar target/mars-robot.jar

How to use
The Robot uses the following commands(Upper case only): 
M - the robot moves 1 step
L - the robot rotates around its axis to the left
R - the robot rotates around its axis to the right
INITPOS - the robot returns its initial position

Examples
Valid movement with rotations to the right -> http://localhost:8080/rest/mars/MMRMMRMM (Response: (2, 0, S))

valid movement north ending facing left -> http://localhost:8080/rest/mars/MML (Response: (0, 2, W))

Invalid command -> http://localhost:8080/rest/mars/AAA (Response: 400 Bad Request)

Invalid position -> http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM (Response: 400 Bad Request)
