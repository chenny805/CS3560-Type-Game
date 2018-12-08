package items;

public class Knife implements Weapon{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A rusty knife with a dull blade. It looks like some traveler has "
				+ "abandoned it.";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Knife";
	}

}
