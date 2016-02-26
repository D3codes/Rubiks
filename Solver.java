import java.util.*;

public class Solver{

	public static void main(String[] args){

		int[][] faces = new int[6][9];

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				faces[i][j] = i;

		Cube cube = new Cube(faces);
		cube.scramble();
		//cube.right();
		//cube.upInv();
		//cube.back();
		//cube.rightInv();
		cube.printCube();

		Hamming ham = new Hamming();
		CubeEvolution ce = new CubeEvolution();
		InOut io = new InOut();
		int turns = 0;
		while(true){

			if(ham.getDistance(cube) != 0){

				/*if(ham.getDistance(cube) < 6){
					cube = ce.evolve(cube, 10);
					//solve(cube);
					break;
					
				} else {
					cube = ce.evolve(cube, 5);
				}*/
				
				if(turns <= 20){
					cube = ce.evolve(cube, 4);
				}else{
					cube = ce.evolve(cube, 5);
				}
				
				turns++;
				cube.printCube();
				io.println("Turns: "+turns+"\t| Fitness: "+ham.getDistance(cube));

			} else{

				break;
			}
		}//ce.solve(cube);
	}
}
