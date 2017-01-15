package Logic;


public class TowerSniper extends Tower{

	static final int cost = 6;	
	static final int type = 0;
	
	public TowerSniper(int x, int y) {
		super();

		//pos=5
		cooldown=4;
		timer=cooldown;
		range=6;
		shotpower=10;
		targetingstrategy=2;
		screenx=x;
		screeny=y;
		upgraded=0;
		//g.addMoney(-cost);
		// TODO Auto-generated constructor stub
	}	
	
	
}