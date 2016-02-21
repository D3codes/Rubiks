public class Test{

	public static void main(String[] args){

		int[][] faces = new int[6][9];

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				faces[i][j] = i;

		Cube cube = new Cube(faces);

		cube.up();
		cube.downInv();
		cube.changeOrientation(1,5);
		cube.right();
		cube.frontInv();
		cube.changeOrientation(5,3);
		cube.left();
		
		cube.printCube();
	}
}