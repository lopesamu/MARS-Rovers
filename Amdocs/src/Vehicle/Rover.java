/**
 * This class models a rover and its behaviour
 *
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Vehicle;

import java.util.ArrayList;
import Plateau.Plateau;
import Support.Coordinate;

public class Rover {
	private Coordinate initialPosition;
	private Coordinate finalPosition;
	private String initialDirection;
	private String finalDirection;
	private String[] path;
	private Plateau plateau;
	private ArrayList<Rover> squad;

	public Rover(Coordinate initialPosition, String initialDirection, String[] path, Plateau plateau, ArrayList<Rover> squad) {
		this.initialPosition = initialPosition;
		this.finalPosition = new Coordinate(initialPosition.getX(),initialPosition.getY());
		this.initialDirection = initialDirection;
		this.path = path;
		this.plateau = plateau;
		this.squad = squad;
	}

	//calculate the final position and direction of the rover
	public void finalPosition() {
		String finalDirection = this.initialDirection;
		int finalPositionX = this.initialPosition.getX();
		int finalPositionY = this.initialPosition.getY();

		//check if the initial position of the rover is out of the plateau 
		if(this.isOffThePlateau(this.initialPosition.getX(), this.initialPosition.getY())) {
			System.err.printf("Error. Invalid Initial Position of the Rover. \n\n");
			System.exit(0);
		}

		for (int i = 0; i < this.path.length; i++) {
			if(this.path[i].equals("L")) {
				if(finalDirection.equals("N")) {
					finalDirection = "W";
				}
				else if(finalDirection.equals("W")) {
					finalDirection = "S";
				}
				else if(finalDirection.equals("S")) {
					finalDirection = "E";
				}
				else {
					finalDirection = "N";
				}
			}
			else if(this.path[i].equals("R")) {
				if(finalDirection.equals("N")) {
					finalDirection = "E";
				}
				else if(finalDirection.equals("E")) {
					finalDirection = "S";
				}
				else if(finalDirection.equals("S")) {
					finalDirection = "W";
				}
				else {
					finalDirection = "N";
				}
			}
			else {
				if(finalDirection.equals("N")) {
					//check if the movement can take the robot off the platform or if it will collide with another rover. If yes, cancel the move
					if(!this.isOffThePlateau(finalPositionX, finalPositionY + 1) && !this.occurredCollision(finalPositionX, finalPositionY + 1)) {
						finalPositionY++;
					}
				}
				else if(finalDirection.equals("S")) {
					if(!this.isOffThePlateau(finalPositionX, finalPositionY - 1) && !this.occurredCollision(finalPositionX, finalPositionY - 1)) {
						finalPositionY--;
					}
				}
				else if(finalDirection.equals("E")) {
					if(!this.isOffThePlateau(finalPositionX + 1, finalPositionY) && !this.occurredCollision(finalPositionX + 1, finalPositionY)) {
						finalPositionX++;
					}
				}
				else if(finalDirection.equals("W")) {
					if(!this.isOffThePlateau(finalPositionX - 1, finalPositionY) && !this.occurredCollision(finalPositionX - 1, finalPositionY)) {
						finalPositionX--;
					}
				}
			}
		}
		this.finalPosition.setX(finalPositionX);
		this.finalPosition.setY(finalPositionY);
		this.finalDirection = finalDirection;
	}

	//checks if a given movement can cause the rover to leave the platform
	boolean isOffThePlateau(int x, int y) {
		if(x <= this.plateau.getUpperRight().getX() && x >= this.plateau.getLowerLeft().getX() && y <= this.plateau.getUpperRight().getY() && y >= this.plateau.getLowerLeft().getY()) {
			return false;
		}
		else {
			return true;
		}
	}

	//checks whether a given move can cause the rover to collide with others who have already made their move
	boolean occurredCollision(int x, int y) {
		//scroll through the list of squads. If the position (x, y) is equal to any element in the list, return true
		for (int i = 0; i < this.squad.size(); i++) {
			if (x == this.squad.get(i).getFinalPosition().getX() && y == this.squad.get(i).getFinalPosition().getY()) {
				return true;
			}
		}		
		return false;
	}

	public String getFinalDirection() {
		return this.finalDirection;
	}

	public Coordinate getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Coordinate initialPosition) {
		this.initialPosition = initialPosition;
	}

	public Coordinate getFinalPosition() {
		return finalPosition;
	}

	public void setFinalPosition(Coordinate finalPosition) {
		this.finalPosition = finalPosition;
	}

	public String getInitialDirection() {
		return this.initialDirection;
	}

	public String[] getPath() {
		return this.path;
	}
}