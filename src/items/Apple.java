package items;

public class Apple implements Edible {
	@Override
	public int getHeatlhValue() {
		return 1;
	}

	@Override
	public String getDescription() {
		return "It's a juicy red apple, with spotty yellow patches."
				+ " It must have been grown in the southern orchards.";
	}

	@Override
	public String getName() {
		return "Apple";
	}
}
