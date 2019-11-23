/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;

import javax.swing.JPanel;

public class BackGroundGen extends JPanel{
	
	private MapGen bg;
	private int[] startPos;
	private int[] endPos;
	
	
	public BackGroundGen(String file) {
		//create bg
		bg = new MapGen(file);

		//load tile images and path images
		bg.addPictures();
		
		//find map start and end
		startPos = bg.getStart();
		endPos  = bg.getEnd();
	}
		
	
	public void paint(Graphics g) {
		//show back ground
		bg.paint(g);
		
	}
	
	public int[] getStartPos() {
		return startPos;
	}
	
	public int[] getEndPost() {
		return endPos;
	}
	
}
