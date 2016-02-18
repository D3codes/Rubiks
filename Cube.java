public class Cube{

	private int[][] cube = new int[6][9];
	private int[] orientation = new int[6];

	Cube(){
	
		for(int i =0; i < 6; i++)
			orientation[i] = i;
	}
}
