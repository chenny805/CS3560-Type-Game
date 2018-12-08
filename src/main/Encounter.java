package main;
import java.util.*;

import items.Apple;

public class Encounter {
	
		GameState gs = GameState.getInstance();
	
		private static final int NUM_GAMES = 4;
		private int game;

		public Encounter() {
			Random rng = new Random();
			game = rng.nextInt(NUM_GAMES);
		}
		
		public Encounter(int select) {
			game = select; 
		}
		
		public void run() {
			switch(game) {
			case 0:
				game0();
				break;
			case 1:
				game1();
				break;
			case 2:
				game2();
				break;
			case 3:
				game3();
				break;
			default:
				System.out.println("no game exists");
			}
		}
		
		private void game0() {
			gs.tm.talk(gs.tm.getTextFromFile("encounter0"));
			Scanner kb = new Scanner(System.in);
			while(kb.nextLine().toLowerCase() != "return") {}
		}
		
		private void game1() {
			try { 
				long limit = 15000L;
				long startTime;
				String str;
				
				gs.tm.talk("------------------------------------\n\tPassage Minigame");
		        gs.tm.talk("Rules:");
		        gs.tm.talk("    Copy the following passage as"
		        		+ "\n    fast as you can within 15"
		        		+ "\n    seconds."
		        		+ "\nWin:"
		        		+ "\n    Earn 25 health"
		        		+ "\nLose:"
		        		+ "\n    Lose 25 health");
		        gs.tm.talk("\nType \"ready\" to begin.\n");
		        gs.tm.talk("------------------------------------");
		        str = TextManager.getInput();
		        while(!str.equals("ready")) {
		        	str = TextManager.getInput();
		        }
		        gs.tm.talk("Copy The Following:\n");
		        
		        gs.tm.talk("Enemy: A person who is actively opposed or hostile to someone or something.");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("Enemy: A person who is actively opposed or hostile to someone or something.")) {
		    		gs.tm.talk("\nYOU SUCCEEDED!\nYou earned 25 health.\n");
		    		gs.ps.increaseHealth(25);
		    	} else {
		    		gs.tm.talk("\nYOU FAILED!\nYou lost 25 health.\n");
		    		gs.ps.decreaseHealth(25);
		    	}
		        gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory());
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		private void game2() {
			try {
				long limit = 5000L;
				long startTime;
				int score = 0;
				String str;
				
				gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
				gs.tm.talk("------------------------------------\n\tCopy Words Minigame");
				gs.tm.talk("Rules:");
				gs.tm.talk("    Copy each word as they appear"
						+ "\n    within 5 seconds. You get 1 "
						+ "\n    point for copying the word in"
						+ "\n    the allotted time. Earn 3"
						+ "\n    points. Your score will appear"
						+ "\n    in the top right area."
						+ "\nWin:"
						+ "\n    Earn 40 health "
						+ "\nLose:"
						+ "\n    Lose 40 health");
				gs.tm.talk("\nType \"ready\" to begin.\n");
		        gs.tm.talk("------------------------------------");
		        str = TextManager.getInput();
		        while(!str.equals("ready")) {
		        	str = TextManager.getInput();
		        }
		        
		        gs.tm.talk("game\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("game")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		        }
		        Thread.sleep(2000);
		        
		        gs.tm.talk("adventure\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("adventure")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		    	}
		        Thread.sleep(2000);
		        
		        gs.tm.talk("enemy\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("enemy")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		    	}
		        Thread.sleep(2000);
		        
		        gs.tm.talk("fantasy\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("fantasy")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		    	}
		        Thread.sleep(2000);
		        
		        gs.tm.talk("shield\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("shield")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		    	}
		        Thread.sleep(2000);
		        
		        gs.tm.talk("strength\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("strength")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		    	}
		        Thread.sleep(2000);
		        
		        gs.tm.talk("strike\n");
		        startTime = System.currentTimeMillis();
		        str = TextManager.getInput();
		        
		        if ((startTime + limit) > System.currentTimeMillis() && str.equals("strike")) {
		        	score += 1;
		        	gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
		    	}
		        Thread.sleep(2000);
		        
		        if(score >= 3) {
		        	gs.tm.talk("YOU WON!\nYou earned 40 health\n");
		        	gs.ps.increaseHealth(40);
		        } else { 
		        	gs.tm.talk("YOU FAILED!\nYou lost 40 health\n");
		        	gs.ps.decreaseHealth(40);
		        }
		        gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory());
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		private void game3() {
			try { 
				int score = 0;
				String str;
				
				gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
				gs.tm.talk("------------------------------------\n\tMemorization Minigame");
		        gs.tm.talk("Rules:");
		        gs.tm.talk("    A list of words will appear."
		        		+ "\n    Remember as many words as you"
		        		+ "\n    can. You will have 12 seconds."
		        		+ "\n    Correctly type 5 words to win."
		        		+ "\n    Type \"end\" when you are done"
		        		+ "\n    guessing."
		        		+ "\nWin:"
		        		+ "\n    Earn 30 health"
		        		+ "\nLose:"
		        		+ "\n    Lose 30 health.");
		        gs.tm.talk("\nType \"ready\" to begin.\n");
		        gs.tm.talk("------------------------------------");
		        str = TextManager.getInput();
		        while(!str.equals("ready")) {
		        	str = TextManager.getInput();
		        }
		        
		        gs.tm.talk("\nenemy\nwarrior\nbattle\nhero\nattack\ndamage\nfly\nhealth\nkey\ndefend\n");
		        Thread.sleep(12000);
		        gs.tm.talk("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBegin:");
		        gs.tm.ui.output_scroll.setWheelScrollingEnabled(false);
		        str = TextManager.getInput();
		        
		        String[] list = {"enemy", "warrior", "battle", "hero", "attack", "damage", "fly", "health", "key", "defend"};
		        while(!str.equals("end")) {
			        if (inList(str, list)) {
			    		score++;
			    		gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory() + "\n\nScore: " + score);
			    	}
			        if(score < 10)
			        	str = TextManager.getInput();
			        else
			        	str = "end";
		        }
		        if(score >= 5) {
		        	gs.tm.talk("YOU WON!\nYou earned 30 health\n");
		        	gs.ps.increaseHealth(30);
		        } else { 
		        	gs.tm.talk("YOU FAILED!\nYou lost 30 health\n");
		        	gs.ps.decreaseHealth(30);
		        }
		        gs.tm.ui.output_scroll.setWheelScrollingEnabled(true);
		        gs.tm.ui.stat_info.setText("Player Health: " + gs.ps.getHealth() + "\n\nInventory: " + gs.ps.getInventory());
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		private boolean inList(String str, String[] list) {
			for(int i=0; i<10; i++) {
				if(str.equals(list[i])) {
					list[i] = "";
					return true;
				}
			}
			return false;
		}

}
