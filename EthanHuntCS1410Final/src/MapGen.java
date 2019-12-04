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
			
			mapFile.close();
			
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
	
	public int countPath() {
		int answer = 1;
		int[] startPos = new int[2];
		int x = 0;
		int y = 0;
		int preX = 0;
		int preY = 0;
		boolean loop = true;
		
		//get startPos
		startPos = getStart();
		
		//set x and y
		x = startPos[0];
		y = startPos[1];
		
		//set prevX and prevY to on back of start so that it count backwards
		preX = startPos[0] - 1;
		preY = startPos[1];
		
		//get next path location
		while(loop) {
			switch(pathFiles[x][y]) {
				case "S.png":
					//check if should got forward or backward
					if(preX < x) {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x++;
						if(x < colPath) {
							//increase answer
							answer++;
						}
						else {
							x--;
							loop = false;
						}
					}
					else {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x--;
						if(x >= 0) {
							//increase answer
							answer++;
						}
						else {
							x++;
							loop = false;
						}
					}
				break;
				case "D.png":
					//check if should got forward or backward
					if(preY < y) {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y++;
						if(y < rowPath) {
							//increase answer
							answer++;
						}
						else {
							y--;
							loop = false;
						}
					}
					else {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y--;
						if(y >= 0) {
							//increase answer
							answer++;
						}
						else {
							y++;
							loop = false;
						}
					}
				break;
				case "L.png":
					//check if should got forward or backward
					if(preY != y) {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x++;
						if(x < colPath) {
							//increase answer
							answer++;
						}
						else {
							x--;
							loop = false;
						}
					}
					else {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y--;
						if(y >= 0) {
							//increase answer
							answer++;
						}
						else {
							y++;
							loop = false;
						}
					}
				break;
				case "R.png":
					//check if should got forward or backward
					if(preY != y) {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x--;
						if(x >= 0) {
							//increase answer
							answer++;
						}
						else {
							x++;
							loop = false;
						}
					}
					else {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y--;
						if(y < rowPath) {
							//increase answer
							answer++;
						}
						else {
							y++;
							loop = false;
						}
					}
				break;
				case "F.png":
					//check if should got forward or backward
					if(preY != y) {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x++;
						if(x < colPath) {
							//increase answer
							answer++;
						}
						else {
							x--;
							loop = false;
						}
					}
					else {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y++;
						if(y < rowPath) {
							//increase answer
							answer++;
						}
						else {
							y--;
							loop = false;
						}
					}
				break;
				case "T.png":
					//check if should got forward or backward
					if(preY != y) {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x--;
						if(x >= 0) {
							//increase answer
							answer++;
						}
						else {
							x++;
							loop = false;
						}
					}
					else {
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y++;
						if(y < rowPath) {
							//increase answer
							answer++;
						}
						else {
							y--;
							loop = false;
						}
					}
				break;
			}
		}
		
		return answer;
	}
		
	public Path[] getPath() {
		Path answer[] = new Path[countPath()];
		
		//vars
		int[] startPos = new int[2];
		int x = 0;
		int y = 0;
		int preX = 0;
		int preY = 0;
		boolean loop = true;
		int count = 0;
		
		//get startPos
		startPos = getStart();
		
		//set x and y
		x = startPos[0];
		y = startPos[1];
		
		//set prevX and prevY to on back of start so that it count backwards
		preX = startPos[0] - 1;
		preY = startPos[1];
		
		//start loop
		while(loop) {
			switch(pathFiles[x][y]) {
				case "S.png":
					//check if should got forward or backward
					if(preX < x) {
						//create path without reverse
						answer[count] = new Straight(preX, preY, x, y, false, pathFiles[x][y]);
						
						//set up for next path
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x++;
						if(x < colPath) {
							//increase count
							count++;
						}
						else {
							x--;
							loop = false;
						}
					}
					else {
						//create path with reverse
						answer[count] = new Straight(preX, preY, x, y, true, pathFiles[x][y]);
						
						//set up for next path
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x--;
						if(x >= 0) {
							//increase count
							count++;
						}
						else {
							x++;
							loop = false;
						}
					}
				break;
				case "D.png":
					//check if should got forward or backward
					if(preY < y) {
						//create path without reverse
						answer[count] = new Down(preX, preY, x, y, false, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y++;
						if(y < rowPath) {
							//increase count
							count++;
						}
						else {
							y--;
							loop = false;
						}
					}
					else {
						//create path with reverse
						answer[count] = new Down(preX, preY, x, y, true, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y--;
						if(y >= 0) {
							//increase count
							count++;
						}
						else {
							y++;
							loop = false;
						}
					}
				break;
				case "L.png":
					//check if should got forward or backward
					if(preY != y) {
						//create path without reverse
						answer[count] = new Left(preX, preY, x, y, false, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x++;
						if(x < colPath) {
							//increase count
							count++;
						}
						else {
							x--;
							loop = false;
						}
					}
					else {
						//create path with reverse
						answer[count] = new Left(preX, preY, x, y, true, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y--;
						if(y >= 0) {
							//increase count
							count++;
						}
						else {
							y++;
							loop = false;
						}
					}
				break;
				case "R.png":
					//check if should got forward or backward
					if(preY != y) {
						//create path with reverse
						answer[count] = new Right(preX, preY, x, y, true, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x--;
						if(x >= 0) {
							//increase count
							count++;
						}
						else {
							x++;
							loop = false;
						}
					}
					else {
						//create path without reverse
						answer[count] = new Right(preX, preY, x, y, false, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y--;
						if(y < rowPath) {
							//increase count
							count++;
						}
						else {
							y++;
							loop = false;
						}
					}
				break;
				case "F.png":
					//check if should got forward or backward
					if(preY != y) {
						//create path with reverse
						answer[count] = new TopLeft(preX, preY, x, y, false, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x++;
						if(x < colPath) {
							//increase count
							count++;
						}
						else {
							x--;
							loop = false;
						}
					}
					else {
						//create path with reverse
						answer[count] = new TopLeft(preX, preY, x, y, true, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y++;
						if(y < rowPath) {
							//increase count
							count++;
						}
						else {
							y--;
							loop = false;
						}
					}
				break;
				case "T.png":
					//check if should got forward or backward
					if(preY != y) {
						//create path with reverse
						answer[count] = new TopRight(preX, preY, x, y, true, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						x--;
						if(x >= 0) {
							//increase count
							count++;
						}
						else {
							x++;
							loop = false;
						}
					}
					else {
						//create path without reverse
						answer[count] = new TopRight(preX, preY, x, y, false, pathFiles[x][y]);
						
						//new pre
						preY = y;
						preX = x;
						
						//move then check next position
						y++;
						if(y < rowPath) {
							//increase count
							count++;
						}
						else {
							y--;
							loop = false;
						}
					}
				break;
			}
		}
		
		return answer;
	}
	
}