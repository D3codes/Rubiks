public class Cube{

	private int[][] faces = new int[6][9];
	private int[] orientation = new int[6];
	private Rotate rotate = new Rotate();

	public Cube(int[][] faces){
		
		this.faces = faces;

		for(int i =0; i < 6; i++)
			orientation[i] = i;
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
		
		InOut io = new InOut();
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
