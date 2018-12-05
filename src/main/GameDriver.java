package main;
import gui.*;
import items.*;

public class GameDriver {
	static GameState gs = GameState.getInstance();

	public static void main(String[] args) {
		initialPrompt();
		boolean gameComplete = false;
		while(!gameComplete) {
			String input = gs.tm.getInput();
			String[] user_command = TextManager.parseInput(input);
			executeCommand(user_command);
		}
	}
	
	private static void initialPrompt() {
		gs.tm.print(">> Welcome to our Adventure Game."
				+ "\n>> Simply type single commands, or commands with object names to interact with the world."
				+ "\n>> Try typing 'examine' to look at the room around you."
				+ "\n>> Or you can type 'help' for a list of possible command words.");
	}
	
	private static void executeCommand(String[] command_and_object) {
		String command = command_and_object[0];
		String object = command_and_object[1];
		switch(command) {
			case "use": 
//				System.out.println("Using...");
				break;
				
			case "take":
			case "t":
			case "pickup":
//				if(gs.gm.current_room.isInRoom(object))
					
				break;
				
			case "eat": 
				gs.ps.eat(object);
				break;
				
			case "move":
			case "m":
			case "mv":
				gs.gm.moveRoom(object);
				break;
				
			case "x":
			case "ex":
			case "examine":
				if (object != "No value found.")
					gs.tm.print(object);//fix me- "object" -> getDescription
				else
					gs.tm.print(gs.gm.current_room.getDescription());
				break;
				
			case "h":
			case "help":
				gs.tm.print(gs.tm.getTextFromFile("help"));
				break;
				
			default:
				gs.tm.print("Unknown command!");
				break;
		}
	}
	
}
