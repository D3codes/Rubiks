public class Rubik{

	private static InOut io = new InOut();

	public static void main(String[] args){

		go();
	}

	public static void go(){

		splashScreen();
		Cube cube = new Cube(start());
		cube = interact(cube);
	}

	public static void splashScreen(){

		io.println("+----------------------------------------+");
		io.println("| Interactive, command line Rubik's Cube |");
		io.println("|                                        |");
		io.println("|         Author: David Freeman          |");
		io.println("+----------------------------------------+\n");
	}

	public static int[][] start(){

		while(true){

			io.print("Would you like to (I)nput an existing cube, or generate a (N)ew cube?: ");
			char input = io.getChar();

			if(input == 'n' || input == 'N'){

				int[][] faces = new int[6][9];

				for(int i = 0; i < 6; i++)
					for(int j = 0; j < 9; j++)
						faces[i][j] = i;

				return faces;

			} else if(input == 'i' || input == 'I'){

				return(getCube());

			} else{

				io.clear();
				io.println("Invalid Input");
			}
		}
	}

	public static int[][] getCube(){

		int[][] faces = new int[6][9];

		io.println("");

		return faces;
	}

	public static Cube interact(Cube cube){

		while(true){

			cube.printCube();
			cube.printOrientation();
			io.print("Would you like to change (O)rientation, or (T)urn sides?: ");
			char input = io.getChar();

			if(input == 'o' || input == 'O'){

				cube = changeOrientation(cube);

			} else if(input == 't' || input == 'T'){

				cube = turnSides(cube);

			} else{

				io.clear();
				io.println("Invalid input");
			}
			
		}
	}

	public static Cube changeOrientation(Cube cube){

		return cube;
	}

	public static Cube turnSides(Cube cube){

		return cube;
	}
}