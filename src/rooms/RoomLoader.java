package rooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import items.*;

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
		new checkState() {public void check(String line) {getId(line);}},
		new checkState() {public void check(String line) {getPicture(line);}},
		new checkState() {public void check(String line) {getItems(line);}},
		new checkState() {public void check(String line) {getDescription(line);}},
		new checkState() {public void check(String line) {getEast(line);}},
		new checkState() {public void check(String line) {getNorth(line);}},
		new checkState() {public void check(String line) {getSouth(line);}},
		new checkState() {public void check(String line) {getWest(line);}},
		new checkState() {public void check(String line) {getLockStatus(line);}}
	};
	
	private void getId(String line){
		room.setId(Integer.parseInt(line.substring(4)));
	}
	
	private void getPicture(String line) {
		room.setPictureFile(line.substring(9));
	}
	
	private void getItems(String line) {
		line = scn.nextLine();
		while(line.charAt(0) != DOLLAR_SIGN) {
			// write the code that loads the items
			line = scn.nextLine();
		}
	}
	
	private void getDescription(String line) {
		room.setDescription(line.substring(13));
	}
	
	private void getNorth(String line) {
		room.setNorthRoom(Integer.parseInt(line.substring(7)));
	}

	private void getEast(String line) {
		room.setEastRoom(Integer.parseInt(line.substring(6)));
	}
	
	private void getSouth(String line) {
		room.setSouthRoom(Integer.parseInt(line.substring(7)));
	}
	
	private void getWest(String line) {
		room.setWestRoom(Integer.parseInt(line.substring(6)));
	}
	
	private void getLockStatus(String line) {
		room.setLocked(Boolean.parseBoolean(line.substring(8)));
	}
	
	public RoomLoader(){
		room = new Room();
		scn = null;
	}
	
	public Room loadRoom(String roomFile) {
		room = new Room();
		try {
			scn = new Scanner(new File(roomFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int temp = 0;
		while(scn.hasNextLine()) {
			String line = scn.nextLine();
			if(line.charAt(FIRST_CHAR_POS) == DOLLAR_SIGN)
				states[temp++].check(line);
		}
		return room;
	}
}
