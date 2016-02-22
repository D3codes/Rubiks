public class Rubik{

	private static InOut io = new InOut();

	public static void main(String[] args){

		go();
	}

	public static void go(){

		splashScreen();
		Cube cube = new Cube(start());
		interact(cube);
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

	public static void interact(Cube cube){

		while(true){

			cube.printCube();
			cube.printOrientation();
			io.print("Would you like to change (O)rientation, (T)urn a side?, or (Q)uit?: ");
			char input = io.getChar();

			if(input == 'o' || input == 'O'){

				cube = changeOrientation(cube);
				io.clear();

			} else if(input == 't' || input == 'T'){

				cube = turnSides(cube);
				io.clear();

			}else if(input == 'q' || input == 'Q'){

				break;

			} else{

				io.clear();
				io.println("Invalid input");
			}
			
		}
	}

	public static Cube changeOrientation(Cube cube){

		io.println("Green = 0, Red = 1, Blue = 2, Orange = 3, White = 4, Yellow = 5");
		io.print("What side do you want to face you?: ");
		int front = io.getInt();
		io.print("What side do you want to the right?: ");
		int right = io.getInt();
		cube.changeOrientation(front, right);
		return cube;
	}

	public static Cube turnSides(Cube cube){

		io.println("R = 0, R' = 1, L = 2, L' = 3, U = 4, U' = 5, D = 6, D' = 7, F = 8, F' = 9, B = 10, B' = 11");
		int input = io.getInt();

		switch(input){

			case 0:
				cube.right();
				break;

			case 1:
				cube.rightInv();
				break;

			case 2:
				cube.left();
				break;

			case 3:
				cube.leftInv();
				break;

			case 4:
				cube.up();
				break;

			case 5:
				cube.upInv();
				break;

			case 6:
				cube.down();
				break;

			case 7:
				cube.downInv();
				break;

			case 8:
				cube.front();
				break;

			case 9:
				cube.frontInv();
				break;

			case 10:
				cube.back();
				break;

			case 11:
				cube.backInv();
				break;

			default:
				break;
		}

		return cube;
	}
}