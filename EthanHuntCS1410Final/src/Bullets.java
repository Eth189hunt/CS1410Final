/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullets extends MovingObject {
	
	
	
	public Bullets(int posx, int posy, BufferedImage bi, int imageW, int imageH, int vx, int vy) {
		super(posx, posy, bi, imageW, imageH, vx, vy);
		
	}
	
	//for freeze
	public void drawImageStatic(Graphics g) {
		g.drawImage(bi, posx, posy, imageW, imageH, null);
	}
	
	public int getImageH() {
		return imageH;
	}
	
	public int getImageW() {
		return imageW;
	}
	
	//x and y in image
	public boolean bounds() {
		boolean answer = false;
		
		return answer;
	}

}
