/**
 * Auxiliar class to model two-dimensional coordinates
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Support;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
