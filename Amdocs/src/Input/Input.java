/**
 * This class read an input file .txt and convert it 
 * to supply input data to the classes Plateau, Squad and Rover
 *
 * @author  Samuel Lopes
 * @version 1.0
 * @since   2021-03-15 
 */

package Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

	//each item of 'inputData' represents lines of the input file
	private ArrayList<String> inputData = new ArrayList<>();
	//'path' is the path of the input file 
	private String path;

	public Input(String path) {
		this.path = path;

		//read the input file .txt
		try {
			FileReader arq = new FileReader(this.path);
			BufferedReader readFile = new BufferedReader(arq);

			String line = readFile.readLine();
			this.inputData.add(line); // read first line

			do{

				line = readFile.readLine(); // read from the second to the last line
				this.inputData.add(line);
			}while (line != null);

			arq.close();
		} catch (IOException e) {
			System.err.printf("Error. Cannot open the file: %s.\n",
					e.getMessage());
		}
	}

	public int getxUpperRight() {
		//close the system in the case of input error or negative number
		try {
			String aux[] = this.inputData.get(0).split(" ");
			int xUpperRight = Integer.parseInt(aux[0]);

			if(xUpperRight > 0) {
				return xUpperRight;
			}
			else {
				System.err.printf("Error. Negative Upper Right Plateau Coordinate. \n\n");
				System.exit(0);
			}
		}
		catch(NumberFormatException nfe){
			System.err.printf("Error. Invalid Upper Right Plateau Coordinate. \n\n");
			nfe.printStackTrace();
			System.exit(0);
		}
		return 0;
	}


	public int getyUpperRight() {
		//close the system in the case of input error or negative number 
		try {
			String aux[] = this.inputData.get(0).split(" ");
			int yUpperRight = Integer.parseInt(aux[1]);

			if(yUpperRight > 0) {
				return yUpperRight;
			}
			else {
				System.err.printf("Error. Negative Upper Right Plateau Coordinate. \n\n");
				System.exit(0);
			}
		}
		catch(NumberFormatException nfe){
			System.err.printf("Error. Invalid Upper Right Plateau Coordinate. \n\n");
			nfe.printStackTrace();
			System.exit(0);
		}
		return 0;	
	}

	public ArrayList<String> getInputData() {
		return inputData;
	}

	public int getxInitialPositionRover(int index) {
		//close the system in the case of input error
		try{
			String aux[] = this.inputData.get(index).split(" ");
			int xInitialPositionRover = Integer.parseInt(aux[0]);
			return xInitialPositionRover;
		}
		catch(NumberFormatException nfe){
			System.err.printf("Error. Invalid Initial Position Rover. \n\n");
			nfe.printStackTrace();
			System.exit(0);
		}
		return 0;
	}

	public int getyInitialPositionRover(int index) {
		//close the system in the case of input error
		try {
			String aux[] = this.inputData.get(index).split(" ");
			int yInitialPositionRover = Integer.parseInt(aux[1]);
			return yInitialPositionRover;
		}
		catch(NumberFormatException nfe){
			System.err.printf("Error. Invalid Initial Position Rover. \n\n");
			nfe.printStackTrace();
			System.exit(0);
		}
		return 0;
	}

	public String getxDirectionRover(int index){

		String aux[] = this.inputData.get(index).split(" ");
		
		//close the system in the case of input error
		if(aux[2].equals("N") || aux[2].equals("S") || aux[2].equals("E") || aux[2].equals("W")) {
			return aux[2];
		}
		else {
			System.err.printf("Error. Invalid direction.\n");
			System.exit(0);
			return null;
		}
	}

	public String[] getPathRover(int index) {
		String[] aux = new String[this.inputData.get(index).length()];
		aux = this.inputData.get(index).split("");

		//close the system in the case of input error
		for (int i = 0; i < aux.length; i++) {
			if(!aux[i].equals("L") && !aux[i].equals("M") && !aux[i].equals("R")) {
				System.err.printf("Error. Invalid path.\n");
				System.exit(0);
				return null;
			}
		}
		return aux;
	}
}
