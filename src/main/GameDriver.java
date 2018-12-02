package main;
import gui.*;
import items.*;
import rooms.*;

public class GameDriver {
	static GameState gs = GameState.getInstance();

	public static void main(String[] args) {
		//initialization
//		GameGUI ui = new GameGUI();
//		TextManager tm = new TextManager(ui);
//		PlayerState ps = new PlayerState();
//		ps.eat(new Apple());
		//run game
		//open start menu
		
		boolean gameComplete = false;
		while(!gameComplete) {
			//get prompt
			//prompt user
			//get input
			String input = gs.tm.getInput();
			//parse input
			String[] user_command = TextManager.parseInput(input);
			//execute command
			execute(user_command);
		}

	}
	
	private static void execute(String[] command_and_object) {
		String command = command_and_object[0];
		String object = command_and_object[1];
//		System.out.println("Command: "+command+"\tObject: "+object);
		switch(command) {
			case "use": 
				System.out.println("Using...");
				break;
				
			case "eat": 
				gs.ps.eat(object);
				break;
				
//			case "move":
//				gs.move();//fix me
				
			case "x":
			case "ex":
			case "examine":
				break;
				
			default:
				gs.tm.print("Unknown command!");
				break;
		}
	}
	
}
