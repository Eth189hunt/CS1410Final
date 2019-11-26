/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Straight extends Path {

	public Straight() {
		super();
	}
	
	public Straight(int prex, int prey, int x, int y, boolean reverse, String type) {
		super(prex, prey, x, y, reverse, type);
	}

	public int[] move(int current) {
		int[] answer = new int[2];
		
		//go right
		if(!reverse) {
			answer[0] = 2;
		}
		//go left for reverse
		else {
			answer[0] = -2;
		}
		
		return answer;
	}
	
	public int[] start() {
		int[] answer = new int[2];
		
		//stat positions
		//normal
		if(!reverse) {
			answer[0] = x * 50;
			answer[1] = (y * 50) + 6;
		}
		//reversed
		else {
			answer[0] = ((x + 1) * 50) + 38;
			answer[1] = (y * 50) + 6;
		}
		
		return answer;
	}

}
