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
			io.print("Would you like to change (O)rientation, (T)urn a side?, (S)cramble, or (Q)uit?: ");
			char input = io.getChar();

			if(input == 'o' || input == 'O'){

				io.clear();
				cube = changeOrientation(cube);

			} else if(input == 't' || input == 'T'){

				cube = turnSides(cube);
				io.clear();

			}else if(input == 'q' || input == 'Q'){

				break;

			}else if(input =='s' || input == 'S'){

				cube.scramble();
				io.clear();

			} else{

				io.clear();
				io.println("Invalid input");
			}
			
		}
	}

	public static Cube changeOrientation(Cube cube){

		io.println("(G)reen, (R)ed, (B)lue, (O)range, (W)hite, (Y)ellow");
		io.print("What side do you want to face you?: ");

		int front = colorSelect(io.getChar());

		io.print("What side do you want to the right?: ");
		int right = colorSelect(io.getChar());
		cube.changeOrientation(front, right);
		return cube;
	}

	public static int colorSelect(char color){

		switch(color){

			case 'G':
				return 0;

			case 'g':
				return 0;

			case 'R':
				return 1;

			case 'r':
				return 1;

			case 'B':
				return 2;

			case 'b':
				return 2;

			case 'O':
				return 3;

			case 'o':
				return 3;

			case 'W':
				return 4;

			case 'w':
				return 4;

			case 'Y':
				return 5;

			case 'y':
				return 5;

			default:
				return -1;
		}
	}

	public static Cube turnSides(Cube cube){

		io.println("R = R, R' = r, L = L, L' = l, U = U, U' = u, D = D, D' = d, F = F, F' = f, B = B, B' = b");
		io.println("Turns can be one at a time or given in a string. All valid turns will be performed in the order given.");
		io.print(": ");
		String input = io.getString();

		for(int i = 0; i < input.length(); i++){

			switch(input.charAt(i)){

				case 'R':
					cube.right();
					break;

				case 'r':
					cube.rightInv();
					break;

				case 'L':
					cube.left();
					break;

				case 'l':
					cube.leftInv();
					break;

				case 'U':
					cube.up();
					break;

				case 'u':
					cube.upInv();
					break;

				case 'D':
					cube.down();
					break;

				case 'd':
					cube.downInv();
					break;

				case 'F':
					cube.front();
					break;

				case 'f':
					cube.frontInv();
					break;

				case 'B':
					cube.back();
					break;

				case 'b':
					cube.backInv();
					break;

				default:
					break;
			}
		}

		return cube;
	}
}