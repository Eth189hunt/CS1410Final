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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JPanel{
	public Game(int types) {
		setLayout(null);
		
		JPanel controls = new JPanel();
		controls.setBorder(new LineBorder(Color.RED, 5));
		controls.setBounds(0, 0, 200, 600);
		add(controls);
		controls.setLayout(null);
		
		JLabel money = new JLabel("Money:");
		money.setHorizontalAlignment(SwingConstants.CENTER);
		money.setBounds(10, 10, 180, 20);
		controls.add(money);
		
		JLabel life = new JLabel("Live:");
		life.setHorizontalAlignment(SwingConstants.CENTER);
		life.setBounds(10, 35, 180, 20);
		controls.add(life);
		
		
		JPanel towersView = new JPanel();
		towersView.setBounds(0,0,200,(20 + 70 * (types / 2) + 1));
		towersView.setPreferredSize(new Dimension(200,(20 + 70 * (types / 2) + 1)));
		towersView.setLayout(null);
		
		JPanel towerTypes[] = new JPanel[types];
		
		for(int v = 0; v < towerTypes.length / 2; v++) {
			
			towerTypes[v] = new JPanel();
			towerTypes[v].setBounds(20, (20 + 70 * v), 50, 50);
			towerTypes[v].setBorder(new LineBorder(Color.DARK_GRAY));
			towersView.add(towerTypes[v]);
			towerTypes[v].setLayout(null);
			
			
		}
		
		for(int v = 0; v < towerTypes.length / 2; v++) {
			
			towerTypes[(v + 3)] = new JPanel();
			towerTypes[(v + 3)].setBounds(90, (20 + 70 * v), 50, 50);
			towerTypes[(v + 3)].setBorder(new LineBorder(Color.DARK_GRAY));
			towersView.add(towerTypes[(v + 3)]);
			towerTypes[(v + 3)].setLayout(null);
			
			
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
		
		JScrollPane towersMenu = new JScrollPane(towersView);
		towersMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		towersMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		towersMenu.setBounds(10, 60, 180, 160);
		controls.add(towersMenu);
		
		JButton start = new JButton("Start");
		start.setFont(new Font("Tahoma", Font.PLAIN, 24));
		start.setBounds(10, 240, 180, 40);
		controls.add(start);
		
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
		
		GameMap map = new GameMap("WhiteStoneMap.txt");
		map.setBounds(200, 0, 600, 600);
		add(map);
		map.setLayout(null);
	}
}
