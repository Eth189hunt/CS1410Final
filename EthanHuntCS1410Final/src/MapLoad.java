/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
@SuppressWarnings("serial")

public class MapLoad extends JPanel{
	
	private MapGen bg;
	private int[] startPos;
	private int[] endPos;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private int movement;
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private Path[] path;
	private Enemy[] enemyType;
	private int live;
	private int money;
	private int round;
	
	
	public MapLoad(int mode, String file) {
		//create bg
		bg = new MapGen(file);

		//load tile images and path images
		bg.addPictures();
		
		//find map start and end
		startPos = bg.getStart();
		endPos  = bg.getEnd();
		
		//get path objects
		path = bg.getPath();
		
		//start lives 100 easy 50 hard
		live = 100 / mode;
		
		//start money 100 easy 50 hard
		money = 100 /  mode;
		
	}
		
	
	public void paint(Graphics g) {
		//super.paint(g);
		
		//go if lives good
		if(live > 0) {
			//show back ground
			bg.paint(g);
			
			//towers
			for(int v = 0; v < towers.size(); v++) {
				towers.get(v).drawImage(g);
			}
			
			//start enemies if movement enabled
			switch(movement) {
				case 1:
					//have enemies moving
					for(int v = 0; v < enemies.size(); v++) {
						if((v - 1) == -1 || enemies.get(v - 1).getPathPos() > 0) {
							//move enemies with boolean return
							if(enemies.get(v).moveImage(g)) {
								//not at end yet
							}else {
								//at end so reduce live
								live--;
								
								//also need to delete this one
								enemies.remove(v);
							}
						}
					}
					
					//have bullets moving
					for(int v = 0; v < towers.size(); v++) {
						towers.get(v).bulletMoving(g);
					}
					
					//bullets and enemy collision
					int tempe = enemies.size();
					for(int e = 0; e < enemies.size(); e++) {
						//
						for(int t = 0; t < towers.size(); t++) {
							//
							for(int b = 0; b < towers.get(t).getBullets().size(); b++) {
								//check each x and y in bullet size
								for(int x = 0; x < towers.get(t).getBullets().get(b).getImageW(); x++) {
									for(int y = 0; y < towers.get(t).getBullets().get(b).getImageH(); y++) {
										//increase from bullets current x and y
										int tempx = x + towers.get(t).getBullets().get(b).getX();
										int tempy = y + towers.get(t).getBullets().get(b).getY();
										if(enemies.size() == tempe && enemies.size() != 0 && enemies.get(e).inBound(tempx, tempy)) {
											//bye enemy
											deleteEnemy(e);
										}
									}	
								}
							}
							
						}
					}
					
				break;
				case 2:
					//have enemies paused
					for(int v = 0; v < enemies.size(); v++) {
						if((v - 1) == -1 || enemies.get(v - 1).getPathPos() > 0) {
							enemies.get(v).drawImageStatic(g);
						}
					}
					
					//have bullets paused
					for(int v = 0; v < towers.size(); v++) {
						towers.get(v).bulletStatic(g);
					}
				break;
				default:
					//not printing enemies
					
					//remove bullets
					for(int v = 0; v  < towers.size(); v++) {
						towers.get(v).removeBullets();
					}
				break;
				
			}
			
			
		}
		//make it disappear
		else {
			this.setVisible(false);
		}
		
		try {
			Thread.sleep(35);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		repaint();
		
	}
	
	public void start() {
		//increase round
		round++;
		
		//increase money depending round
		money+=((round - 1) * 50);
		
		//create enemies
		loadEnemies();
		
		//enable movement
		movement = 1;
	}
	
	public void pause() {
		//pause movement
		movement = 2;
	}
	
	public void unpause() {
		//unpause movement so set to 1
		movement = 1;
	}
	
	public void end() {
		//stop movement
		movement = 0;
	}
	
	public void deleteEnemy(int i) {
		//increase money
		money+=enemies.get(i).getMoney();
		
		//remove enemy
		enemies.remove(i);
	}
	
	public void createTower(int posx, int posy, String value, String towerImage[], int towerCost[]) {
		
		int valueI = Integer.parseInt(value);
		
		//var to create the tower types
		String bulletImage[] = {"bullet0.png", "bullet1.png", "bullet2.png", "bullet0.png", "bullet1.png", "bullet2r.png"};
		
		//vars for bullets
		int bulletWH[][] = {{25, 25}, {25, 25}, {50, 50}, {25, 25}, {25, 25}, {50, 50}};
		int bulletXY[][] = {{25, 5}, {14, 2}, {7, 20}, {0, 5}, {14, 30}, {7, 7}};
		int moveDir[][] = {{2, 0}, {0, -1}, {-4, -4}, {-2, 0}, {0, 1}, {-4, 4}};
		int spaceBetween[] = {50, 100, 80, 50, 100, 80};
		
		//var for upgrade
		Upgrade towerUpgrades[] = new Upgrade[4];
		towerUpgrades[0] = new Distance("hi", "increase distance", 20, 10);
		towerUpgrades[1] = new Distance("hi2", "decrease distance", 20, -10);
		towerUpgrades[2] = new Velocity("hi3", "increase v", 20, 1, 0);
		towerUpgrades[3] = new Velocity("hi4", "decrease v", 20, -1, 0);
		
		
		//move to x and y to the tile it is in
		posx = posx - (posx % 50);
		posy = posy - (posy % 50);
		
		//check that not already one there
		if(checkTower(posx, posy)) {
			try {
				//load tower image
				BufferedImage ti = ImageIO.read(new File(towerImage[valueI]));
				
				//load bullet image
				BufferedImage bi = ImageIO.read(new File(bulletImage[valueI]));
				
				//check cost
				if(money >= towerCost[valueI]) {
					//create tower
					towers.add(new Tower(posx, posy, ti, (posx + bulletXY[valueI][0]), posy + (bulletXY[valueI][1]), bi, bulletWH[valueI][0], bulletWH[valueI][1], moveDir[valueI][0], moveDir[valueI][1], spaceBetween[valueI], towerUpgrades));
					
					//upgrades for tower
					
					//subtract money
					money-=towerCost[valueI];
				}else {
					//error not enought money
					System.out.println("Not enough money");
				}
				
				
			}
			catch(IOException E) {
				System.err.println(E);
			}
		}else {
			System.out.println("Already a tower there");
		}
		
	}
	
	public boolean checkTower(int xIn, int yIn) {
		boolean answer = true;
		
		//check that 
		for(int i = 0; i < towers.size(); i++) {
			//check if new x and y match this tower x and y
			if(xIn == towers.get(i).getX() && yIn == towers.get(i).getY()) {
				//bad to place
				answer = false;
				
				break;
			}
		}
		
		return answer;
	}
	
	public Tower getTower(int xIn, int yIn) {
		for(int i = 0; i < towers.size(); i++) {
			//check for tower at x and y
			if(xIn == towers.get(i).getX() && yIn == towers.get(i).getY()) {
				//return tower
				return towers.get(i);
			}
		}
		return null;
	}
	
	public int getTowerSlot(int xIn, int yIn) {
		for(int i = 0; i < towers.size(); i++) {
			//check for tower at x and y
			if(xIn == towers.get(i).getX() && yIn == towers.get(i).getY()) {
				//return tower
				return i;
			}
		}
		return 0;
	}
	
	public void pathClick(int tSlot, int slot) {
		//new current position
		int newCurrent = (towers.get(tSlot).getCurrentUp(slot) + 2);
		
		//check that not blank
		if(towers.get(tSlot).checkUpgrade(slot)) {
			//upgrade is done
		}
		//normal upgrade
		else {
			//check money
			if(money >= towers.get(tSlot).getUpgradeCost(slot)) {
				//decrease money
				money-=towers.get(tSlot).getUpgradeCost(slot);
				
				Upgrade up = towers.get(tSlot).getUpgrades()[slot];
				
				//apply upgrade
				up.change(towers.get(tSlot));
				
				//check that newCurrent is not above upgrades
				if(newCurrent < towers.get(tSlot).getUpgradeSize()) {
					//upgrade to a new path
					towers.get(tSlot).setCurrentUp(slot, newCurrent);
				}else {
					//upgrade to null
					towers.get(tSlot).setUpgradeBlank(slot);
				}
			}else {
				System.out.println("Not enough money for upgrade");
			}
		}
		
	}
	
	public void loadEnemies() {
		//add enemies to array list depending on round
		try {
			//enemy stats
			int enemyHealths[] = {1, 2, 3, 4, 5, 6, 7, 10, 12, 16};
			int enemyStrength[] = {1, 1, 1, 1, 1, 1, 1, 2, 2, 4};
			
			//round start creating
			int roundStart[] = {0, 2, 4, 6, 7, 8, 9, 10, 11, 12};
			
			//round number created
			int roundNum[] = { 20, 10, 5, 4, 4, 4, 3, 2, 2, 1};
			
			//the ten types
			for(int i = 0; i < 10; i++) {
				//add type number depending on round
				for(int v = 0; v < ((round - roundStart[i]) * roundNum[i]); v++) {
					//load image
					BufferedImage image = ImageIO.read(new File("enemy" + (i + 1) + ".png"));
					
					//add enemy
					enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[i], enemyStrength[i], path));
				}
			}
			
			//set enemy start
			for(int v = 0; v < enemies.size(); v++) {
				enemies.get(v).startPos();
			}
		}
		catch(Exception E) {
			System.out.println(E);
		}
		
	}
	
	public int getEnemiesCount() {
		return enemies.size();
	}
	
	public int getLive() {
		return live;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getRound() {
		return round;
	}
	
	public String getTp(int xIn, int yIn) {
		String answer = "";
		
		for(int v = 0; v < path.length; v++) {
			if(path[v].inBounds(xIn, yIn)) {
				answer = "On Path";
				break;
			}else {
				answer = "x: " + (xIn - (xIn % 50)) + " y: " + (yIn - (yIn % 50));
			}
		}
		
		return answer;
	}
	
}
