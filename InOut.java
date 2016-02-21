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

			case "CYAN":
				print(ANSI_CYAN+output+ANSI_RESET);
				break;

			default:
				print(output);
				break;
		}
	}
}
