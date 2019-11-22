/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Upgrades extends JPanel{
	
	public Upgrades(){
		
		JPanel path1 = new JPanel();
		path1.setBorder(new LineBorder(Color.DARK_GRAY));
		path1.setBounds(10, 20, 160, 60);
		add(path1);
		path1.setLayout(null);
		
		JPanel path2 = new JPanel();
		path2.setBorder(new LineBorder(Color.DARK_GRAY));
		path2.setBounds(10, 100, 160, 60);
		add(path2);
		path2.setLayout(null);
	}
	
}
