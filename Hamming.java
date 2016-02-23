public class Hamming{

	public int getDistance(Cube cube){

		int distance = 0;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				if(cube.getFaces()[i][j] != i)
					distance++;

		return distance;
	}

	public Cube mostFit(Cube[] options){

		int most = 0;
		int fitness = getDistance(options[0]);

		for(int i = 1; i < options.length; i++)
			if(getDistance(options[i]) < fitness){

				fitness = getDistance(options[i]);
				most = i;
			}

		return options[most];
	}
}