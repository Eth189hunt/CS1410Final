import java.awt.Graphics;
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
	
	public void drawImage(Graphics g){
		//draws the image but with corner to right side 
		g.drawImage(bi, posx - imageW, posy, imageW, imageH, null);
	}
	
	public void moveImage(Graphics g, String[] path) {
		
	}

}
