public class Algorithms{

	private int[] RW = {1,4};
	private int[] RY = {1,5};
	private int[] OY = {3,5};
	private int[] OW = {3,4};

	public Cube fillMiddle(Cube cube){

		cube = placeRW(cube);
		cube = placeRY(cube);
		cube = placeOY(cube);
		cube = placeOW(cube);

		return cube;
	}

	private Cube placeRW(Cube cube){

		int[] location = blockLocator(cube, RW);

		if(location[0] == 2){

			cube.changeOrientation(4,1);

			switch(location[1]){

				case 1:
					cube.up();
					break;

				case 3:
					cube.upInv();
					break;

				case 5:
					cube.up();
					cube.up();
					break;

				default:
					break;
			}

			return moveRight(cube);
		}

		if(location[1] == 2){

			cube.changeOrientation(1,5);

			switch(location[0]){

				case 3:
					cube.up();
					cube.up();
					break;

				case 4:
					cube.upInv();
					break;

				case 5:
					cube.up();
					break;

				default:
					break;
			}

			return moveLeft(cube);
		}

		cube.changeOrientation(4,1);
		cube = moveRight(cube);
		cube.changeOrientation(3,4);
		cube = moveRight(cube);
		cube.changeOrientation(5,3);
		cube = moveRight(cube);
		cube.changeOrientation(1,5);
		cube = moveRight(cube);

		return placeRW(cube);
	}

	private Cube placeRY(Cube cube){

		int[] location = blockLocator(cube, RY);

		if(location[0] == 2){

			cube.changeOrientation(5,3);

			switch(location[1]){

				case 1:
					cube.upInv();
					break;

				case 3:
					cube.up();
					break;

				case 4:
					cube.up();
					cube.up();
					break;

				default:
					break;
			}

			return moveLeft(cube);
		}

		if(location[1] == 2){

			cube.changeOrientation(1,5);

			switch(location[0]){

				case 3:
					cube.up();
					cube.up();
					break;

				case 4:
					cube.upInv();
					break;

				case 5:
					cube.up();
					break;

				default:
					break;
			}

			return moveRight(cube);
		}

		cube.changeOrientation(3,4);
		cube = moveRight(cube);
		cube.changeOrientation(5,3);
		cube = moveRight(cube);
		cube.changeOrientation(1,5);
		cube = moveRight(cube);

		return placeRY(cube);
	}

	private Cube placeOY(Cube cube){

		int[] location = blockLocator(cube, OY);

		if(location[0] == 2){

			cube.changeOrientation(5,3);

			switch(location[1]){

				case 1:
					cube.upInv();
					break;

				case 3:
					cube.up();
					break;

				case 4:
					cube.up();
					cube.up();
					break;

				default:
					break;
			}

			return moveRight(cube);
		}

		if(location[1] == 2){

			cube.changeOrientation(3,4);

			switch(location[0]){

				case 1:
					cube.up();
					cube.up();
					break;

				case 4:
					cube.up();
					break;

				case 5:
					cube.upInv();
					break;

				default:
					break;
			}

			return moveLeft(cube);
		}

		cube.changeOrientation(3,4);
		cube = moveRight(cube);
		cube.changeOrientation(5,3);
		cube = moveRight(cube);

		return placeOY(cube);
	}

	private Cube placeOW(Cube cube){

		int[] location = blockLocator(cube, OW);

		if(location[0] == 2){

			cube.changeOrientation(4,1);

			switch(location[1]){

				case 1:
					cube.up();
					break;

				case 3:
					cube.upInv();
					break;

				case 5:
					cube.up();
					cube.up();
					break;

				default:
					break;
			}

			return moveLeft(cube);
		}

		if(location[1] == 2){

			cube.changeOrientation(3,4);

			switch(location[0]){

				case 1:
					cube.up();
					cube.up();
					break;

				case 4:
					cube.up();
					break;

				case 5:
					cube.upInv();
					break;

				default:
					break;
			}

			return moveRight(cube);
		}

		cube.changeOrientation(3,4);
		cube = moveRight(cube);

		return placeOW(cube);
	}

	private Cube moveRight(Cube cube){

		cube.up();
		cube.right();
		cube.upInv();
		cube.rightInv();
		cube.upInv();
		cube.frontInv();
		cube.up();
		cube.front();

		return cube;
	}

	private Cube moveLeft(Cube cube){

		cube.upInv();
		cube.leftInv();
		cube.up();
		cube.left();
		cube.up();
		cube.front();
		cube.upInv();
		cube.frontInv();

		return cube;
	}

	private int[] blockLocator(Cube cube, int[] block){

		int[][] faces = cube.getFaces();

		for(int i = 1; i < 9; i+=2){

			if(faces[2][i] == block[0]){

				switch(i){

					case 1:
						if(faces[4][1] == block[1])
							return new int[]{2,4};

						break;

					case 3:
						if(faces[1][5] == block[1])
							return new int[]{2,1};

						break;

					case 5:
						if(faces[3][3] == block[1])
							return new int[]{2,3};

						break;

					case 7:
						if(faces[5][7] == block[1])
							return new int[]{2,5};

						break;

					default:
						break;
				}	
			} else if(faces[2][i] == block[1]){

				switch(i){

					case 1:
						if(faces[4][1] == block[0])
							return new int[]{4,2};

						break;

					case 3:
						if(faces[1][5] == block[0])
							return new int[]{1,2};

						break;

					case 5:
						if(faces[3][3] == block[0])
							return new int[]{3,2};

						break;

					case 7:
						if(faces[5][7] == block[0])
							return new int[]{5,2};

						break;

					default:
						break;
				}
			}
		}

		if(faces[1][1] == block[0] && faces[4][5] == block[1])
			return new int[]{1,4};

		if(faces[4][5] == block[0] && faces[1][1] == block[1])
			return new int[]{4,1};

		if(faces[1][7] == block[0] && faces[5][5] == block[1])
			return new int[]{1,5};

		if(faces[5][5] == block[0] && faces[1][7] == block[1])
			return new int[]{5,1};

		if(faces[3][1] == block[0] && faces[4][3] == block[1])
			return new int[]{3,4};

		if(faces[4][3] == block[0] && faces[3][1] == block[1])
			return new int[]{4,3};

		if(faces[3][7] == block[0] && faces[5][3] == block[1])
			return new int[]{3,5};

		if(faces[5][3] == block[0] && faces[3][7] == block[1])
			return new int[]{5,3};

		return new int[]{-1,-1};
	}
}