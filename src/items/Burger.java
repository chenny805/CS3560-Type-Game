package items;

public class Burger implements Edible {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "It's a giant hamburger, still warm and it looks delicious!";
	}

	@Override
	public int getHeatlhValue() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Burger";
	}

}
