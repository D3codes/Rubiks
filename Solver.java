import java.util.*;

public class Solver{

	private int[][] greenCross = new int[6][9];
	private int[][] greenLowerLeft = new int[6][9];
	private int[][] greenLowerRight = new int[6][9];
	private int[][] greenUpperLeft = new int[6][9];
	private int[][] greenFace = new int[6][9];

	private int[][] midRedWhite = new int[6][9];
	private int[][] midRedYellow = new int[6][9];
	private int[][] midOrangeYellow = new int[6][9];
	private int[][] middleRow = new int[6][9];

	private int[][] blueLine = new int[6][9];
	private int[][] blueCross = new int[6][9];
	private int[][] solved = new int[6][9];

	public Solver(){

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++){

				greenCross[i][j] = -1;
				greenFace[i][j] = -1;
				middleRow[i][j] = -1;
				blueLine[i][j] = -1;
				blueCross[i][j] = -1;
				solved[i][j] = i;
			}

		greenCross[0][1] = 0;
		greenCross[0][3] = 0;
		greenCross[0][5] = 0;
		greenCross[0][7] = 0;
		greenCross[1][3] = 1;
		greenCross[3][5] = 3;
		greenCross[4][7] = 4;
		greenCross[5][1] = 5;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				greenLowerLeft[i][j] = greenCross[i][j];

		greenLowerLeft[0][6] = 0;
		greenLowerLeft[3][8] = 3;
		greenLowerLeft[5][0] = 5;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				greenLowerRight[i][j] = greenLowerLeft[i][j];

		greenLowerRight[0][8] = 0;
		greenLowerRight[1][6] = 1;
		greenLowerRight[5][2] = 5;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				greenUpperLeft[i][j] = greenLowerRight[i][j];

		greenUpperLeft[0][0] = 0;
		greenUpperLeft[3][2] = 3;
		greenUpperLeft[4][6] = 4;

		for(int i = 0; i < 9; i++){
			greenFace[0][i] = 0;
			middleRow[0][i] = 0;
			blueCross[0][i] = 0;
		}

		greenFace[1][0] = 1;
		greenFace[1][3] = 1;
		greenFace[1][6] = 1;
		greenFace[3][2] = 3;
		greenFace[3][5] = 3;
		greenFace[3][8] = 3;
		greenFace[4][6] = 4;
		greenFace[4][7] = 4;
		greenFace[4][8] = 4;
		greenFace[5][0] = 5;
		greenFace[5][1] = 5;
		greenFace[5][2] = 5;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				midRedWhite[i][j] = greenFace[i][j];

		midRedWhite[1][1] = 1;
		midRedWhite[4][5] = 4;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				midRedYellow[i][j] = midRedWhite[i][j];

		midRedYellow[1][7] = 1;
		midRedYellow[5][5] = 5;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				midOrangeYellow[i][j] = midRedYellow[i][j];

		midOrangeYellow[3][7] = 3;
		midOrangeYellow[5][3] = 5;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				middleRow[i][j] = midOrangeYellow[i][j];

		middleRow[3][1] = 3;
		middleRow[4][3] = 4;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				blueLine[i][j] = middleRow[i][j];

		blueLine[2][1] = 2;
		blueLine[2][7] = 2;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				blueCross[i][j] = blueLine[i][j];

		blueCross[2][5] = 2;
		blueCross[2][3] = 2;
	}

	public Cube solve(Cube cube){

		InOut io = new InOut();
		io.clear();
		cube.printCube();

		Hamming ham = new Hamming();
		CubeEvolution ce = new CubeEvolution();
		int turns = 0;

		while(ham.getDistanceToGoal(cube, greenCross) != 0){

			cube = ce.evolve(cube, greenCross, 4);

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to Green Cross: "+ham.getDistanceToGoal(cube, greenCross));
			cube.printCube();
		}

		while(ham.getDistanceToGoal(cube, greenLowerLeft) != 0){

			cube = ce.evolve(cube, greenLowerLeft, 4);

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to GreenLL: "+ham.getDistanceToGoal(cube, greenFace));
			cube.printCube();
		}

		while(ham.getDistanceToGoal(cube, greenLowerRight) != 0){

			cube = ce.evolve(cube, greenLowerRight, 4);

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to GreenLR: "+ham.getDistanceToGoal(cube, greenFace));
			cube.printCube();
		}

		while(ham.getDistanceToGoal(cube, greenUpperLeft) != 0){

			cube = ce.evolve(cube, greenUpperLeft, 4);

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to GreenUL: "+ham.getDistanceToGoal(cube, greenFace));
			cube.printCube();
		}

		while(ham.getDistanceToGoal(cube, greenFace) != 0){

			cube = ce.evolve(cube, greenFace, 4);

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to Green Face: "+ham.getDistanceToGoal(cube, greenFace));
			cube.printCube();
		}

		Algorithms alg = new Algorithms();
		cube = alg.fillMiddle(cube);
		io.clear();
		cube.printCube();
		
		boolean once = false;
		while(ham.getDistanceToGoal(cube, blueLine) != 0){

			if(!once){
				cube = ce.evolve(cube, blueLine, 5);
				once = true;
			} else {
				
				cube = ce.evolve(cube, blueLine, 4);
			}

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to Blue line: "+ham.getDistanceToGoal(cube, blueLine));
			cube.printCube();
		}

		once = false;
		while(ham.getDistanceToGoal(cube, blueCross) != 0){

			if(!once){
				cube = ce.evolve(cube, blueCross, 5);
				once = true;
			} else {
				
				cube = ce.evolve(cube, blueCross, 4);
			}

			turns++;
			io.clear();
			io.println("Turns: "+turns+"\t| Distance to Blue cross: "+ham.getDistanceToGoal(cube, blueCross));
			cube.printCube();
		}

		io.println("Solved in "+turns+" turns");
		return cube;
	}
}
