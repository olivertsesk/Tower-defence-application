package Presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapSize extends JPanel implements ActionListener{
	
	private JPanel p1;
	private JPanel p2;
	private JButton confirm;
	private JTextField rows;
	private JTextField columns;
	private int count = 0;
	private int gridRows;
	private int gridColumns;
	
	public MapSize () {
		
		p1 = new JPanel(); // Main panel
		p2 = new JPanel(); // Panel to hold components
		
		BorderLayout layout = new BorderLayout();
		p1.setLayout(layout);
		// This layout can hold panels and place them in CENTER, NORTH, SOUTH, EAST, WEST
		p2.setLayout(new GridLayout(3,1));
		// This layout is in the form of a grid which holds panels by (rows, columns)
		
		confirm = new JButton ("OK"); // Button to confirm
		confirm.addActionListener(this);
		
		rows = new JTextField("10");
		columns = new JTextField("10");
		
		// Adding components to gridlayout
		p2.add(rows);
		p2.add(columns);
		p2.add(confirm);
		
		// Adding gridlayout panel to the main panel
		p1.add(p2, layout.CENTER);
		
		// Adding main panel to frame; without this you don't see it on the screen
		add(p1);
		init();
	}
	
	private void init(){
		
		/*
		// This allows the program to stop running and to close when you press this "X"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "OK"){
			System.out.println(count++);
			System.out.println(rows.getText()+"\t"+columns.getText());
			gridRows = Integer.parseInt(rows.getText());
			gridColumns = Integer.parseInt(columns.getText());
		}
	}
	
	public int getGridRows(){
		return gridRows;
	}
	public int getGridColumns(){
		return gridColumns;
	}
	/*	
public static void main (String [] args) throws Exception {
        
        MapSize ms = new MapSize();
    }
    */

}
