package main;
import gui.*;
import items.*;

public class GameDriver {
	static GameState gs = GameState.getInstance();

	public static void main(String[] args) {
		gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory());
		initialPrompt();
		boolean gameComplete = false;
		while(!gameComplete) {
			String input = gs.tm.getInput();
			String[] user_command = TextManager.parseInput(input);
			executeCommand(user_command);
		}
	}
	
	private static void initialPrompt() {
		gs.tm.talk(">> Welcome to our Adventure Game."
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
				//askPlayer();
				gs.gm.moveRoom(object);
				roomNumber = gs.gm.current_room.getDescription(); // roomNumber = "Room 1"
				String fileName = findFileName(roomNumber);
				RoomLoader rl = new RoomLoader();
				rl.loadRoom(fileName);
				gs.tm.ui.room_info.setText(roomNumber);
				
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
	
	
	// appoint the room number to appropriate room.txt file
	private static String findFileName(String roomName) {
		StringBuilder sb = new StringBuilder();
		int index1 = roomName.length()-2;
		int index2 = roomName.length()-1;
		sb.append("room");
		if (roomName.length() == 6) {
			sb.append(roomName.charAt(index2));
		} else {
			sb.append(roomName.charAt(index1));
			sb.append(roomName.charAt(index2));
		}
			
			sb.append(".txt");
		return sb.toString();
	}
	
	private static void askPlayer() {
		boolean gameComplete = false;
		gs.tm.talk(">> A minigame is about to begin. If you would like to use items before starting please do so now. Type done when ready.");
		String input = gs.tm.getInput();
		String[] user_command = TextManager.parseInput(input);
		String command = user_command[0];
		while(!gameComplete) {
			if(command.equals("move")) {
				gs.tm.talk("Can't move right now");
				input = gs.tm.getInput();
				user_command = TextManager.parseInput(input);
				command = user_command[0];
			} else if(command.equals("m")) {
				gs.tm.talk("Can't move right now");
				input = gs.tm.getInput();
				user_command = TextManager.parseInput(input);
				command = user_command[0];
			} else if(command.equals("mv")) {
				gs.tm.talk("Can't move right now");
				input = gs.tm.getInput();
				user_command = TextManager.parseInput(input);
				command = user_command[0];
			} else if(command.equals("done")) {
				gameComplete = true;
			} else {
				executeCommand(user_command);
				input = gs.tm.getInput();
				user_command = TextManager.parseInput(input);
				command = user_command[0];
			}
		}
	}
}
