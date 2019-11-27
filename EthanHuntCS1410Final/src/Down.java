/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Down extends Path {
	
	public Down() {
		super();
	}
	
	public Down(int prex, int prey, int x, int y, boolean reverse, String type) {
		super(prex, prey, x, y, reverse, type);
	}
	
	public int[] move(int current) {
		int[] answer = new int[2];
		
		//go down
		if(!reverse) {
			answer[1] = 1;
		}
		//go up
		else {
			answer[1] = -1;
		}
		
		return answer;
	}
	
	public int[] start() {
		int[] answer = new int[2];
		
		//start positions
		//normal
		if(!reverse) {
			answer[0] = (x * 50) + 44;
			answer[1] = (y * 50) - 38;
		}
		//reversed
		else {
			answer[0] = (x * 50) + 44;
			answer[1] = ((y + 1) * 50);
		}
		
		return answer;
	}

}
