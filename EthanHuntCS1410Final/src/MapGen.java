/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapGen extends JPanel{
	
	//vars
	private BufferedImage[][] bgImgs;
	private int col;
	private int row;
	private int tileSize;
	private String image;
	
	private BufferedImage[][] pathImgs;
	private int pathSize;
	private int colPath;
	private int rowPath;
	
	public MapGen(String file) {
		super();
		//error try catch
		try {
			//map scranner
			Scanner mapFile = new Scanner(new File(file));
			
			//get background
			image = mapFile.next() + ".png";
			
			//get tileSize
			tileSize = mapFile.nextInt();
			
			//get col
			col = mapFile.nextInt();
			
			//get row
			row = mapFile.nextInt();
			
			//bgImgs
			bgImgs = new BufferedImage[col][row];
			
			//get pathSize
			tileSize = mapFile.nextInt();
			
			//get pathcol
			colPath = mapFile.nextInt();
			
			//get pathrow
			rowPath = mapFile.nextInt();
			
			//pathImgs
			pathImgs = new BufferedImage[col][row];
			
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("The file " + file + " couldn't be found");
		}
	}
	
	public void addPictures() {
		for (int y = 0; y < row; y++){
			for (int x = 0; x < col; x++){
				addPicture(x, y, bgImgs);
			}
		}
		
		for (int y = 0; y < rowPath; y++){
			for (int x = 0; x < colPath; x++){
				addPicture(x, y, pathImgs);
			}
		}
	}
	
	public void addPicture(int x, int y, BufferedImage[][] imgs){
		if (x < 0 || x >= col){
			System.err.println("There is no col " + x);
		}
		else if (y < 0 || y >= row){
			System.err.println("There is no row " + y);
		}
		else{
				try {
					imgs[x][y] = ImageIO.read(new File(image));
				} catch (IOException e) {
					System.err.println("Unable to read the file: " + image);
				}
		}
	}
	
	public void drawImage(Graphics g){
		for (int y = 0; y < row; y++){
			for (int x = 0; x < col; x++){
				g.drawImage(bgImgs[x][y], x*tileSize, y*tileSize, tileSize, tileSize, null);
			}
		}
		
		for (int y = 0; y < row; y++){
			for (int x = 0; x < col; x++){
				g.drawImage(pathImgs[x][y], x*pathSize, y*pathSize, pathSize, pathSize, null);
			}
		}
		
	}
	
	public int getCol() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
	
}