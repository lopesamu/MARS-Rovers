/**
 * This class receives a squad and print it in a defined format
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Output;
import java.util.ArrayList;

import Vehicle.Rover;

public class Output {
	private ArrayList<Rover> squad = new ArrayList<>();

	public Output(ArrayList<Rover> squad) {
		this.squad = squad;
	}

	//print final result
	public void printFinalResult() {
		for(Rover rover : this.squad) {
			System.out.println(rover.getFinalPosition().getX() + " " + rover.getFinalPosition().getY() + " " + rover.getFinalDirection());
		}
	}

	public ArrayList<Rover> getR() {
		return squad;
	}	
}
