/**
 * JUnit Test Case to test the output of the system
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Input.Input;
import Output.Output;
import Plateau.Plateau;
import Support.Coordinate;
import Vehicle.Rover;
import Vehicle.Squad;

class TestOutput {

	//test case where the rover does not collide with another rover or leave the plateau
	@Test
	void testNoColision() throws IOException {
		//---input---
		File file = new File("inputNoCollision.txt");
		Input input = new Input(file.getCanonicalPath());

		//---processing---
		Plateau plateau = new Plateau(new Coordinate(input.getxUpperRight(), input.getyUpperRight()), new Coordinate(0, 0));
		Squad squad = new Squad(plateau);

		//create the rovers
		for(int i = 1; i < input.getInputData().size() - 1; i += 2) {
			//criar um rover e adicionar no squad (s)
			Coordinate initialPosition = new Coordinate(input.getxInitialPositionRover(i), input.getyInitialPositionRover(i));
			String initialDirection = input.getxDirectionRover(i);
			String[] path = input.getPathRover(i + 1);

			Rover rover = new Rover(initialPosition, initialDirection, path, plateau, squad.getRovers());

			//calculates the final position of the rover after its journey
			rover.finalPosition();

			//add the rover to the squad
			squad.addRover(rover);
		}

		//---output---
		Output output = new Output(squad.getRovers());
		String[] expected = new String[3];
		expected[0] = "1 3 W";
		expected[1] = "4 3 E";

		for(int i = 0; i < output.getR().size() ; i++) {
			assertEquals(output.getR().get(i).getFinalPosition().getX() + " " + output.getR().get(i).getFinalPosition().getY() + " " + output.getR().get(i).getFinalDirection(), expected[i]);
		}
	}

	//test case where the rover might leave the plateau
	@Test
	void testOutOfPlateau() throws IOException {
		//---input---
		File file = new File("inputOutOfPlateau.txt");
		Input input = new Input(file.getCanonicalPath());

		//---processing---
		Plateau plateau = new Plateau(new Coordinate(input.getxUpperRight(), input.getyUpperRight()), new Coordinate(0, 0));
		Squad squad = new Squad(plateau);

		//create the rovers
		for(int i = 1; i < input.getInputData().size() - 1; i += 2) {
			//criar um rover e adicionar no squad (s)
			Coordinate initialPosition = new Coordinate(input.getxInitialPositionRover(i), input.getyInitialPositionRover(i));
			String initialDirection = input.getxDirectionRover(i);
			String[] path = input.getPathRover(i + 1);

			Rover rover = new Rover(initialPosition, initialDirection, path, plateau, squad.getRovers());

			//calculates the final position of the rover after its journey
			rover.finalPosition();

			//add the rover to the squad
			squad.addRover(rover);
		}

		//---output---
		Output output = new Output(squad.getRovers());
		String[] expected = new String[3];
		expected[0] = "5 2 E";
		for(int i = 0; i < output.getR().size() ; i++) {
			assertEquals(output.getR().get(i).getFinalPosition().getX() + " " + output.getR().get(i).getFinalPosition().getY() + " " + output.getR().get(i).getFinalDirection(), expected[i]);
		}
	}

	//test case where the rover might collide with another rover
	@Test
	void testCollision() throws IOException {
		//---input---
		File file = new File("inputCollision.txt");
		Input input = new Input(file.getCanonicalPath());

		//---processing---
		Plateau plateau = new Plateau(new Coordinate(input.getxUpperRight(), input.getyUpperRight()), new Coordinate(0, 0));
		Squad squad = new Squad(plateau);

		//create the rovers
		for(int i = 1; i < input.getInputData().size() - 1; i += 2) {
			//criar um rover e adicionar no squad (s)
			Coordinate initialPosition = new Coordinate(input.getxInitialPositionRover(i), input.getyInitialPositionRover(i));
			String initialDirection = input.getxDirectionRover(i);
			String[] path = input.getPathRover(i + 1);

			Rover rover = new Rover(initialPosition, initialDirection, path, plateau, squad.getRovers());

			//calculates the final position of the rover after its journey
			rover.finalPosition();

			//add the rover to the squad
			squad.addRover(rover);
		}

		//---output---
		Output output = new Output(squad.getRovers());
		String[] expected = new String[3];
		expected[0] = "4 4 N";
		expected[1] = "3 4 E";
		for(int i = 0; i < output.getR().size() ; i++) {
			assertEquals(output.getR().get(i).getFinalPosition().getX() + " " + output.getR().get(i).getFinalPosition().getY() + " " + output.getR().get(i).getFinalDirection(), expected[i]);
		}
	}

	//test case where the rover might collide with another rover or leave the plateau
	@Test
	void testColisionAndOutOfPlateau() throws IOException {
		//---input---
		File file = new File("inputTestCollisionOutOfPlateau.txt");
		Input input = new Input(file.getCanonicalPath());

		//---processing---
		Plateau plateau = new Plateau(new Coordinate(input.getxUpperRight(), input.getyUpperRight()), new Coordinate(0, 0));
		Squad squad = new Squad(plateau);

		//create the rovers
		for(int i = 1; i < input.getInputData().size() - 1; i += 2) {
			//criar um rover e adicionar no squad (s)
			Coordinate initialPosition = new Coordinate(input.getxInitialPositionRover(i), input.getyInitialPositionRover(i));
			String initialDirection = input.getxDirectionRover(i);
			String[] path = input.getPathRover(i + 1);

			Rover rover = new Rover(initialPosition, initialDirection, path, plateau, squad.getRovers());

			//calculates the final position of the rover after its journey
			rover.finalPosition();

			//add the rover to the squad
			squad.addRover(rover);
		}

		//---output---
		Output o = new Output(squad.getRovers());
		String[] expected = new String[3];
		expected[0] = "4 4 N";
		expected[1] = "3 3 S";
		expected[2] = "2 6 N";
		for(int i = 0; i < o.getR().size() ; i++) {
			assertEquals(o.getR().get(i).getFinalPosition().getX() + " " + o.getR().get(i).getFinalPosition().getY() + " " + o.getR().get(i).getFinalDirection(), expected[i]);
		}
	}
}
