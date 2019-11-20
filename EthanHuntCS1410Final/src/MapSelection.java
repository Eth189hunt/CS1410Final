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
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;

public class MapSelection extends JPanel{
	
	public MapSelection(int mapCount) {
		setLayout(null);
		
		
		
		JLabel title = new JLabel("Map Selection");
		title.setFont(new Font("Tahoma", Font.PLAIN, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 40, 400, 40);
		add(title);
		
		JPanel panel = new JPanel();
		
		JPanel[] maps = new JPanel[mapCount];
		
		for(int v = 0; v < mapCount; v++) {
			
			maps[v] = new JPanel();
			maps[v].setBounds((10 * (v + 1) + 150 * v), 11, 150, 159);
			panel.add(maps[v]);
			
			JPanel top = new JPanel();
			top.setBounds(0, 0, 150, 120);
			maps[v].add(top);
			
			JButton bottom = new JButton("Select");
			bottom.setBounds(0, 120, 150, 39);
			maps[v].add(bottom);
			
			System.out.println((10 * (v + 1) + 150 * v));
			
		}
		
		JScrollPane scrollPane = new JScrollPane(panel);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(100, 200, 600, 200);
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
