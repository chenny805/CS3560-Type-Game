package rooms;

public class GameMap {
	private Room[] rooms;
	
	private int currentRoom; // it holds the id of the room
	
	public GameMap() {
		rooms = new Room[16];
		RoomLoader loader = new RoomLoader();
		for(int i = 0; i <= 15; i++)
			rooms[i] = loader.loadRoom("room" + i + ".txt");
		currentRoom = 0;
	}
	
	public Room moveToRoom(int direction) {
		int nextRoomId = rooms[currentRoom].getNextRoomId(direction);
		if(nextRoomId == Room.NO_ROOM) {
			System.out.println("You can't go to that direction!");
			return rooms[currentRoom];
		}
		if(rooms[nextRoomId].isLocked()) {
			System.out.println(rooms[nextRoomId].description + " is locked!");
			return rooms[currentRoom];
		}
		currentRoom = nextRoomId;
		return rooms[nextRoomId];
	}
	
	public Room getCurrentRoom() {
		return rooms[currentRoom];
	}
	
}
