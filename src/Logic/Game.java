package Logic;
import java.util.*;

import Logic.*;
import Logic.Map;


public class Game extends Subject{
	private int level;
	private LinkedList<Path> pathList;
	private CritterWave wave;
	private static Game gameInstance= null;
	private int money;
	private int Life;
	private boolean inWave;
//	Timer timer = new Timer();
	TowerList mytowerlist;

	
	public TowerList getMytowerlist() {
		return mytowerlist;
	}


	private Game(){
		
	}
	
	/**
	* Initialized the Main components and variables for the Game
	*/
	public void setGame(){
		Map m = Map.getInstance();
		//wave= new CritterWave(level);
		mytowerlist= new TowerList();
		pathList = new LinkedList<Path>();
		level =1;
		money = 100;
		Life = 10;
		for (Path p : m.getPath()){
			pathList.add(p);
		}
		this.addObserver(mytowerlist);
		wave=new CritterWave();
		this.addObserver(getCritterWave());
	}
	
	
	public static Game getInstance(){
		if(gameInstance==null)
			gameInstance=new Game();
		return gameInstance;
	}
	
	
	//GETTERS
	public LinkedList<Path> getPathList(){
		return pathList;
	}
	public CritterWave getCritterWave(){
		return wave;
	}
	public int getMoney(){
		return money;
	}
	public int getLife(){
		return Life;
	}
	public int getLevel(){
		return level;
	}
	
	//SETTERS
	public void setMoney(int n){
		money=n;
	}
	public void setLife(int n){
		Life=n;
	}
	public void setLevel(int n){
		level=n;
	}
	
	public void decrementLife(int n){
		Life-=n;
	}	
	public void addMoney(int n){
		money+=n;
	}


	public void startLevel(){
		this.wave.setWave(level);
		inWave = true;
		//this.addObserver(getMytowerlist());//should be initialized once with Game
		new GameTimer(this);
	}
	
	


	
	public boolean isInWave() {
		return inWave;
	}


	public void setInWave(boolean inWave) {
		this.inWave = inWave;
	}


	/**
	 * The game will notify Tower and Critters every time the clock ticks 
	 */
	public void tick(){
		notifyObservers();
		System.out.println("Money: " + getMoney() + "\nLife: " + getLife());
	}
}
