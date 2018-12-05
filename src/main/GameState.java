package main;

import rooms.*;

//singleton
public class GameState {

	private static final GameState INSTANCE = new GameState();
	public TextManager tm = new TextManager();
	public PlayerState ps = new PlayerState();
	public GameMap gm = new GameMap();
	
    private GameState() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
        else {
        	tm.ui.room_info.setText(gm.current_room.getDescription());
        }
        
    }

    public static GameState getInstance() {
        return INSTANCE;
    }
    
}