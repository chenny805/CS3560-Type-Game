package rooms;

import items.Item;

public class NorthRoom extends Room {
	private String description = "This is the north room.";
	private Room north;
	private Room south;
	private Room east;
	private Room west;
	private Item[] items;
	
	public NorthRoom() {}
	
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
	
	public boolean isInRoom(Item item) {
		for (int i = 0; i < items.length; i++)
			if (items[i] == item)
				return true;
		return false;
	}

}
