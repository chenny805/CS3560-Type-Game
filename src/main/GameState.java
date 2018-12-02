package main;

import gui.GameGUI;
import rooms.*;

//singleton
public class GameState {

	private static final GameState INSTANCE = new GameState();
	public TextManager tm = new TextManager();
	public PlayerState ps = new PlayerState();
	public Room current_room;
	//decision tree implementation
	//current node
	//NODE: 
	
	//****** NOTE ******/
	// The StartRoom class is not needed.
	// We have to replace line 25
    private GameState() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
        //else
        	//current_room = new StartRoom();
    }

    public static GameState getInstance() {
        return INSTANCE;
    }
    
    public void move(Room r) {
    	current_room = r;
    	tm.print(current_room.getDescription());
    }
}