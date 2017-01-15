package Presentation;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SplitPane extends JSplitPane{

	private JSplitPane splitPane;
	private int splitPosition;
	
	/**
	 * 
	 * @param leftPanel
	 * @param RightPanel
	 * @param splitSize
	 */
	public SplitPane(JPanel leftPanel, JPanel RightPanel,int splitSize){
		
		splitPosition = splitSize-this.getInsets().right-this.getDividerSize();
		this.setDividerLocation(splitPosition);
		// Resizable false
		
		this.setLeftComponent(leftPanel);
		this.setRightComponent(RightPanel);
		
		/*
		super(new BorderLayout());
		
		
		splitPane.setContinuousLayout(true); // always refresh after resizes
		splitPane.setOneTouchExpandable(true); // Allow collapsing
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, RightPanel);
		add(splitPane, BorderLayout.CENTER);
		*/
		setVisible(true);
	}
	
	// http://stackoverflow.com/questions/7065309/jsplitpane-set-resizable-false
	// this link showed how to freeze the position of the location of the split
	 @Override
	 public int getDividerLocation() {
		 return splitPosition ;
	 }
	 @Override
	 public int getLastDividerLocation() {
		 return splitPosition;
	 }
	
}
