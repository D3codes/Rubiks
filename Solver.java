public class Solver{

	public static void main(String[] args){

		int[][] faces = new int[6][9];

				for(int i = 0; i < 6; i++)
					for(int j = 0; j < 9; j++)
						faces[i][j] = i;

		Cube cube = new Cube(faces);
		cube.scramble();
		cube.printCube();

		Hamming ham = new Hamming();
		CubeEvolution ce = new CubeEvolution();
		InOut io = new InOut();
		int gen = 1;
		while(true){

			if(ham.getDistance(cube) != 0){

				cube = ce.evolve(cube);

				//cube.printCube();
				io.println("Gen: "+gen+"\t| Fitness: "+ham.getDistance(cube));
				gen++;
			} else{

				break;
			}
		}
	}
}