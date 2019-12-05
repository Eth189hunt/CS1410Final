
public class Strength extends Upgrade {
	
	private int strIncrease;
	
	public Strength(String name, String desc, int cost, int strIncrease) {
		super(name, desc, cost);
		this.strIncrease = strIncrease;
	}

	public void change(Tower t) {
		//apply change to tower
		t.addStrength(strIncrease);
	}

}
