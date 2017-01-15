package Logic;
import java.util.*;

public class GameTimer {
	
	Timer timer; 
	Game game;
	
	
	public GameTimer(Game game){
		this.game = game;
		timer = new Timer();
		timer.schedule(new Tick(), 0, 100);
	}

	public void endGameTimer(){
		game.setInWave(false);
		timer.cancel();
	}
	
	public class Tick extends TimerTask {
		/**
		* Method that will be called when the timer starts 
		*/
		public void run() {
			System.out.println("running");
			// TODO Auto-generated method stub
			//System.out.println("test");
			game.tick();
			if(game.getLife()<=0){
				//Player lost all lives (Start from the beginning) 
				game.setLevel(1);
				System.out.println("you lost");
				endGameTimer();
			}
			else if (game.getCritterWave().getListCritters().isEmpty()){
				//All the critters are dead, move to next level
				game.setLevel(game.getLevel()+1);
				System.out.println("next level");
				endGameTimer();			
			}				
		}
	}
}
