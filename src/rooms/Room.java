package rooms;
import items.*;
import java.util.ArrayList;


public class Room {
	private String description = "This is the abstract Room class.";
	private Room north;
	private Room south;
	private Room east;
	private Room west;
//	private Item[] items;

	public static final int NO_ROOM = -1; 
	public static final int INVALID_DIRECTION = -2;
	protected ArrayList<Item> items;
	protected boolean locked;

	public Room() {
		locked = false;
		description = "No description";
		items = new ArrayList<Item>();
	}
	
	public String getDescription() {
		return description;
	}
	
	public Room goNorth() {
		return north;
	}
	public Room goSouth() {
		return south;
	}
	public Room goEast() {
		return east;
	}
	public Room goWest() {
		return west;
	}
	
	public void setNorth(Room r) {
		north = r;
	}
	public void setSouth(Room r) {
		south = r;
	}
	public void setEast(Room r) {
		east = r;
	}
	public void setWest(Room r) {
		west = r;
	}
		
	//*** GETTERS ***//
	
	public Item getItem(Item item) {
		// item has to be removed from items list
		return null;// return the specified item
	}
	public boolean isLocked() {
		return locked;
	}
	
	//*** SETTERS ***//
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void addItem(Item item) {
		items.add(item);
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	@Override
	public String toString() {
		String des = "items: " + "\n"
				+ "description: " + description + "\n"
				+ "east: " + east + "\n"
				+ "north: " + north + "\n"
				+ "south: " + south + "\n"
				+ "west: " + west + "\n"
				+ "locked: " + locked;
				
		return des;
	}

}
