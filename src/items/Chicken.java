package items;

public class Chicken implements Edible {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Delicious looking piece of chicken. Heat is radiating off of it, must have been freshly made.";
	}

	@Override
	public int getHeatlhValue() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Chicken";
	}

}
