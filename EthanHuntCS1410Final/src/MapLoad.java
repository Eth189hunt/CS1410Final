/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
@SuppressWarnings("serial")

public class MapLoad extends JPanel{
	
	private MapGen bg;
	private int[] startPos;
	private int[] endPos;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Enemy enemies2[] = new Enemy[2];
	private int movement;
	private int enemiesPrint;
	private Enemy e1;
	private Enemy e2;
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
		super.paint(g);
		
		//go if lives good
		if(live > 0) {
			//show back ground
			bg.paint(g);
			
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
				break;
				case 2:
					//have enemies paused
					for(int v = 0; v < enemies.size(); v++) {
						if((v - 1) == -1 || enemies.get(v - 1).getPathPos() > 0) {
							enemies.get(v).drawImageStatic(g);
						}
					}
				break;
				default:
					//not printing enemies
				break;
				
			}
		}
		//make it disappear
		else {
			this.setVisible(false);
		}
		
		try {
			Thread.sleep(5);
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
	
	public void loadEnemies() {
		//add enemies to array list depending on round
		try {
			//enemy stats
			int enemyHealths[] = {1, 2, 3, 4, 5, 6, 7, 10, 12, 16};
			int enemyStrength[] = {1, 1, 1, 1, 1, 1, 1, 2, 2, 4};
			
			//add type 1 enemies
			for(int x = 0; x < (round * 20); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy1.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[0], enemyStrength[0], path));
			}
			
			//add type 2 enemies
			for(int x = 0; x < ((round - 2) * 10); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy2.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[1], enemyStrength[1], path));
			}
			
			//add type 3 enemies
			for(int x = 0; x < ((round - 4) * 5); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy3.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[2], enemyStrength[2], path));
			}
			
			//add type 4 enemies
			for(int x = 0; x < ((round - 6) * 4); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy4.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[3], enemyStrength[3], path));
			}
			
			//add type 5 enemies
			for(int x = 0; x < ((round - 7) * 4); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy5.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[4], enemyStrength[4], path));
			}
			
			//add type 6 enemies
			for(int x = 0; x < ((round - 8) * 4); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy6.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[5], enemyStrength[5], path));
			}
			
			//add type 7 enemies
			for(int x = 0; x < ((round - 9) * 3); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy7.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[6], enemyStrength[6], path));
			}
			
			//add type 8 enemies
			for(int x = 0; x < ((round - 10) * 2); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy8.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[7], enemyStrength[7], path));
			}
			
			//add type 9 enemies
			for(int x = 0; x < ((round - 11) * 2); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy9.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[8], enemyStrength[8], path));
			}
			
			//add type 10 enemies
			for(int x = 0; x < ((round - 12) * 1); x++) {
				//load image
				BufferedImage image = ImageIO.read(new File("enemy10.png"));
				//add enemy
				enemies.add(new Enemy(startPos[0],startPos[1], image, enemyHealths[9], enemyStrength[9], path));
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
	
}
