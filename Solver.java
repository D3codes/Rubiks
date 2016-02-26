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
				
				cube = ce.evolve(cube, 4);	
				
				turns++;
				cube.printCube();
				io.println("Turns: "+turns+"\t| Fitness: "+ham.getDistance(cube));

			} else{

				break;
			}
		}//solve(cube);
	}

	public static void solve(Cube cube){

		Queue<int[][]> queue = new LinkedList<int[][]>();
		Cube check = new Cube(cube.getFaces());
		Hamming ham = new Hamming();
		InOut io = new InOut();
		int checks = 1;

		while(true){
			
			//check.printCube();
			if(ham.getDistance(check) == 0){
			
				check.printCube();
				break;
			}

			queue.add(check.r());
			queue.add(check.rI());
			queue.add(check.l());
			queue.add(check.lI());
			queue.add(check.f());
			queue.add(check.fI());
			queue.add(check.b());
			queue.add(check.bI());
			queue.add(check.u());
			queue.add(check.uI());
			queue.add(check.d());
			queue.add(check.dI());
			
			check = new Cube(queue.remove());
			checks++;
		}
		
		io.println("Solved!\t| Number of checks: "+checks);
	}
}
