/**
 * Main class to show the output
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Support;

import java.io.File;
import java.io.IOException;

import Input.Input;
import Output.Output;
import Plateau.Plateau;
import Vehicle.Rover;
import Vehicle.Squad;

public class Main {
	public static void main(String[] args) throws IOException {
		// ---input---
		File file = new File("input.txt");
		Input input = new Input(file.getCanonicalPath());

		// ---processing---
		Plateau plateau = new Plateau(new Coordinate(input.getxUpperRight(), input.getyUpperRight()),
				new Coordinate(0, 0));
		Squad squad = new Squad(plateau);

		// create the rovers
		for (int ind = 1; ind < input.getInputData().size() - 1; ind += 2) {
			// criar um rover e adicionar no squad (s)
			Coordinate initialPosition = new Coordinate(input.getxInitialPositionRover(ind),
					input.getyInitialPositionRover(ind));
			String initialDirection = input.getxDirectionRover(ind);
			String[] path = input.getPathRover(ind + 1);

			Rover rover = new Rover(initialPosition, initialDirection, path, plateau, squad.getRovers());

			// calculates the final position of the rover after its journey
			rover.finalPosition();

			// add the rover to the squad
			squad.addRover(rover);
		}

		// ---output---
		Output output = new Output(squad.getRovers());
		output.printFinalResult();
	}
}
