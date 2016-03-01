import java.util.*;

public class Test{

	public static void main(String[] args){

		int[][] faces = new int[6][9];

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				faces[i][j] = i;

		Cube cube = new Cube(faces);

		Scanner scanner = new Scanner(System.in);

		/*cube.front();
		cube.up();
		cube.front();
		cube.right();
		cube.left();
		cube.left();
		cube.back();
		cube.downInv();
		cube.right();
		cube.down();
		cube.down();
		cube.left();
		cube.downInv();
		cube.back();
		cube.right();
		cube.right();
		cube.left();
		cube.front();
		cube.up();
		cube.front();*/

        cube.upInv();
        cube.leftInv();
        cube.upInv();
        cube.frontInv();
        cube.right();
        cube.right();
        cube.backInv();
        cube.right();
        cube.front();
        cube.up();
        cube.back();
        cube.back();
        cube.up();
        cube.backInv();
        cube.left();
        cube.upInv();
        cube.front();
        cube.up();
        cube.right();
        cube.frontInv();
		
		cube.printCrossCube();
	}
}
