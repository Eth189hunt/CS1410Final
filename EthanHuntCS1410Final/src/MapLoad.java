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
import javax.swing.JPanel;

public class MapLoad extends JPanel{
	
	private MapGen bg;
	//private int[] startPos;
	private int[] endPos;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private boolean movement;
	private Path[] path;
	
	public MapLoad(String file) {
		//create bg
		bg = new MapGen(file);

		//load tile images and path images
		bg.addPictures();
		
		//find map start and end
		//startPos = bg.getStart();
		endPos  = bg.getEnd();
		
		int startPos[] = bg.getStart();
		path = bg.getPathObjects();
		try{
			BufferedImage im = ImageIO.read(new File("testpng.png"));
			Enemy hi = new Enemy(startPos[0],startPos[1], im, 100, 1); 
			enemies.add(hi);
		}
		catch(Exception E) {
			System.out.println(E);
		}
		
	}
		
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//show back ground
		bg.paint(g);
		
		//print
		if(enemies.size() != 0) {
			enemies.get(0).moveImage(g, path);
		}
		
		//check that lives is good
		
		try {
			Thread.sleep(50);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		repaint();
		
	}
	
	/*public int[] getStartPos() {
		return startPos;
	}*/
	
	public int[] getEndPost() {
		return endPos;
	}
	
	public Path[] getPath() {
		return bg.getPathObjects();
	}
}
