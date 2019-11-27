/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public abstract class Path {
	
	protected int prex;
	protected int prey;
	protected int x;
	protected int y;
	protected String type;
	protected boolean reverse;
	
	public Path() {
		this(0, 0, 0, 0, false, "E.png");
	}
	
	public Path(int prex, int prey, int x, int y, boolean reverse, String type) {
		this.prex = prex;
		this.prey = prey;
		this.x = x;
		this.y = y;
		this.reverse = reverse;
		this.type = type;
	}
	
	
	public int getPrex() {
		return prex;
	}
	
	public int getPrey() {
		return prey;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void printPath() {
		System.out.printf("prex %s, prey %s, x %s, y %s, type %s%n", prex, prey, x, y, type);
	}
	
	//want each to move proper way in path
	abstract public int[] move(int current);
	
	abstract public int[] start();
	
}
