package rooms;

import main.*;

public class GameMap {
	
	//initialize all the rooms you're including
	Room spawn = new StartRoom();
	Room n1 = new NorthRoom();
	//keep track of the current room
	public Room current_room;
	
	public GameMap() {
		//when initialized, set the spawn room and build the map
		current_room = spawn;
		couple(spawn, n1, "north");
	}
	
	public void moveRoom(String r) {
		Room destination;
	    switch(r) {
	    	case "east":
	    	case "e":
	    		destination = current_room.goEast();
	    		break;
	    	case "north":
	    	case "n":
	    		destination = current_room.goNorth();
	    		break;
	    	case "south":
	    	case "s":
	    		destination = current_room.goSouth();
	    		break;
	    	case "west":
	    	case "w":
	    		destination = current_room.goWest();
	    		break;
	    	default:
	    		destination = current_room;
	    }
	    if(destination != null) {
	    	current_room = destination;
	    	TextManager.print(current_room.getDescription());
	    }
	    else TextManager.print("You can't go that way!");
	}
	
	private void couple(Room first, Room second, String direction) {
		switch(direction) {
		case "north":
			first.setNorth(second);
			second.setSouth(first);
			break;
		case "south":
			first.setSouth(second);
			second.setNorth(first);
			break;
		case "east":
			first.setEast(second);
			second.setWest(first);
			break;
		case "west":
			first.setWest(second);
			second.setEast(first);
			break;
		}
	}
	
}
