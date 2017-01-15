package Presentation;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestView extends JFrame implements ActionListener{
	
	private JFrame f1;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private GridLayout mapLayout;
	private BorderLayout mainLayout;
	private JButton confirm;
	private JTextField rowField;
	private JTextField columnField;
	private int gridRows;
	private int gridColumns;
	private int count; // For debugging
	private JTextField [][] gridTextFields;
	
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 800;
	public static final String APP_NAME = "TEST GUI";
	
	public TestView(){
		
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);	
		setTitle(APP_NAME);
		//pack();         												
		//set the x button as the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		setLocationRelativeTo(null);
		setVisible(true);
		
		f1 = new JFrame();
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		mainLayout = new BorderLayout();
		p2.setLayout(mainLayout);
		p3 = new JPanel(); // Display the actual Map grid
		
		rowField = new JTextField("10");
		columnField = new JTextField("10");
		
		
		confirm = new JButton("OK");
		confirm.addActionListener(this);
		
		/*
		 * Doesn't change anything
		rowField.setPreferredSize(new Dimension(50,20));
		columnField.setPreferredSize(new Dimension(50,20));
		confirm.setPreferredSize(new Dimension(50,20));
		*/
		
		p1.add(rowField);
		p1.add(columnField);
		p1.add(confirm);
		
		
		
		p2.add(p1, mainLayout.EAST);
		add(p2);
		// add(f1);
		this.setVisible(true); // Happen at the end of constructor
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "OK"){
			System.out.println(count++);
			System.out.println(rowField.getText()+"\t"+columnField.getText());
			gridRows = Integer.parseInt(rowField.getText());
			gridColumns = Integer.parseInt(columnField.getText());
			// confirm.setEnabled(false);
			mapLayout = new GridLayout(gridRows,gridColumns);
			p3.setLayout(mapLayout);
			gridTextFields = new JTextField[gridRows][gridColumns];
			count = 0;
			for(int i=0;i<gridRows;i++){
				for(int j=0;j<gridColumns;j++){
					gridTextFields[i][j] = new JTextField(""+count);
					p3.add(gridTextFields[i][j]);
					count++;
				}
			}
			p2.add(p3, mainLayout.CENTER);
			this.setVisible(true); // Any time layout is changed, must call this
			/*
			Map m = Map.getInstance();
			m.setMap(10,10);
			*/
		}
	}

}
