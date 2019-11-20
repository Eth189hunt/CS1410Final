/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class Menu extends JPanel{
	//vars to so can access in jframe
	private JButton easy;
	private JButton hard;
	
	public Menu() {
		setLayout(null);
		
		//game title
		JLabel lblTowerDefenseGame = new JLabel("Tower Defense Game");
		lblTowerDefenseGame.setForeground(Color.BLACK);
		lblTowerDefenseGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblTowerDefenseGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTowerDefenseGame.setBounds(300, 0, 200, 40);
		add(lblTowerDefenseGame);
		
		//by line part 1
		JLabel title = new JLabel("CS 1410 Final Project");
		title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(240, 520, 320, 40);
		add(title);
		
		//by line part 2
		JLabel byLine = new JLabel("By Ethan Hunt");
		byLine.setHorizontalAlignment(SwingConstants.CENTER);
		byLine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		byLine.setBounds(320, 560, 160, 40);
		add(byLine);
		
		//buttons
		easy = new JButton("Easymode");
		easy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		easy.setBounds(166, 250, 150, 40);
		add(easy);
		
		hard = new JButton("Hardmode");
		hard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hard.setBounds(484, 250, 150, 40);
		add(hard);
		
		
		
	}
	
	public JButton getEasy() {
		return easy;
	}
	
	public JButton getHard() {
		return hard;
	}
}
