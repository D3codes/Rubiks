import java.util.*;

public class CubeEvolution{

	private InOut io = new InOut();

	public Cube evolve(Cube cube, int depth){


		Cube[] options = makeOptions(cube);
		int[] fitArray = fitnessOptions(cube, depth);

		Boolean allSame = true;
		int fitness = fitArray[0];
		for(int i = 0; i < fitArray.length; i++)
			if(fitArray[i] != fitness)
				allSame = false;

		if(allSame){

			if(fitness == 0)
				return solve(cube);

			Random rand = new Random();
			return options[rand.nextInt(options.length)];
		}

		fitness = 100;
		int index = 0;
		for(int i = 0; i < fitArray.length; i++){
			
			io.print(fitArray[i]+"-");
			if(fitArray[i] <= fitness){
				fitness = fitArray[i];
				index = i;
			}
		}
		io.println("\n"+index);

		return options[index];
	}

	public Cube solve(Cube cube){

		Queue<int[][]> queue = new LinkedList<int[][]>();
		Cube check = new Cube(cube.getFaces());
		Hamming ham = new Hamming();
		int checks = 1;

		while(true){
			
			//check.printCube();
			if(ham.getDistance(check) == 0){
			
				check.printCube();
				io.println("Solved!\t| Number of checks: "+checks);
				return check;
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
	}

	private int[] fitnessOptions(Cube cube, int depth){

		int[] answers = new int[12];
		Cube[] options = makeOptions(cube);

		for(int i = 0; i < answers.length; i++)
			answers[i] = mostFit(options[i], depth, 100);

		return answers;
	}

	private int mostFit(Cube cube, int depth, int fitness){

		//io.println(""+fitness);

		if(depth < 1)
			return fitness;

		Cube[] options = makeOptions(cube);
		Hamming ham = new Hamming();
		for(int i = 0; i < options.length; i++){

			if(ham.getDistance(options[i]) < fitness)
				fitness = ham.getDistance(options[i]);

			fitness = mostFit(options[i], depth-1, fitness);
		}

		return fitness;
	}

	private Cube[] makeOptions(Cube cube){

		Cube[] options = new Cube[12];
		for(int i = 0; i < options.length; i++)
			options[i] = new Cube(cube.getFaces());

		options[0].right();
		options[1].rightInv();
		options[2].left();
		options[3].leftInv();
		options[4].up();
		options[5].upInv();
		options[6].down();
		options[7].downInv();
		options[8].front();
		options[9].frontInv();
		options[10].back();
		options[11].backInv();

		return options;
	}

	private Cube nextGen(Cube cube, int depth){

		if(depth < 1)
			return cube;
        
        Hamming ham = new Hamming();
        if(ham.getDistance(cube) == 0)
            return cube;

		Cube[] options = makeOptions(cube); 

		Cube[] genCheck = new Cube[options.length];
		for(int i = 0; i < genCheck.length; i++)
			genCheck[i] = nextGen(options[i], depth-1);

		return genCheck[ham.mostFit(genCheck)];
	}

	/*private int[] mostFit(Cube cube, int maxFit, int maxInd, int depth){

		if(depth < 1){

			int[] tmp = {maxFit, maxInd};
			return tmp;
		}

		Cube[] options = makeOptions(cube);

		int[] fitness = new int[12];
		for(int i = 0; i < fitness.length; i++)
			fitness[i] = 100;

		Hamming ham = new Hamming();
		for(int i = 0; i < options.length; i++){

			if(ham.getDistance(options[i]) < maxFit){

				maxFit = ham.getDistance(options[i]);
				maxInd = i;
			}

			int[] tmp = mostFit(options[i], maxFit, maxInd, depth-1);
			maxFit = tmp[0];
			maxInd = tmp[1];
		}

		int[] answer = {maxFit, maxInd};
		return answer;
	}*/
}
