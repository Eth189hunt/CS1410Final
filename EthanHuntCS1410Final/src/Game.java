/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/


import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game extends JPanel{
	
	private JLabel moneyL;
	private JLabel liveL;
	private JLabel roundL;
	private JLabel posStat;
	private UpgradesGen upgrades;
	private MapLoad map;
	private int xClick;
	private int yClick;
	private boolean path1Butt;
	private boolean path2Butt;
	
	public Game(int mode, int types, String file) {
		setLayout(null);
		
		//control panel for none painted information
		JPanel controls = new JPanel();
		controls.setBorder(new LineBorder(Color.RED, 5));
		controls.setBounds(0, 0, 200, 600);
		add(controls);
		controls.setLayout(null);
		
		//panel for scroll with towers
		JPanel towersView = new JPanel();
		towersView.setBounds(0,0,200,(20 + 70 * (types / 2) + 1));
		towersView.setPreferredSize(new Dimension(200,(20 + 70 * (types / 2) + 1)));
		towersView.setLayout(null);
		
		//put in how many tower types are in
		JPanel towerTypes[] = new JPanel[types];
		
		//information for tower types
		String towerImage[] = {"tower0.png", "tower1.png", "tower2.png", "tower0r.png", "tower1r.png", "tower2r.png"};
		int towerCost[] = {25, 50, 75, 25, 50, 75};
		
		//loads each tower type
		//load left tower types
		for(int v = 0; v < towerTypes.length / 2; v++) {
			
			//jpanel to hold tower button and cost
			towerTypes[v] = new JPanel();
			towerTypes[v].setBounds(20, (20 + 70 * v), 50, 50);
			towersView.add(towerTypes[v]);
			towerTypes[v].setLayout(null);
			
			//image for button
			ImageIcon image = new ImageIcon(towerImage[v]);
			Image image2 = image.getImage();
			Image newImage = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
			image = new ImageIcon(newImage);
			
			//tower creation button with image of it
			JButton tower = new JButton(image);
			tower.setText(v + "");
			tower.setFont(new Font("Tahoma", Font.PLAIN, 0));
			tower.setIconTextGap(-25);
			tower.setIcon(image);
			tower.setBounds(10, 0, 30, 30);
			tower.setBorder(new LineBorder(Color.DARK_GRAY));
			towerTypes[v].add(tower);
			tower.setLayout(null);
			
			//cost below tower creation button
			JLabel cost = new JLabel();
			cost.setBounds(0, 30, 50, 20);
			cost.setText("$" + towerCost[v]);
			cost.setHorizontalAlignment(SwingConstants.CENTER);
			towerTypes[v].add(cost);
			
			//what happens when tower is clicked
			tower.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					createTower(xClick, yClick, tower.getText(), towerImage, towerCost);
				}
			});
			
			
		}
		
		//load right tower types
		for(int v = 0; v < towerTypes.length / 2; v++) {
			
			//increase to different v so correct position on array
			int tempv = v + (towerTypes.length / 2);
			
			//jpanel to hold tower button and cost
			towerTypes[tempv] = new JPanel();
			towerTypes[tempv].setBounds(90, (20 + 70 * v), 50, 50);
			towersView.add(towerTypes[tempv]);
			towerTypes[tempv].setLayout(null);
			
			//image for button
			ImageIcon image = new ImageIcon(towerImage[tempv]);
			Image image2 = image.getImage();
			Image newImage = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
			image = new ImageIcon(newImage);
			
			//tower creation button with image of it
			JButton tower = new JButton(image);
			tower.setText(tempv + "");
			tower.setFont(new Font("Tahoma", Font.PLAIN, 0));
			tower.setIconTextGap(-25);
			tower.setIcon(image);
			tower.setBounds(10, 0, 30, 30);
			tower.setBorder(new LineBorder(Color.DARK_GRAY));
			towerTypes[tempv].add(tower);
			tower.setLayout(null);
			
			//cost below tower creation button
			JLabel cost = new JLabel();
			cost.setBounds(0, 30, 50, 20);
			cost.setText("$" + towerCost[tempv]);
			cost.setHorizontalAlignment(SwingConstants.CENTER);
			towerTypes[tempv].add(cost);
			
			//what happens when tower is clicked
			tower.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					createTower(xClick, yClick, tower.getText(), towerImage, towerCost);
				}
			});
			
			
		}
		
		//create towerMenu with towersView for a scroll pane
		JScrollPane towersMenu = new JScrollPane(towersView);
		towersMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		towersMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		towersMenu.setBounds(10, 60, 180, 240);
		controls.add(towersMenu);
		
		//button for start/pause/unpause/end
		JButton start = new JButton("Start");
		start.setFont(new Font("Tahoma", Font.PLAIN, 24));
		start.setBounds(10, 310, 180, 40);
		controls.add(start);
		
		//upgrade window
		upgrades = new UpgradesGen();
		upgrades.setBounds(10, 410, 180, 180);
		upgrades.setBorder(new LineBorder(Color.DARK_GRAY));
		upgrades.setLayout(null);
		controls.add(upgrades);
		
		//path buttons disable
		path1Butt = false;
		path2Butt = false;
		upgrades.getPath1().setEnabled(false);
		upgrades.getPath2().setEnabled(false);
		
		//create map for enemies and towers
		map = new MapLoad(mode, file);
		map.setBounds(200, 0, 600, 600);
		add(map);
		map.setLayout(null);
		
		
		moneyL = new JLabel("Money: " + map.getMoney());
		moneyL.setHorizontalAlignment(SwingConstants.CENTER);
		moneyL.setBounds(10, 10, 180, 20);
		controls.add(moneyL);
		
		liveL = new JLabel("Live: " + map.getLive());
		liveL.setHorizontalAlignment(SwingConstants.CENTER);
		liveL.setBounds(10, 35, 180, 20);
		controls.add(liveL);
		
		roundL = new JLabel("Round: " + map.getRound());
		roundL.setHorizontalAlignment(SwingConstants.CENTER);
		roundL.setBounds(10, 355, 180, 10);
		controls.add(roundL);
		
		//if good or not to place tower
		posStat = new JLabel("<html><p>Tower placement: " + "Not Selected" + "</p></html>");
		posStat.setHorizontalAlignment(SwingConstants.CENTER);
		posStat.setBounds(10, 370, 180, 40);
		controls.add(posStat);
		
		
		//start action
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//for is start
				if(start.getText().equals("Start")) {
					start.setText("Pause/End");
					map.start();
					
					//update
					update();
					
				}
				//for pause/end
				else if(start.getText().equals("Pause/End")) {
					//if enemies on map still then freze map
					if(map.getEnemiesCount() != 0) {
						start.setText("UnPause");
						map.pause();
					}
					//if not then end round
					else {
						start.setText("Start");
						map.end();
					}
					
					//update
					update();
					
				}
				//for unpause
				else if(start.getText().equals("UnPause")) {
					start.setText("Pause/End");
					map.unpause();
					
					//update
					update();
				}
			}
		});
		
		//get x and y for creation of tower
		map.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				//get x and y for click
				xClick = event.getX();
				yClick = event.getY();
				
				//check that tower placement works
				posStat.setText("<html><p>Tower placement: \n" + (map.getTp(xClick, yClick)) + "</p></html>");
				
				//get upgrades
				if(map.getTower((xClick - (xClick % 50)), (yClick - (yClick % 50))) != null){
					//update upgrades
					upgrades.textUp(map.getTower((xClick - (xClick % 50)), (yClick - (yClick % 50))).getUpgrades());
					
					//enable click
					path1Butt = true;
					path2Butt = true;
					
					//look like can't click
					upgrades.getPath1().setEnabled(true);
					upgrades.getPath2().setEnabled(true);
				}
				//blank upgrades
				else {
					//null text
					upgrades.textNull();
					
					//can't click
					path1Butt = false;
					path2Butt = false;
					
					//look like can't click
					upgrades.getPath1().setEnabled(false);
					upgrades.getPath2().setEnabled(false);
				}
				
				//update
				update();
			}
		});
		
		//button for upgrades path1
		upgrades.getPath1().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				//method for mouseClick
				path1Click(event);
			}
		});
		
		upgrades.getDesc1().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				//method for mouseClick
				path1Click(event);
			}
		});
		
		//button for upgrades path2
		upgrades.getPath2().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				//method for mouseClick
				path2Click(event);
			}
		});
		
		upgrades.getDesc2().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				//method for mouseClick
				path2Click(event);
			}
		});
		
		
	}
	
	public void update() {
		//get and set money, live, round
		moneyL.setText("Money: " + map.getMoney());
		liveL.setText("Live: " + map.getLive());
		roundL.setText("Round: " + map.getRound());
	}
	
	public void createTower(int xClick, int yClick, String value, String[] towerImage, int[] towerCost) {
		//check if on path if not place
		if(map.getTpPath(xClick, yClick)) {
			//create tower function is MapLoad
			map.createTower(xClick, yClick, value, towerImage, towerCost);
		}
		//can place on path
		else {
			System.out.println("Can't place on Path");
		}
		//update
		update();
	}
	
	public void path1Click(MouseEvent event) {
		if(path1Butt) {
			if(map.getTower((xClick - (xClick % 50)), (yClick - (yClick % 50))) != null){
				//change upgrades
				int tSlot = map.getTowerSlot((xClick - (xClick % 50)), (yClick - (yClick % 50)));
				int slot = 0;
				map.pathClick(tSlot, slot);
				
				//update upgrades
				upgrades.textUp(map.getTower((xClick - (xClick % 50)), (yClick - (yClick % 50))).getUpgrades());
				
				//update
				update();
			}
		}
	}
	
	public void path2Click(MouseEvent event) {
		if(path2Butt) {
			if(map.getTower((xClick - (xClick % 50)), (yClick - (yClick % 50))) != null){
				//change upgrades
				int tSlot = map.getTowerSlot((xClick - (xClick % 50)), (yClick - (yClick % 50)));
				int slot = 1;
				map.pathClick(tSlot, slot);
				
				//update upgrades
				upgrades.textUp(map.getTower((xClick - (xClick % 50)), (yClick - (yClick % 50))).getUpgrades());
				
				//update
				update();
			}
		}
	}
	
	
	
}
