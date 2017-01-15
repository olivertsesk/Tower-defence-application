package Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapEditor extends JFrame implements ActionListener {

	private JFrame f1;
	private JPanel p1;
	private MapSize mS = new MapSize();
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 800;
	public static final String APP_NAME = "MAP EDITOR";
	
	public MapEditor(){
		f1 = new JFrame();
		p1 = new JPanel();
		BorderLayout bL = new BorderLayout();
		p1.setLayout(bL);
		/*
		p1.setLayout(new BorderLayout());
		p1.add("Center",mS);
		*/
		p1.add(mS, bL.CENTER);
		init();
	}
	
	/**
	 * Initialize the window
	 */
	// From Shabbir's Snake Tutorial
	private void init(){
		
		//set the Frame properties
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);	
		setTitle(APP_NAME);
		pack();         												
		//set the x button as the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		setLocationRelativeTo(null);
		setVisible(true);
		// p1.add(mS);
		add(p1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
