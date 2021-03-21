/**
 * This class models the plateau coordinates
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Plateau;

import Support.Coordinate;

public class Plateau {
	private Coordinate upperRight;
	private Coordinate lowerLeft;

	public Plateau(Coordinate upperRight, Coordinate lowerLeft) {
		this.upperRight = upperRight;
		this.lowerLeft = lowerLeft;
	}

	public Coordinate getUpperRight() {
		return upperRight;
	}

	public Coordinate getLowerLeft() {
		return lowerLeft;
	}
}