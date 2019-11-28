/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tower extends StationaryObject {
	
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private BufferedImage bullImage;
	private int bullW;
	private int bullH;
	private int bullxv;
	private int bullyv;
	private int cost;
	
	public Tower(int posx, int posy, BufferedImage bi, BufferedImage bullImage, int bullW, int bullH, int bullxv, int bullyv) {
		//need to be 50 by 50
		super(posx, posy, bi, 50, 50);
		this.bullImage = bullImage;
		this.bullW = bullW;
		this.bullH = bullH;
		this.bullxv = bullxv;
		this.bullyv = bullyv;
	}
	
	
	
	public void addBullet() {
		bullets.add(new Bullets(posx, posy, bullImage, bullW, bullH, bullxv, bullyv));
	}
	
	//paint in center
	public void drawImage(Graphics g){
		g.drawImage(bi,posx - 25, posy - 25,imageW,imageH,null);
	}
}
