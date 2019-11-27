import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

public class Enemy{
	
	private int health;
	private int strength;
	private int pathPos;
	private int pathDistance;
	private int moveSpeed;
	private int posx; 
	private int posy;
	private BufferedImage bi; 
	private int imageW;
	private int imageH;
	private Path[] path;
	
	public Enemy(int posx, int posy, BufferedImage bi, int health, int strength, Path[] path) {
		//super(posx, posy, bi, 38, 38, 2, 2);
		this.posx = posx;
		this.posy = posy; 
		this.bi= bi;
		this.imageW = 38; 
		this.imageH = 38;
		this.health = health;
		this.strength = strength;
		this.pathPos = -1;
		this.pathDistance = 0;
		this.moveSpeed = 2;
		this.path = path;
	}
	
	public void drawImage(Graphics g, int xDir, int yDir){
		//draws the image but with corner to right side 
		g.drawImage(bi, xDir - 38, yDir, imageW, imageH, null);
		//System.out.println(posx + " " + posy);
	}
	
	public void startPos() {
		int start[] = new int[2];
		
		//get start
		start = path[0].start();
		
		//assign start x and y
		posx = start[0];
		posy = start[1];
	}
	
	public void moveImage(Graphics g) {
		//vars
		int move[] = new int[2];
		int start[] = new int[2];
		
		//change position of enemy on path
		if(pathDistance == 0) {
			pathPos++;
		}
		
		//only if not over max
		if(pathPos < path.length) {
			//get move var, the var change which way x and y go
			move = path[pathPos].move(pathDistance);
			
			//get current position of path array the corner is moved to top right, change move direction
			posx+=(moveSpeed * move[0]);
			posy+=(moveSpeed * move[1]);
			drawImage(g, posx, posy);
			
			//System.out.println(posx + " " + posy);
			
			//increase path distance reset after 25
			pathDistance++;
			if(pathDistance >= 25) {
				pathDistance = 0;
			}
		}
	}
	
	public int getPathPos() {
		return pathPos;
	}
	
	public void setX(int posx) {
		this.posx+=posx;
	}
	
	public int getX() {
		return posx;
	}
	
	public int getY() {
		return posy;
	}
	

}
