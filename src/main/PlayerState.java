package main;

import items.*;

public class PlayerState {
	private Item[] inventory = new Item[10];
	private int health;
	private String name;
	private int amount; //Keeps track of the first most location to add an item
	
	public void addToInventory(Item i) {
		inventory[amount] = i;
		amount++;
	}
	
	public void removeFromInventory(Item i) {
		for(int index=0; index < inventory.length; index++) {
			if(inventory[index] == i) {
				for(int j = index; j < inventory.length; j++){
					inventory[j] = inventory[j+1];
				}
				amount--;
			}
		}
	}
	
	public boolean isInInventory(Item i) {
		for(int index=0; index < inventory.length; index++) {
			if(inventory[index] == i)
				return true;
		}
		return false;
	}
	
	public String getInventory() {
		return "";
	}
	
	public void eat(Edible food) {
		if(isInInventory(food)) {
			int increase = food.getHeatlhValue();
			increaseHealth(increase);
			//action feedback
			System.out.println("Ate: "+food.getName()+". Increased health!");
		}
		else {
			//return 'couldn't eat. not in inventory.'		
			System.out.println(""+food.getName()+" not in inventory!");
		}
	}
	
	public void eat(String s) {
		Edible e;
		switch(s) {
			case "apple":
				e = new Apple();
				break;
			case "cake":
				e = new Apple();
				break;
			default:
				e = new Apple();
				break;
			
		}
		eat(e);
	}
	
	public void increaseHealth(int num) {
		health = health + num;
	}
	
	public void decreaseHealth(int num) {
		health = health - num;
		if(health < 1)
			health = 0;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
}