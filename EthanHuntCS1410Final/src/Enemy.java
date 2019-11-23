import java.awt.image.BufferedImage;

/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Enemy extends MovingObject{
	
	private int strength;
	
	public Enemy(int posx, int posy, BufferedImage bi, int vx, int vy, int strength) {
		super(posx, posy, bi, 38, 38, vx, vy);
		this.strength = strength;
	}
	
	

}
