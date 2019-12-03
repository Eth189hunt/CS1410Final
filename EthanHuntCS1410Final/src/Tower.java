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
	private int bullx;
	private int bully;
	private int bullW;
	private int bullH;
	private int bullxv;
	private int bullyv;
	private int bulletDistance;
	
	public Tower(int posx, int posy, BufferedImage bi, int bullx, int bully, BufferedImage bullImage, int bullW, int bullH, int bullxv, int bullyv, int bulletDistance) {
		//need to be 50 by 50
		super(posx, posy, bi, 50, 50);
		this.bullImage = bullImage;
		this.bullW = bullW;
		this.bullH = bullH;
		this.bullxv = bullxv;
		this.bullyv = bullyv;
		this.bullx = bullx;
		this.bully = bully;
		this.bulletDistance = bulletDistance;
		
		//add one bullet so starts bullet move works correctly
		addBullet();
		
	}
	
	
	
	public void addBullet() {
		bullets.add(new Bullets(bullx, bully, bullImage, bullW, bullH, bullxv, bullyv));
	}
	
	public void removeBullets() {
		//remove all
		for(int v = 0; v < bullets.size(); v++) {
			bullets.remove(v);
		}
		
		//add one back
		addBullet();
	}
	
	public void drawImage(Graphics g){
		g.drawImage(bi,posx, posy,imageW,imageH,null);
	}
	
	public void bulletStatic(Graphics g) {
		//draw with no movement
		for(int v = 0; v < bullets.size(); v++) {
			bullets.get(v).drawImageStatic(g);
		}
	}
	
	public void bulletMoving(Graphics g) {
		//draw with movement
		for(int v = 0; v < bullets.size(); v++) {
			//draw image with move
			bullets.get(v).drawImage(g);
			
			//delete if out of jpanel
			if(bullets.get(v).getX() > 600 || bullets.get(v).getY() > 600 || bullets.get(v).getX() < 0 || bullets.get(v).getY() < 0) {
				bullets.remove(v);
			}
		}
		
		//add new one
		if(bullets.get(bullets.size() - 1).getX() > (bulletDistance) + bullx || bullets.get(bullets.size() - 1).getY() > (bulletDistance) + bully || bullets.get(bullets.size() - 1).getY() < bully - bulletDistance || bullets.get(bullets.size() - 1).getX() < bullx - bulletDistance) {
			addBullet();
		}
		
		//System.out.println(bullets.size());
		
	}
	
	public ArrayList<Bullets> getBullets(){
		return bullets;
	}
	
	public void deleteBullet(int i) {
		bullets.remove(i);
	}
	
	public boolean checkPosition() {
		boolean answer = false;
		
		
		
		return answer;		
	}
}
