import java.util.*;

public class InOut{

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_WHITE = "\u001B[37m";
	private static final String ANSI_CYAN = "\u001B[36m";

	public void println(String output){

		System.out.println(output);
	}

	public void print(String output){

		System.out.print(output);
	}

	public void colorPrint(String color, String output){
	
		switch(color){
			
			case "RED":
				println(ANSI_RED+output+ANSI_RESET);
				break;

			case "GREEN":
				println(ANSI_GREEN+output+ANSI_RESET);
				break;

			case "YELLOW":
				println(ANSI_YELLOW+output+ANSI_RESET);
				break;

			case "BLUE":
				println(ANSI_BLUE+output+ANSI_RESET);
				break;

			case "CYAN":
				println(ANSI_CYAN+output+ANSI_RESET);
				break;

			default:
				println(output);
				break;
		}
	}
}
