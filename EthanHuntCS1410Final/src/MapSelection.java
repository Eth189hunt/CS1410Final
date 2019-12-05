/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;

public class MapSelection extends JPanel{
		
	public MapSelection(int mapCount, int mode) {
		//make sure absolute layout
		setLayout(null);
		
		//title for map selection
		JLabel title = new JLabel("Map Selection");
		title.setBounds(200, 40, 400, 40);
		title.setFont(new Font("Tahoma", Font.PLAIN, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		//jpanel for map slection to allow multiple maps in scroll window
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, (10 * (mapCount + 1) + 150 * mapCount), 180);
		panel.setPreferredSize(new Dimension((10 * (mapCount + 1) + 150 * mapCount),180));
		panel.setLayout(null);
		
		//arrays for map in selection scroll window
		JPanel[] maps = new JPanel[mapCount];
		String[] mapFiles = new String[mapCount];
		
		//set file names for later use
		mapFiles[0] = "GrassPathMap";
		mapFiles[1] = "WhiteStoneMap";
		
		//create jpanel for maps
		for(int v = 0; v < maps.length; v++) {
			
			//jpanel to hold image and button
			maps[v] = new JPanel();
			maps[v].setBounds((10 * (v + 1) + 150 * v), 11, 150, 159);
			panel.add(maps[v]);
			maps[v].setLayout(null);
			
			//image that is scaled to fit
			ImageIcon image = new ImageIcon(mapFiles[v] + ".png");
			Image image2 = image.getImage();
			Image newImage = image2.getScaledInstance(150, 120,  java.awt.Image.SCALE_SMOOTH);
			image = new ImageIcon(newImage);
			
			//label with image to see it
			JLabel top = new JLabel(image);
			top.setBounds(0, 0, 150, 120);
			maps[v].add(top);
			
			//button for map
			JButton bottom = new JButton(mapFiles[v]);
			bottom.setBounds(0, 120, 150, 39);
			maps[v].add(bottom);
			
			//how it calls on game with map information
			bottom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//make map selection go away
					setVisible(false);
					
					//create map
					Game map = new Game(mode, 6, (bottom.getText() + ".txt"));
					getRootPane().getContentPane().add(map);
				}
			});
			
			//System.out.println((10 * (v + 1) + 150 * v));
			
		}
		
		//put panel in scroll window so that can scroll
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(100, 200, 600, 200);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
	}
}
