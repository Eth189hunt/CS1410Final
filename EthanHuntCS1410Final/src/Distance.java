/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Distance extends Upgrade {
	
	private int changeBullDistance;
	
	public Distance(String name, String desc, int cost, int changeBullDistance) {
		super(name, desc, cost);
		this.changeBullDistance = changeBullDistance;
		
	}

	public void change(Tower t) {
		//apply change with tower method
		t.addDistance(changeBullDistance);
	}

}
