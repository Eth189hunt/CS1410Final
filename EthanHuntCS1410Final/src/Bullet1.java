//stationary object to add to our window

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class Bullet1 
{
	private int vx;
	private int vy;
	private int startx;
	private int starty;

	public Bullet1(int startx, int starty, int vx, int vy)
	{
		this.startx = startx;
		this.starty = starty;
		this.vx=vx;
		this.vy=vy;
	}
	
			
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		//because we added the bullet functions what should go here?
		g.setColor(Color.BLACK);
		g.fillOval(startx+=vx, starty+=vy, 20,20);
		//vx+=vx;
		//vy+=vy;
	}
	

	
}