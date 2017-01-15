package Logic;

public class TowerStrong extends Tower{

	static final int cost=10;	
	static final int type = 2;	
	
	public TowerStrong(int x, int y) {
		super();


		//pos=5
		cooldown=5;
		timer=cooldown;
		range=2;
		shotpower=20;
		targetingstrategy=2;
		screenx=x;
		screeny=y;
		upgraded=0;
		//g.addMoney(-cost);

		// TODO Auto-generated constructor stub
	}	
	
	
}