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
	private MapLoad map;
	private int xClick;
	private int yClick;
	
	public Game(int mode, int types, String file) {
		setLayout(null);
		
		JPanel controls = new JPanel();
		controls.setBorder(new LineBorder(Color.RED, 5));
		controls.setBounds(0, 0, 200, 600);
		add(controls);
		controls.setLayout(null);
		
		JPanel towersView = new JPanel();
		towersView.setBounds(0,0,200,(20 + 70 * (types / 2) + 1));
		towersView.setPreferredSize(new Dimension(200,(20 + 70 * (types / 2) + 1)));
		towersView.setLayout(null);
		
		
		JPanel towerTypes[] = new JPanel[types];
		
		String towerImage[] = {"tower0.png", "tower1.png", "tower2.png", "tower0r.png", "tower1r.png", "tower2r.png"};
		int towerCost[] = {25, 50, 75, 25, 50, 75};
		
		for(int v = 0; v < towerTypes.length / 2; v++) {
			
			ImageIcon image = new ImageIcon(towerImage[v]);
			Image image2 = image.getImage();
			Image newImage = image2.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
			image = new ImageIcon(newImage);
			
			JButton tower = new JButton(image);
			tower.setText(v + "");
			tower.setFont(new Font("Tahoma", Font.PLAIN, 0));
			tower.setIconTextGap(-25);
			tower.setIcon(image);
			tower.setBounds(20, (20 + 70 * v), 50, 50);
			tower.setBorder(new LineBorder(Color.DARK_GRAY));
			tower.setLayout(null);
			
			towerTypes[v] = new JPanel();
			towerTypes[v].setBounds(20, (20 + 70 * v), 50, 50);
			towersView.add(towerTypes[v]);
			towerTypes[v].add(tower);
			
			tower.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					//work or fail statement
					if(map.createTower(xClick, yClick, (tower.getText()), towerImage, towerCost)){
						
					}else {
						System.out.println("Not enough money");
					}
					
					//update
					update();
				}
			});
			
			
		}
		
		for(int v = 0; v < towerTypes.length / 2; v++) {
			
			int tempv = v + (towerTypes.length / 2);
			
			ImageIcon image = new ImageIcon(towerImage[tempv]);
			Image image2 = image.getImage();
			Image newImage = image2.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
			image = new ImageIcon(newImage);
			
			JButton tower = new JButton(image);
			tower.setText(tempv + "");
			tower.setFont(new Font("Tahoma", Font.PLAIN, 0));
			tower.setIconTextGap(-25);
			tower.setIcon(image);
			tower.setBounds(90, (20 + 70 * v), 50, 50);
			tower.setBorder(new LineBorder(Color.DARK_GRAY));
			tower.setLayout(null);
			
			towerTypes[tempv] = new JPanel();
			towerTypes[tempv].setBounds(90, (20 + 70 * v), 50, 50);
			towersView.add(towerTypes[tempv]);
			towerTypes[tempv].add(tower);
			
			tower.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					map.createTower(xClick, yClick, (tower.getText()), towerImage, towerCost);
					
					//update
					update();
				}
			});
			
			
		}
		
		/*JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 20, 50, 50);
		towersView.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(90, 20, 50, 50);
		towersView.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 90, 50, 50);
		towersView.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(90, 90, 50, 50);
		towersView.add(panel_4);*/
		
		//
		
		JScrollPane towersMenu = new JScrollPane(towersView);
		towersMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		towersMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		towersMenu.setBounds(10, 60, 180, 240);
		controls.add(towersMenu);
		
		JButton start = new JButton("Start");
		start.setFont(new Font("Tahoma", Font.PLAIN, 24));
		start.setBounds(10, 310, 180, 40);
		controls.add(start);
		
		/*game over screen
		JLabel overT = new JLabel("Game Over");
		overT.setHorizontalAlignment(SwingConstants.CENTER);
		overT.setBounds(400, 220, 200, 20);
		add(overT);
		
		JLabel overT2 = new JLabel("Click to go to main screen");
		overT2.setHorizontalAlignment(SwingConstants.CENTER);
		overT2.setBounds(400, 240, 200, 20);
		add(overT2);
		
		JButton over = new JButton("End Game");
		over.setFont(new Font("Tahoma", Font.PLAIN, 24));
		over.setBounds(400, 260, 200, 40);
		add(over);*/
		
		Upgrades upgrades = new Upgrades();
		upgrades.setBounds(10, 410, 180, 180);
		upgrades.setBorder(new LineBorder(Color.DARK_GRAY));
		controls.add(upgrades);
		upgrades.setLayout(null);
		
		/*JPanel panel = new JPanel();
		panel.setBounds(10, 410, 180, 180);
		controls.add(panel);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_5.setBounds(10, 20, 160, 60);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel upgradeName = new JLabel("New label");
		upgradeName.setBounds(1, 0, 158, 20);
		panel_5.add(upgradeName);
		
		JLabel description = new JLabel("New label");
		description.setBounds(1, 20, 158, 20);
		panel_5.add(description);
		
		JLabel cost = new JLabel("lnew");
		cost.setHorizontalAlignment(SwingConstants.TRAILING);
		cost.setBounds(58, 40, 100, 20);
		panel_5.add(cost);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_6.setLayout(null);
		panel_6.setBounds(10, 100, 160, 60);
		panel.add(panel_6);
		
		JLabel label = new JLabel("New label");
		label.setBounds(1, 0, 158, 20);
		panel_6.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(1, 20, 158, 20);
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("lnew");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setBounds(58, 40, 100, 20);
		panel_6.add(label_2);*/
		
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
				xClick = event.getX();
				yClick = event.getY();
				posStat.setText("<html><p>Tower placement: \n" + (map.getTp(xClick, yClick)) + "</p></html>");
				//System.out.println(xClick + " " + yClick);
				
				//update
				update();
			}
		});
		
		
	}
	
	public void update() {
		//get and set money, live, round
		moneyL.setText("Money: " + map.getMoney());
		liveL.setText("Live: " + map.getLive());
		roundL.setText("Round: " + map.getRound());
		
		
	}
	
	
	
}
