package main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import gui.*;
import java.util.Scanner;
import java.util.Arrays;

public class TextManager {
	static GameState gs = GameState.getInstance();
	static GameGUI ui = new GameGUI();
	static int defaultTextSpeed = 1;
	static int textSpeedModifier = 1;
	
	//constructor
	public TextManager() {
	}
	
	//prints the string on screen
	public static void print(String text) {
		ui.output.append(text);
		//scrolls text as it is printed
		ui.output.setCaretPosition(ui.output.getText().length());
	}
	
	//types the string on screen, one character at a time
	public static void talk(String text) {
		char[] arr = text.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			print(Character.toString(arr[i]));
			try {
			       Thread.currentThread().sleep(defaultTextSpeed/textSpeedModifier);
			}
			catch (InterruptedException e) {
//			       e.printStackTrace();
			}
		}
		enter();
	}
	
	//prints a new line
	public static void enter() {
		print("\n");
	}
	
	//returns the content of the text file 'filename'
	public static String getTextFromFile(String filename) {
		try {
			String returnString = "";
			File filepath = new File("src/textfiles/" + filename);
			Scanner s = new Scanner(filepath);
			while(s.hasNextLine()) {
				returnString = returnString + s.nextLine() + "\n";
			}
			s.close();
			return returnString;
		} catch(Exception e) {
			print("\nFile not found! Destination file: " + filename);
		}
		return "\n\nFILE ERROR\n\n";
	}
	
	public static String getInput() {
		while (!ui.textInBuffer) {
			//wait
			try {
			       Thread.currentThread().sleep(100);
			}
			catch (InterruptedException e) {
//			       e.printStackTrace();
			}
		}
		ui.textInBuffer = false;
		return ui.bufferText;
	}
	
	public static String[] parseInput(String s) {
//		print("\nTokens:\n");
		enter();
		String[] words = s.split("\\s");
		//temp: print separated words
		//all input: toLowerCase!
		print("    >");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
			print(words[i] + " ");
		}
		enter();
		String[] command_and_object = interpret(words);
		return command_and_object;
	}
	
	private static String[] interpret(String[] words) {
		//get commands from file
		String commands_list[] = {
				"eat",
				"move",
				"use"
		};
		//get values from file
		String values_list[] = {
				"apple"
		};
		boolean command_found = false;
		boolean value_found = false;
		//array to return with the command and value strings
		String[] save = {"No command found.","No value found."};
		//check each token to see if it is a command or value, and save them if so.
//		for(int i = 0; i < words.length; i++) {
//			if(!command_found) {
//				for(int j = 0; j < commands_list.length; j++) {
//					if(words[i].equals(commands_list[j])) {
//						save[0] = words[i];
//						command_found = true;
//					}
//				}
//			}
//			if(!value_found ) {
//				for(int j = 0; j < values_list.length; j++) {
//					if(words[i].equals(values_list[j])) {
//						save[1] = words[i];
//						value_found = true;
//					}
//				}
//			}
//		}
try		{
save[0] = words[0];
	} catch(Exception e) {}
try {
save[1] = words[1];
} catch(Exception e) {}
		
		System.out.println(Arrays.toString(save));
		return save;
	}

}
