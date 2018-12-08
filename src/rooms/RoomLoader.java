package rooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import items.*;
import main.TextManager;

public class RoomLoader {
	private final int DOLLAR_SIGN = '$';
	private final int FIRST_CHAR_POS = 0;
	private Room room; 
	private Scanner scn;
	
	private interface checkState{
		void check(String line);
	}
	
	// Array of functions
	// Contains the functions that represent the states 
	private checkState[] states = new checkState[] {
		new checkState() {public void check(String line) {getItems(line);}},
		new checkState() {public void check(String line) {getDescription(line);}},
		new checkState() {public void check(String line) {getLockStatus(line);}}
	};
	
	public void getItems(String line) {
		line = scn.nextLine();
		while(line.charAt(0) != DOLLAR_SIGN) {
			// write the code that loads the items
			line = scn.nextLine();
		}
	}
	
	private void getDescription(String line) {
		room.setDescription(line.substring(13));
	}
	
	private void getLockStatus(String line) {
		room.setLocked(Boolean.parseBoolean(line.substring(8)));
	}
	
	public RoomLoader(){
//		room = new Room();
		scn = null;
	}
	
	public Room loadRoom(String roomFile) {
		room = new Room();
//		try {
			scn = new Scanner(TextManager.getTextFromFile(roomFile));
////		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		int temp = 0;
		while(scn.hasNextLine()) {
			String line = scn.nextLine();
			if(line.charAt(FIRST_CHAR_POS) == DOLLAR_SIGN)
				states[temp++].check(line);
		}
		return room;
	}
	
	
}
