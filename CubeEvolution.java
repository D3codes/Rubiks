import java.util.*;

public class CubeEvolution{

	public Cube evolve(Cube cube){

		return nextGen(cube, 4);
	}

	private Cube nextGen(Cube cube, int checks){

		if(checks < 1)
			return cube;

		Cube[] options = new Cube[50];
		for(int i = 0; i < 50; i++)
			options[i] = new Cube(cube.getFaces());

		options[1].scramble();
		options[2].scramble();
		options[3].scramble();

		for(int i = 4; i < 50; i++)
			options[i] = randomTurn(options[i]);

		for(int i = 20; i < 50; i++)
			options[i] = randomTurn(options[i]);

		for(int i = 35; i < 50; i++)
			options[i] = randomTurn(options[i]);

		Cube[] genCheck = new Cube[50];
		for(int i = 0; i < 50; i++)
			genCheck[i] = nextGen(options[i], checks-1);

		Hamming ham = new Hamming();

		return ham.mostFit(genCheck);
	}

	private Cube randomTurn(Cube cube){

		Random rand = new Random();

		switch(rand.nextInt(12)){

			case 0:
				cube.right();
				break;

			case 1:
				cube.rightInv();
				break;

			case 2:
				cube.left();
				break;

			case 3:
				cube.leftInv();
				break;

			case 4:
				cube.up();
				break;

			case 5:
				cube.upInv();
				break;

			case 6:
				cube.down();
				break;

			case 7:
				cube.downInv();
				break;

			case 8:
				cube.front();
				break;

			case 9:
				cube.frontInv();
				break;

			case 10:
				cube.back();
				break;

			case 11:
				cube.backInv();
				break;

			default:
				break;
		}

		return cube;
	}
}