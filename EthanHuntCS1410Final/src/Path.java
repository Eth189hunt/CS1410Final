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
	
	public boolean inBounds(int xIn, int yIn) {
		boolean answer = false;
		
		//var bound
		int mx = 0;
		int my = 0;
		int nx = 0;
		int ny = 0;
		
		//set bounds
		mx = ((x + 1) * 50);
		my = ((y + 1) * 50);
		nx = (x * 50);
		ny = (y * 50);
		
		//check in bounds
		if((nx <= xIn & xIn <= mx)) {
			if(ny <= yIn & yIn <= my) {
				answer = true;
			}
			else {
				answer = false;
			}
		}
		
		return answer;
	}
	
	public void printPath() {
		System.out.printf("prex %s, prey %s, x %s, y %s, type %s%n", prex, prey, x, y, type);
	}
	
	//want each to move proper way in path
	abstract public int[] move(int current);
	
	abstract public int[] start();
	
}
