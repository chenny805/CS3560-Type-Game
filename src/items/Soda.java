package items;

public class Soda implements Edible {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "An unopened bottle of soda. From the colorof it, it must be either coka cola or dr. pepper";
	}

	@Override
	public int getHeatlhValue() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Soda";
	}

}
