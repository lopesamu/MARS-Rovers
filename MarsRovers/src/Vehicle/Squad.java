/**
 * This class models a squad which is a set of rovers
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Vehicle;

import java.util.ArrayList;
import Plateau.Plateau;

public class Squad {
	private ArrayList<Rover> rovers = new ArrayList<>();
	private Plateau plateau;

	// create the squad
	public Squad(Plateau plateau) {
		this.plateau = plateau;
	}

	// add a rover to the squad
	public void addRover(Rover rover) {
		rovers.add(rover);
	}

	public ArrayList<Rover> getRovers() {
		return this.rovers;
	}
}
