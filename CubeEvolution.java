import java.util.*;

public class CubeEvolution{

	public Cube evolve(Cube cube, int depth){

		return nextGen(cube, depth);
	}

	private Cube nextGen(Cube cube, int checks){

		if(checks < 1)
			return cube;
        
        Hamming ham = new Hamming();
        if(ham.getDistance(cube) == 0)
            return cube;

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

		Cube[] genCheck = new Cube[options.length];
		for(int i = 0; i < genCheck.length; i++)
			genCheck[i] = nextGen(options[i], checks-1);

		return genCheck[ham.mostFit(genCheck)];
	}
}
