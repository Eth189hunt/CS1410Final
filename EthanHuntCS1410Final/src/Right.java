/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Right extends Path {
	
	public Right() {
		super();
	}
	
	public Right(int prex, int prey, int x, int y, boolean reverse, String type) {
		super(prex, prey, x, y, reverse, type);
	}
	
	public int[] move(int current) {
		int[] answer = new int[2];
		
		//go right up
		if(!reverse) {
			//right
			if(current <= 21) {
				answer[0] = 2;
			}
			
			if(current > 21) {
				answer[1] = -2;
			}
		}
		//go down left
		else {
			//down
			if(current <= 21) {
				answer[1] = 2;
			}
			//left
			if(current > 21) {
				answer[0] = -2;
			}
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
			answer[0] = (x * 50) + 44;
			answer[1] = (y * 50) - 38;
		}
		
		return answer;
	}

}
