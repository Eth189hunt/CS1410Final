/*
Name: Ethan Hunt
Class: CS 1410-02
Assignment: Final
Date: 12/9/2019
*/

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UpgradesGen extends JPanel{
	
	private JButton path1;
	private JButton path2;
	private JLabel nameL1;
	private JTextArea descL1;
	private JLabel costL1;
	private JLabel nameL2;
	private JTextArea descL2;
	private JLabel costL2;
	
	
	public UpgradesGen(){
		//make sure absolute
		setLayout(null);
		
		//top path upgrade button
		path1 = new JButton();
		path1.setBounds(10, 20, 160, 60);
		path1.setBorder(new LineBorder(Color.DARK_GRAY));
		path1.setLayout(null);
		add(path1);
		
		//top path upgrade name
		nameL1 = new JLabel();
		nameL1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameL1.setBounds(5, 1, 155, 10);
		path1.add(nameL1);
		
		//top path upgrade desc
		descL1 = new JTextArea();
		descL1.setBounds(1, 10, 160, 40);
		descL1.setWrapStyleWord(true);
		descL1.setLineWrap(true);
		descL1.setOpaque(false);
		descL1.setEditable(false);
		descL1.setFocusable(false);
		path1.add(descL1);
		
		//top path upgrade cost
		costL1 = new JLabel();
		costL1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		costL1.setHorizontalAlignment(SwingConstants.RIGHT);
		costL1.setBounds(0, 49, 155, 10);
		path1.add(costL1);
		
		//bottom path upgrade button
		path2 = new JButton();
		path2.setBounds(10, 100, 160, 60);
		path2.setBorder(new LineBorder(Color.DARK_GRAY));
		path2.setLayout(null);
		add(path2);
		
		//bottom path upgrade name
		nameL2 = new JLabel();
		nameL2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameL2.setBounds(5, 1, 155, 10);
		path2.add(nameL2);
		
		//bottom path upgrade desc
		descL2 = new JTextArea();
		descL2.setBounds(1, 10, 160, 40);
		descL2.setWrapStyleWord(true);
		descL2.setLineWrap(true);
		descL2.setOpaque(false);
		descL2.setEditable(false);
		descL2.setFocusable(false);
		path2.add(descL2);
		
		//bottom path upgrade cost
		costL2 = new JLabel();
		costL2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		costL2.setHorizontalAlignment(SwingConstants.RIGHT);
		costL2.setBounds(0, 49, 155, 10);
		path2.add(costL2);
		
		
	}
	
	//to set info for tower current upgrades
	public void textUp(Upgrade[] upInfo) {
		nameL1.setText(upInfo[0].getName());
		descL1.setText(upInfo[0].getDesc());
		costL1.setText("$" + upInfo[0].getCost());
		nameL2.setText(upInfo[1].getName());
		descL2.setText(upInfo[1].getDesc());
		costL2.setText("$" + upInfo[1].getCost());
	}
	
	//for blank once no more upgrades
	public void textNull() {
		//no text
		nameL1.setText("");
		descL1.setText("");
		costL1.setText("");
		nameL2.setText("");
		descL2.setText("");
		costL2.setText("");
	}
	
	public JButton getPath1() {
		return path1;
	}
	
	public JTextArea getDesc1() {
		return descL1;
	}
	
	public JButton getPath2() {
		return path2;
	}
	
	public JTextArea getDesc2() {
		return descL2;
	}
	
}
