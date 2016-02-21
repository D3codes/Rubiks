public class Cube{

	private int[][] faces = new int[6][9];
	private int[] orientation = new int[6];
	private Rotate rotate = new Rotate();

	InOut io = new InOut();

	private static final int GREEN = 0;
	private static final int RED = 1;
	private static final int BLUE = 2;
	private static final int ORANGE = 3;
	private static final int WHITE = 4;
	private static final int YELLOW = 5;

	private static final int FRONT = 0;
	private static final int RIGHT = 1;
	private static final int BACK = 2;
	private static final int LEFT = 3;
	private static final int TOP = 4;
	private static final int BOTTOM = 5;

	public Cube(int[][] faces){
		
		this.faces = faces;

		for(int i =0; i < 6; i++)
			orientation[i] = i;
	}

	public void changeOrientation(int front, int right){

		switch(front){

			case 0:
				switch (right){

					case 1:
						for(int i = 0; i < 6; i++)
							orientation[i] = i;

						break;

					case 3:
						orientation[FRONT] = GREEN;
						orientation[RIGHT] = ORANGE;
						orientation[BACK] = BLUE;
						orientation[LEFT] = RED;
						orientation[TOP] = YELLOW;
						orientation[BOTTOM] = WHITE;
						break;

					case 4:
						orientation[FRONT] = GREEN;
						orientation[RIGHT] = WHITE;
						orientation[BACK] = BLUE;
						orientation[LEFT] = YELLOW;
						orientation[TOP] = ORANGE;
						orientation[BOTTOM] = RED;
						break;

					case 5:
						orientation[FRONT] = GREEN;
						orientation[RIGHT] = YELLOW;
						orientation[BACK] = BLUE;
						orientation[LEFT] = WHITE;
						orientation[TOP] = RED;
						orientation[BOTTOM] = ORANGE;
						break;

					default:
						io.printError("Invalid Option");
						break;
				}
				break;

			case 1:
				switch(right){

					case 0:
						orientation[FRONT] = RED;
						orientation[RIGHT] = GREEN;
						orientation[BACK] = ORANGE;
						orientation[LEFT] = BLUE;
						orientation[TOP] = YELLOW;
						orientation[BOTTOM] = WHITE;
						break;

					case 2:
						orientation[FRONT] = RED;
						orientation[RIGHT] = BLUE;
						orientation[BACK] = ORANGE;
						orientation[LEFT] = GREEN;
						orientation[TOP] = WHITE;
						orientation[BOTTOM] = YELLOW;
						break;

					case 4:
						orientation[FRONT] = RED;
						orientation[RIGHT] = WHITE;
						orientation[BACK] = ORANGE;
						orientation[LEFT] = YELLOW;
						orientation[TOP] = GREEN;
						orientation[BOTTOM] = BLUE;
						break;

					case 5:
						orientation[FRONT] = RED;
						orientation[RIGHT] = YELLOW;
						orientation[BACK] = ORANGE;
						orientation[LEFT] = WHITE;
						orientation[TOP] = BLUE;
						orientation[BOTTOM] = GREEN;
						break;

					default:
						io.printError("Invalid Option");
						break;
				}
				break;

			case 2:
				switch(right){

					case 1:
						orientation[FRONT] = BLUE;
						orientation[RIGHT] = RED;
						orientation[BACK] = GREEN;
						orientation[LEFT] = ORANGE;
						orientation[TOP] = YELLOW;
						orientation[BOTTOM] = WHITE;
						break;

					case 3:
						orientation[FRONT] = BLUE;
						orientation[RIGHT] = ORANGE;
						orientation[BACK] = GREEN;
						orientation[LEFT] = RED;
						orientation[TOP] = WHITE;
						orientation[BOTTOM] = YELLOW;
						break;

					case 4:
						orientation[FRONT] = BLUE;
						orientation[RIGHT] = WHITE;
						orientation[BACK] = GREEN;
						orientation[LEFT] = YELLOW;
						orientation[TOP] = RED;
						orientation[BOTTOM] = ORANGE;
						break;

					case 5:
						orientation[FRONT] = BLUE;
						orientation[RIGHT] = YELLOW;
						orientation[BACK] = GREEN;
						orientation[LEFT] = WHITE;
						orientation[TOP] = ORANGE;
						orientation[BOTTOM] = RED;
						break;

					default:
						io.printError("Invalie Option");
						break;
				}
				break;

			case 3:
				switch(right){

					case 0:
						orientation[FRONT] = ORANGE;
						orientation[RIGHT] = GREEN;
						orientation[BACK] = RED;
						orientation[LEFT] = BLUE;
						orientation[TOP] = WHITE;
						orientation[BOTTOM] = YELLOW;
						break;

					case 2:
						orientation[FRONT] = ORANGE;
						orientation[RIGHT] = BLUE;
						orientation[BACK] = RED;
						orientation[LEFT] = GREEN;
						orientation[TOP] = YELLOW;
						orientation[BOTTOM] = WHITE;
						break;

					case 4:
						orientation[FRONT] = ORANGE;
						orientation[RIGHT] = WHITE;
						orientation[BACK] = RED;
						orientation[LEFT] = YELLOW;
						orientation[TOP] = BLUE;
						orientation[BOTTOM] = GREEN;
						break;

					case 5:
						orientation[FRONT] = ORANGE;
						orientation[RIGHT] = YELLOW;
						orientation[BACK] = RED;
						orientation[LEFT] = WHITE;
						orientation[TOP] = GREEN;
						orientation[BOTTOM] = BLUE;
						break;

					default:
						io.printError("Invalid Option");
						break;
				}
				break;

			case 4:
				switch(right){

					case 0:
						orientation[FRONT] = WHITE;
						orientation[RIGHT] = GREEN;
						orientation[BACK] = YELLOW;
						orientation[LEFT] = BLUE;
						orientation[TOP] = RED;
						orientation[BOTTOM] = ORANGE;
						break;

					case 1:
						orientation[FRONT] = WHITE;
						orientation[RIGHT] = RED;
						orientation[BACK] = YELLOW;
						orientation[LEFT] = ORANGE;
						orientation[TOP] = BLUE;
						orientation[BOTTOM] = GREEN;
						break;

					case 2:
						orientation[FRONT] = WHITE;
						orientation[RIGHT] = BLUE;
						orientation[BACK] = YELLOW;
						orientation[LEFT] = GREEN;
						orientation[TOP] = ORANGE;
						orientation[BOTTOM] = RED;
						break;

					case 3:
						orientation[FRONT] = WHITE;
						orientation[RIGHT] = ORANGE;
						orientation[BACK] = YELLOW;
						orientation[LEFT] = RED;
						orientation[TOP] = GREEN;
						orientation[BOTTOM] = BLUE;
						break;

					default:
						io.printError("Invalid Option");
						break;
				}
				break;

			case 5:
				switch(right){

					case 0:
						orientation[FRONT] = YELLOW;
						orientation[RIGHT] = GREEN;
						orientation[BACK] = WHITE;
						orientation[LEFT] = BLUE;
						orientation[TOP] = ORANGE;
						orientation[BOTTOM] = RED;
						break;

					case 1:
						orientation[FRONT] = YELLOW;
						orientation[RIGHT] = RED;
						orientation[BACK] = WHITE;
						orientation[LEFT] = ORANGE;
						orientation[TOP] = GREEN;
						orientation[BOTTOM] = BLUE;
						break;

					case 2:
						orientation[FRONT] = YELLOW;
						orientation[RIGHT] = BLUE;
						orientation[BACK] = WHITE;
						orientation[LEFT] = GREEN;
						orientation[TOP] = RED;
						orientation[BOTTOM] = ORANGE;
						break;

					case 3:
						orientation[FRONT] = YELLOW;
						orientation[RIGHT] = ORANGE;
						orientation[BACK] = WHITE;
						orientation[LEFT] = RED;
						orientation[TOP] = BLUE;
						orientation[BOTTOM] = GREEN;
						break;

					default:
						io.printError("Invalid Option");
						break;
				}
				break;

			default:
				io.printError("Invalid Option");
				break;
		}
	}

	public void front(){

		faces = rotate.rotation(faces,orientation[0],true);
	}

	public void frontInv(){

		faces = rotate.rotation(faces,orientation[0],false);
	}

	public void right(){

		faces = rotate.rotation(faces,orientation[1],true);
	}

	public void rightInv(){

		faces = rotate.rotation(faces,orientation[1],false);
	}

	public void left(){

		faces = rotate.rotation(faces,orientation[3],true);
	}

	public void leftInv(){

		faces = rotate.rotation(faces,orientation[3],false);
	}

	public void up(){

		faces = rotate.rotation(faces,orientation[4],true);
	}

	public void upInv(){

		faces = rotate.rotation(faces,orientation[4],false);
	}

	public void down(){

		faces = rotate.rotation(faces,orientation[5],true);
	}

	public void downInv(){

		faces = rotate.rotation(faces,orientation[5],false);
	}

	public void printCube(){
		
		String block = "[]";

		for(int i = 0; i < 6; i++){

			for(int j = 1; j <= 9; j++){
				
				switch(faces[i][j-1]){

					case 0:
						io.colorPrint("GREEN", block);
						break;
					
					case 1:
						io.colorPrint("RED", block);
						break;

					case 2:
						io.colorPrint("BLUE", block);
						break;

					case 3:
						io.colorPrint("PURPLE", block);
						break;

					case 4:
						io.colorPrint("WHITE", block);
						break;

					case 5:
						io.colorPrint("YELLOW", block);
						break;

					default:
						io.print(block);
						break;
				}

				if(j % 3 == 0)
					io.println("");
			}
			io.println("");
		}
	}
}
