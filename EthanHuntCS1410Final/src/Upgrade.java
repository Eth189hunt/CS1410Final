/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/



abstract public class Upgrade {
	
	private String name;
	private String desc;
	private int cost;
	
	
	public Upgrade(String name, String desc, int cost) {
		this.name = name;
		this.desc = desc;
		this.cost = cost;
	}
	
	abstract public void change(Tower t);
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getCost() {
		return cost;
	}
}
