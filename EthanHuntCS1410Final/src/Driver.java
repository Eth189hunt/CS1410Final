/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Driver extends JFrame{
	//vars
	

	public static void main(String[] args) {
		
		Driver window = new Driver();
		window.setSize(800, 640);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	public Driver() {
		
		//create main menu
		Menu m = new Menu();
		m.setBounds(0, 0, 800, 600);
		getContentPane().add(m);
		
		//goto easy if clicked
		m.getEasy().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("easy");
				m.setVisible(false);
				MapSelection mapSel = new MapSelection(10, 1);
				getContentPane().add(mapSel);
			}
		});
		
		//goto hard if clicked
		m.getHard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("hard");
				m.setVisible(false);
				MapSelection mapSel = new MapSelection(10, 2);
				getContentPane().add(mapSel);
			}
		});
		
		
		
		
		
	}
	
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		
	}
	
	
}
