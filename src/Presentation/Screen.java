package Presentation;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

	public Thread thread = new Thread(this); // Do this to create a thread of ourself
	
	public static int myWidth, myHeight;
	
	public static boolean isFirst = true;
	
	public static Room room;
	
	public Screen(){
		
		thread.start(); 
	}
	
	public void paintComponent(Graphics g) {
		
		if(isFirst){ // First time going through method
			
			define();
			
			isFirst = false;
			
		}
		
		g.clearRect(0, 0, getWidth(), getHeight());
		
		room.draw(g); // Draw room
		
	}
	
	private void define() {
		// TODO Auto-generated method stub
		room = new Room();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			if(!isFirst){
				
			}
			
			repaint();
			
			try{
				thread.sleep(1);
			}
			catch(Exception e){
				
			}
			
		}
		
	}

}
