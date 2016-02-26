import java.util.*;

public class Solver{

	private static int[][] greenCross = new int[6][9];
	private static int[][] greenFace = new int[6][9];
	private static int[][] middleRow = new int[6][9];
	private static int[][] blueCross = new int[6][9];

	public static void main(String[] args){

		createSteps();

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

		while(ham.getDistanceToGoal(cube, greenCross) != 0){

			cube = ce.evolve(cube, greenCross, 4);

			turns++;
			cube.printCube();
			io.println("Turns: "+turns+"\t| Distance to Green Cross: "+ham.getDistanceToGoal(cube, greenCross));
		}

		/*while(ham.getDistance(cube) != 0){
				
			//if(turns <= 20){
			//		cube = ce.evolve(cube, 4);
			//}else{
			//		cube = ce.evolve(cube, 5);
			//}

			cube = ce.evolve(cube, 4);
				
			turns++;
			cube.printCube();
			io.println("Turns: "+turns+"\t| Fitness: "+ham.getDistance(cube));

		} *///ce.solve(cube);
	}

	private static void createSteps(){

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++){

				greenCross[i][j] = -1;
				greenFace[i][j] = -1;
				middleRow[i][j] = -1;
				blueCross[i][j] = -1;
			}

		greenCross[0][1] = 0;
		greenCross[0][3] = 0;
		greenCross[0][5] = 0;
		greenCross[0][7] = 0;
		greenCross[1][3] = 1;
		greenCross[3][5] = 3;
		greenCross[4][7] = 4;
		greenCross[5][1] = 5;
	}
}
