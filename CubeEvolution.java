import java.util.*;

public class CubeEvolution{

	private InOut io = new InOut();

	public Cube evolve(Cube cube, int[][] goal, int depth){

		Hamming ham = new Hamming();
		if(ham.getDistanceToGoal(cube, goal) == 0)
			return cube;

		int[] fitArray = fitnessOptions(cube, goal, depth);

		int fitness = 100;
		for(int i = 0; i < fitArray.length; i++){
			
			io.print(fitArray[i]+"-");
			if(fitArray[i] <= fitness)
				fitness = fitArray[i];
		}
		io.println("\nmost fit: "+fitness);

		ArrayList<Integer> indexOfSameValues = new ArrayList<Integer>();
		for(int i = 0; i < fitArray.length; i++)
			if(fitArray[i] == fitness)
				indexOfSameValues.add(i);

		int index;
		if(indexOfSameValues.size() == 1){

			index = indexOfSameValues.get(0);
			io.println("index: "+index);
		}else{

			index = shortestDistance(cube, goal, depth, indexOfSameValues, fitness);
			io.println("shortest distance: "+index);
		}

		Cube[] options = makeOptions(cube);
		return options[index];
	}

	private int shortestDistance(Cube cube, int[][] goal, int depth, ArrayList<Integer> indexes, int fitness){

		Cube[] options = makeOptions(cube);
		int[] answers = new int[indexes.size()];

		for(int i = 0; i < answers.length; i++)
			answers[i] = calculateDistance(options[indexes.get(i)], goal, depth, fitness, 0);

		int lowestIndex = 0;
		int lowestDistance = 100;
		for(int i = 0; i < answers.length; i++){

			//io.println(""+answers[i]);
			if(answers[i] < lowestDistance){
				lowestDistance = answers[i];
				lowestIndex = i;
			}
		}

		return indexes.get(lowestIndex);
	}

	private int calculateDistance(Cube cube, int[][] goal, int depth, int fitness, int counter){

		Hamming ham = new Hamming();
		if(depth < 1 || ham.getDistanceToGoal(cube, goal) == fitness)
			return counter;

		Cube[] options = makeOptions(cube);
		int lowestNum = 100;
		for(int i = 0; i < options.length; i++){
			int tmp = calculateDistance(options[i], goal, depth-1, fitness, counter+1);

			if(tmp < lowestNum)
				lowestNum = tmp;
		}

		return lowestNum;
	}

	private int[] fitnessOptions(Cube cube, int[][] goal, int depth){

		int[] answers = new int[12];
		Cube[] options = makeOptions(cube);

		for(int i = 0; i < answers.length; i++)
			answers[i] = mostFit(options[i], goal, depth, 100);

		return answers;
	}

	private int mostFit(Cube cube, int[][] goal, int depth, int fitness){

		//io.println(""+fitness);

		if(depth < 1)
			return fitness;

		Cube[] options = makeOptions(cube);
		Hamming ham = new Hamming();
		for(int i = 0; i < options.length; i++){

			if(ham.getDistanceToGoal(options[i], goal) < fitness)
				fitness = ham.getDistanceToGoal(options[i], goal);

			fitness = mostFit(options[i], goal, depth-1, fitness);
		}

		return fitness;
	}

	public Cube BFS(Cube cube){

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

	public Cube nextGen(Cube cube, int depth){

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
