/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/
//stationary object to add to our window

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class MovingObject extends StationaryObject
{
//Create instants variables to hold the needed velocities
	
	protected int vx;
	protected int vy;

	public MovingObject(int posx, int posy, BufferedImage bi, int imageW, int imageH, int vx, int vy)
	{
		//call the super constructor and then set the velocities
		super(posx, posy, bi, imageW, imageH);
		this.vx = vx;
		this.vy = vy;
	}
	
			
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		//increase position with vx and vy
		g.drawImage(bi, posx+=vx, posy+=vy, imageW, imageH, null);
		
	}
	
	public int getX() {
		return posx;
	}
	
	public int getY() {
		return posy;
	}
	

	
}