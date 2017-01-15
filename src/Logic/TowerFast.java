package Logic;

public class TowerFast extends Tower{
	static final int cost = 8;
	static final int type = 1;	
	
	public TowerFast(int x, int y) {
		super();


		//pos=5
		cooldown=3;
		timer=cooldown;
		range=4;
		shotpower=10;
		targetingstrategy=2;
		screenx=x;
		screeny=y;
		upgraded=0;
		//g.addMoney(-cost);
	
		// TODO Auto-generated constructor stub
	}	
	
	
}