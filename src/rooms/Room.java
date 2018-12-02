package rooms;
import java.util.ArrayList;

import items.*;

public class Room {
	public static final int NO_ROOM = -1; 
	public static final int INVALID_DIRECTION = -2;
	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;
	protected int id;
	protected String description;
//	protected int northRoomId;
//	protected int southRoomId;
//	protected int eastRoomId;
//	protected int westRoomId;
	protected int[] nextRoom;
	protected String pictureFile;
	protected ArrayList<Item> items;
	protected boolean locked;
	//array of their accessibility
	
	public Room() {
		locked = false;
		id = 0;
		nextRoom = new int[4];
		for(int i = 0; i < 4; i++)
			nextRoom[i] = NO_ROOM;
		description = "No description";
		pictureFile = "";
		items = new ArrayList<Item>();
	}
	
	//*** GETTERS ***//
	
	public Item getItem(Item item) {
		// item has to be removed from items list
		return null;// return the specified item
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	public int getNextRoomId(int direction) {
		if(direction < 0 || direction >= 4)
			return INVALID_DIRECTION;
		return this.nextRoom[direction];
	}
	public int getNorth() {
		return nextRoom[NORTH];
	}
	public int getSouth() {
		return nextRoom[SOUTH];
	}
	public int getEast() {
		return nextRoom[EAST];
	}
	public int getWest() {
		return nextRoom[WEST];
	}
	public String getPictureFile() {
		return pictureFile;
	}
	public boolean isLocked() {
		return locked;
	}
	
	//*** SETTERS ***//
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setNorthRoom(int roomId) {
		nextRoom[NORTH] = roomId;
	}
	public void setSouthRoom(int roomId) {
		nextRoom[SOUTH] = roomId;
	}
	public void setEastRoom(int RoomId) {
		nextRoom[EAST] = RoomId;
	}
	public void setWestRoom(int roomId) {
		nextRoom[WEST] = roomId;
	}
	public void setPictureFile(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	public void addItem(Item item) {
		items.add(item);
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	@Override
	public String toString() {
		String des = "id: " + id + "\n"
				+ "picture file: " + pictureFile + "\n"
				+ "items: " + "\n"
				+ "description: " + description + "\n"
				+ "east: " + nextRoom[EAST] + "\n"
				+ "north: " + nextRoom[NORTH] + "\n"
				+ "south: " + nextRoom[SOUTH] + "\n"
				+ "west: " + nextRoom[WEST] + "\n"
				+ "locked: " + locked;
				
		return des;
	}
}
