/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Velocity extends Upgrade {
	
	private int changexv;
	private int changeyv;
	
	
	public Velocity(String name, String desc, int cost, int changexv, int changeyv) {
		super(name, desc, cost);
		this.changexv = changexv;
		this.changeyv = changeyv;
	}

	public void change(Tower t) {
		//apply change with tower method
		t.addbulletSpeed(changexv, changeyv);
	}

}
