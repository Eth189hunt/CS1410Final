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
	private String[][] pathFiles;
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
			pathSize = mapFile.nextInt();
			
			//get pathcol
			colPath = mapFile.nextInt();
			
			//get pathrow
			rowPath = mapFile.nextInt();
			
			//pathImgs
			pathImgs = new BufferedImage[colPath][rowPath];
			
			//int pathfiles
			pathFiles = new String[colPath][rowPath];
			
			//set pathfiles from map
			for (int y = 0; y < rowPath; y++){
				for (int x = 0; x < colPath; x++){
					pathFiles[x][y] = mapFile.next() + ".png";
				}
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println("The file " + file + " couldn't be found");
		}
	}
	
	public void addPictures() {
		for (int y = 0; y < row; y++){
			for (int x = 0; x < col; x++){
				addPicture(x, y);
			}
		}
		
		for(int y = 0; y < rowPath; y++) {
			for(int x = 0; x < colPath; x++) {
				addPath(x, y, pathFiles[x][y]);
			}
		}
	}
	
	public void addPicture(int x, int y){
		if (x < 0 || x >= col){
			System.err.println("There is no col " + x);
		}
		else if (y < 0 || y >= row){
			System.err.println("There is no row " + y);
		}
		else{
				try {
					bgImgs[x][y] = ImageIO.read(new File(image));
				} catch (IOException e) {
					System.err.println("Unable to read the file: " + image);
				}
		}
	}
	
	public void addPath(int x, int y, String image) {
		if (x < 0 || x >= colPath){
			System.err.println("There is no colPath " + x);
		}
		else if (y < 0 || y >= rowPath){
			System.err.println("There is no rowPath " + y);
		}
		else{
				try {
					pathImgs[x][y] = ImageIO.read(new File(image));
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
		
		for (int y = 0; y < rowPath; y++){
			for (int x = 0; x < colPath; x++){
				g.drawImage(pathImgs[x][y], x*pathSize, y*pathSize, pathSize, pathSize, null);
			}
		}
		
	}
	
	public void paint(Graphics g) {
		drawImage(g);
	}
	
	public int getCol() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int[] getStart() {
		//array for x and y value
		int[] answer = new int[2];
		
		//first col for straight
		for(int y = 0; y < rowPath; y++) {
			if(pathFiles[0][y].equals("S.png")) {
				answer[0] = 0;
				answer[1] = y;
				break;
			}
		}
		
		return answer;
	}
	
	public int[] getEnd() {
		//array for x and y value
		int[] answer = new int[2];
		
		//top row for down
		for(int x = 0; x < colPath; x++) {
			if(pathFiles[x][0].equals("D.png")) {
				answer[0] = x;
				answer[1] = 0;
				break;
			}
		}
		
		//bottow row for down if answer is not already set
		if(answer != null) {
			for(int x = 0; x < colPath; x++) {
				if(pathFiles[x][(rowPath - 1)].equals("D.png")) {
					answer[0] = x;
					answer[1] = (rowPath - 1);
					break;
				}
			}
		}
		
		//right col for straight if answer is not already set
				if(answer != null) {
					for(int y = 0; y < rowPath; y++) {
						if(pathFiles[(colPath - 1)][y].equals("S.png")) {
							answer[0] = (colPath - 1);
							answer[1] = y;
							break;
						}
					}
				}
		
		return answer;
	}
	
}