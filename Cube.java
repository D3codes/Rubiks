public class Cube{

	private int[][] cube = new int[6][9];
	private int[] orientation = new int[6];
	private Rotate rotate = new Rotate();

	public Cube(){
	
		for(int i =0; i < 6; i++)
			orientation[i] = i;
	}

	public void front(Cube cube){

		cube = rotate.rotation(cube,orientation[0],true);
	}

	public void frontInv(Cube cube){

		cube = rotate.rotation(cube,orientation[0],false);
	}

	public void right(Cube cube){

		cube = rotate.rotation(cube,orientation[1],true);
	}

	public void rightInv(Cube cube){

		cube = rotate.rotation(cube,orientation[1],false);
	}

	public void left(Cube cube){

		cube = rotate.rotation(cube,orientation[3],true);
	}

	public void leftInv(Cube cube){

		cube = rotate.rotation(cube,orientation[3],false);
	}

	public void up(Cube cube){

		cube = rotate.rotation(cube,orientation[4],true);
	}

	public void upInv(Cube cube){

		cube = rotate.rotation(cube,orientation[4],false);
	}

	public void down(Cube cube){

		cube = rotate.rotation(cube,orientation[5],true);
	}

	public void downInv(Cube cube){

		cube = rotate.rotation(cube,orientation[5],false);
	}
}
