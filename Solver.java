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
		int turns = 0;
		while(true){

			if(ham.getDistance(cube) != 0){

				if(ham.getDistance(cube) < 10){
					cube = ce.evolve(cube, 10);
					
				} else if(ham.getDistance(cube) < 20) {
					cube = ce.evolve(cube, 5);
					
				}else{
					cube = ce.evolve(cube, 4);
				}
				
				turns++;
				cube.printCube();
				io.println("Turns: "+turns+"\t| Fitness: "+ham.getDistance(cube));

			} else{

				break;
			}
		}
	}
}
