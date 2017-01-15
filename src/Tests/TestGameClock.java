package Tests;
import Logic.*;
import Logic.Map;

public class TestGameClock {

	public static void main(String[] args) {
		Map m = Map.getInstance();
		m.openMap("test2");
		m.printGrid();
		m.printPath();
		Game game = Game.getInstance();
		game.setGame(); 
		
		//game.addObserver(game.getCritterWave());
		
		//new GameTimer(game);	
		game.startLevel();	
		System.out.println("end");
	

	}

}
