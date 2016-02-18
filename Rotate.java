public class Rotate{

	public void front(Cube cube){

	}

	public void frontInv(Cube cube){

	}

	public void right(Cube cube){

	}

	public void rightInv(Cube cube){

	}

	public void left(Cube cube){

	}

	public void leftInv(Cube cube){

	}

	public void up(Cube cube){

	}

	public void upInv(Cube cube){

	}

	public void down(Cube cube){

	}

	public void downInv(Cube cube){

	}

	private void rotate(int side, boolean clockwise){

		int[] face = cube[side];
		int[] tmp = new int[2];
		int[] tmp2 = new int[2];

		if(clockwise){
			
			tmp[0] = face[5];
			tmp[1] = face[8];
			face[5] = face[1];
			face[8] = face[2];
			
			tmp2[0] = face[7];
			tmp2[1] = face[6];
			face[7] = tmp[0];
			face[6] = tmp[1];

			tmp[0] = face[3];
			tmp[1] = face[0];
			face[3] = tmp2[0];
			face[0] = tmp2[1];

			tmp2[0] = face[1];
			tmp2[1] = face[2];
			face[1] = tmp[0];
			face[2] = tmp[1];

			cube[side] = face;

			switch(side){
				
				case 0: rotateGreen();
					break;

				case 1: rotateRed();
					break;

				case 2: rotateBlue();
					break;

				case 3: rotateOrange();
					break;

				case 4: rotateWhite();
					break;

				case 5: rotateYellow();
					break;

				default: break;
			}
		} else {
			
			for(int i = 0; i < 3; i++)
				rotate(side,true);
		}
	}

	private void rotateGreen(){
		
		int[] tmp = new int[3];
		int[] tmp2 = new int[3];
		int top = 4;
		int bottom = 5;
		int left = 3;
		int right = 1;

		tmp[0] = cube[top][6];
		tmp[1] = cube[top][7];
		tmp[2] = cube[top][8];
		cube[top][6] = cube[left][8];
		cube[top][7] = cube[left][5];
		cube[top][8] = cube[left][2];

		tmp2[0] = cube[right][0];
		tmp2[1] = cube[right][3];
		tmp2[2] = cube[right][6];
		cube[right][0] = tmp[0];
		cube[right][3] = tmp[1];
		cube[right][6] = tmp[2];

		tmp[0] = cube[bottom][0];
		tmp[1] = cube[bottom][1];
		tmp[2] = cube[bottom][2];
		cube[bottom][0] = tmp2[2];
		cube[bottom][1] = tmp2[1];
		cube[bottom][2] = tmp2[0];

		cube[left][2] = tmp[0];
		cube[left][5] = tmp[1];
		cube[left][8] = tmp[2];
	}

	private void rotateRed(){
		
		int[] tmp = new int[3];
		int[] tmp2 = new int[3];
		int top = 4;
		int bottom = 5;
		int left = 0;
		int right = 2;

		tmp[0] = cube[top][8];
		tmp[1] = cube[top][5];
		tmp[2] = cube[top][2];
		cube[top][8] = cube[left][8];
		cube[top][5] = cube[left][5];
		cube[top][2] = cube[left][2];

		tmp2[0] = cube[right][0];
		tmp2[1] = cube[right][3];
		tmp2[2] = cube[right][6];
		cube[right][0] = tmp[0];
		cube[right][3] = tmp[1];
		cube[right][6] = tmp[2];

		tmp[0] = cube[bottom][2];
		tmp[1] = cube[bottom][5];
		tmp[2] = cube[bottom][8];
		cube[bottom][2] = tmp2[2];
		cube[bottom][5] = tmp2[1];
		cube[bottom][8] = tmp2[0];

		cube[left][2] = tmp[0];
		cube[left][5] = tmp[1];
		cube[left][8] = tmp[2];
	}

	private void rotateBlue(){
		
		int[] tmp = new int[3];
		int[] tmp2 = new int[3];
		int top = 4;
		int bottom = 5;
		int left = 1;
		int right = 3;
	}

	private void rotateOrange(){

	}

	private void rotateWhite(){

	}

	private void rotateYellow(){

	}
}
