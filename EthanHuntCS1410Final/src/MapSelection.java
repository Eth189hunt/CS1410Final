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
		setLayout(null);
		
		
		
		JLabel title = new JLabel("Map Selection");
		title.setBounds(200, 40, 400, 40);
		title.setFont(new Font("Tahoma", Font.PLAIN, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, (10 * (mapCount + 1) + 150 * mapCount), 180);
		panel.setPreferredSize(new Dimension((10 * (mapCount + 1) + 150 * mapCount),180));
		panel.setLayout(null);
		
		JPanel[] maps = new JPanel[mapCount];
		String[] mapFiles = new String[mapCount];
		
		for(int v = 0; v < mapFiles.length; v++) {
			mapFiles[v] = "hi";
		}
		
		mapFiles[0] = "WhiteStoneMap";
		
		for(int v = 0; v < maps.length; v++) {
			
			maps[v] = new JPanel();
			maps[v].setBounds((10 * (v + 1) + 150 * v), 11, 150, 159);
			panel.add(maps[v]);
			maps[v].setLayout(null);
			
			ImageIcon topI = new ImageIcon("StoneWall.png");
			JLabel top = new JLabel(topI);
			top.setBounds(0, 0, 150, 120);
			maps[v].add(top);
			
			JButton bottom = new JButton(mapFiles[v]);
			bottom.setBounds(0, 120, 150, 39);
			maps[v].add(bottom);
			
			bottom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Game map = new Game(mode, 6, (bottom.getText() + ".txt"));
					getRootPane().getContentPane().add(map);
				}
			});
			
			//System.out.println((10 * (v + 1) + 150 * v));
			
		}
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(100, 200, 600, 200);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		/*JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 160, 159);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 120, 160, 39);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 160, 120);
		panel_1.add(panel_3);*/
		
	}
}
