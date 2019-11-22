/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;

import javax.swing.JPanel;

public class GameMap extends JPanel{
	
	MapGen map;
	
	public GameMap(String file) {
		map = new MapGen(file);

		//load tile images and path images
		map.addPictures();
		
		
		
		/*int rows = 10;
		int cols = 10;
		
		MyCanvas myCanvas = null; 
		myCanvas = new MyCanvas(rows, cols);

		//load tile images
		for (int x = 0; x< rows; x++)
			for (int y = 0; y < cols; y++)
				myCanvas.addPicture(x, y,"StoneWall.png");
		
		if (myCanvas != null){
			this.add(myCanvas);
		}
		this.setVisible(true);*/
	}
	
	public void paint(Graphics g) {
		map.drawImage(g);
	}
	
}
