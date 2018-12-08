package rooms;

import main.*;

public class GameMap {
	
	//initialize all the rooms you're including
	public RoomLoader rl = new RoomLoader();
	Room spawn = rl.loadRoom("room0.txt");
	Room n1 = rl.loadRoom("room1.txt");
	Room n2 = rl.loadRoom("room2.txt");
	Room n3 = rl.loadRoom("room3.txt");
	Room n4 = rl.loadRoom("room4.txt");
	Room n5 = rl.loadRoom("room5.txt");
	Room n6 = rl.loadRoom("room6.txt");
	Room n7 = rl.loadRoom("room7.txt");
	Room n8 = rl.loadRoom("room8.txt");
	Room n9 = rl.loadRoom("room9.txt");
	Room n10 = rl.loadRoom("room10.txt");
	Room n11 = rl.loadRoom("room11.txt");
	Room n12 = rl.loadRoom("room12.txt");
	Room n13 = rl.loadRoom("room13.txt");
	Room n14 = rl.loadRoom("room14.txt");
	Room n15 = rl.loadRoom("room15.txt");

	//keep track of the current room
	public Room current_room;
	
	public GameMap() {
		//when initialized, set the spawn room and build the map
		current_room = spawn;
		couple(spawn, n1, "north");
		couple(spawn, n3, "east");
		couple(spawn, n5, "south");
		couple(spawn, n7, "west");
		
		couple(n1, n2, "east");
		couple(n1, n14, "north");
		
		couple(n2, n3, "south");
		
		couple(n5, n4, "east");
		couple(n5, n6, "west");
		
		couple(n6, n9, "south");
		
		couple(n9, n10, "east");
		
		couple(n7, n8, "north");
		
		couple(n8, n11, "north");
		
		couple(n11, n12, "west");
		
		couple(n12, n13, "south");
		
		couple(n14, n15, "east");
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
	    	Encounter event = new Encounter(3);
	    	event.run();
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
