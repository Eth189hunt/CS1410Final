/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/
//stationary object to add to our window

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class StationaryObject
{
	protected int posx; 
	protected int posy;
	protected BufferedImage bi; 
	protected int imageW;
	protected int imageH;

	StationaryObject(int posx, int posy, BufferedImage bi, int imageW, int imageH)
	{
		this.posx = posx;
		this.posy = posy; 
		this.bi= bi;
		this.imageW = imageW; 
		this.imageH = imageH;
	}
	
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
	}
	
	
}