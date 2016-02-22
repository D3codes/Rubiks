import java.util.*;

public class InOut{

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_WHITE = "\u001B[37m";
	private static final String ANSI_PURPLE = "\u001B[35m";

	private static final String ANSI_CLEAR = "\u001b[2J";
	private static final String ANSI_HOME = "\u001b[H";

	private Scanner scanner = new Scanner(System.in);

	public void clear()
	{
		System.out.print(ANSI_CLEAR+ANSI_HOME);
	}

	public void println(String output){

		System.out.println(output);
	}

	public void print(String output){

		System.out.print(output);
	}

	public void printError(String output){

		System.err.println(output);
	}

	public void colorPrint(String color, String output){
	
		switch(color){
			
			case "RED":
				print(ANSI_RED+output+ANSI_RESET);
				break;

			case "GREEN":
				print(ANSI_GREEN+output+ANSI_RESET);
				break;

			case "YELLOW":
				print(ANSI_YELLOW+output+ANSI_RESET);
				break;

			case "BLUE":
				print(ANSI_BLUE+output+ANSI_RESET);
				break;

			case "PURPLE":
				print(ANSI_PURPLE+output+ANSI_RESET);
				break;

			case "WHITE":
				print(ANSI_WHITE+output+ANSI_RESET);
					break;

			default:
				print(output);
				break;
		}
	}

	public char getChar(){

		return(scanner.nextLine().charAt(0));
	}

	public String getString(){

		return(scanner.nextLine());
	}

	public int getInt(){

		int val = scanner.nextInt();
		scanner.nextLine();
		return(val);
	}
}
