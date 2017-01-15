package Logic;

import java.util.ArrayList;


public class TowerList extends ArrayList<Tower> implements IObserver{
	Game g = Game.getInstance();
	ArrayList<int []> buildlog = new ArrayList<int []>();
	
	/**
	 * This is to buy towers, the requested tower goes into a build queue so that it can be built during the tower update phase
	 * @param type //this is the type of tower you want
	 * @param x //its x position
	 * @param y //its y position
	 */
	public boolean buyTower(int type, int y, int x){
		boolean wasBought = false;
		int [] toAdd = {type,x,y};// this is to store the tower inputs
		switch(type){ //use a switch to check if the player has enough money to buy the specified tower
		case 0:
			if (g.getMoney()>=(TowerSniper.cost)){
				buildlog.add(toAdd);// add it to the buildlog
				g.addMoney(-TowerSniper.cost);//and subtract the money immediately
				System.out.println("--added sniper to buildlog");
				//buildlog.get(buildlog.size())={1,1,1};
				//this.add(new TowerSniper(x,y));
				wasBought=true;
			}			
			break;
		case 1:
			if (g.getMoney()>=(TowerFast.cost)){
				buildlog.add(toAdd);
				g.addMoney(-TowerFast.cost);
				System.out.println("--added fast to buildlog");
				//this.add(new TowerFast(x,y));
				wasBought=true;
			}			
		break;
		case 2:
			if (g.getMoney()>=(TowerStrong.cost)){
				buildlog.add(toAdd);
				g.addMoney(-TowerStrong.cost);
				System.out.println("--added strong to buildlog");				
				//this.add(new TowerStrong(x,y));
				wasBought=true;
			}			
			break;
		}
		int [] a;//these next few lines just print what exactly was added to the buildlog + the rest of the buildlog
		for (int i = buildlog.size()-1; i >= 0;i--){
			a = buildlog.get(i);
			System.out.println(a[0]);
			System.out.println(a[1]);
			System.out.println(a[2]);			
		}
		System.out.println("--exit buytower");

		
		
		return wasBought;	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TowerList() {
		// TODO Auto-generated constructor stub
	}
	
	public void sellTower(int i){//this removes a tower from the game and refunds the player
		int refund = 0;
		System.out.println("###trying to sell"+i);
		if (this.get(i).isTowerFast()){refund=(int)(0.75*(TowerFast.cost));}//check the tower type for appropriate refund
		if (this.get(i).isTowerStrong()){refund=(int)(0.75*(TowerStrong.cost));}
		if (this.get(i).isTowerSniper()){refund=(int)(0.75*(TowerSniper.cost));}
		System.out.println("###selling tower "+i+" for "+refund);
		g.addMoney(refund);//give back money
		this.remove(i);//remove tower
	}	
	public void update(){//cycles through the towers to shoot and buld anything in the queue
		System.out.println("--enter update");
		for(int i=0; i<this.size(); i++){//++to put in gameclock		
			this.get(i).tick();//++to put in gameclock
		}//++t put in gameclock
		this.buildtick();
	}
	
	public Tower getTower(int y, int x){//this returns the tower object at a specific location
		System.out.println("trying to select");
		for(int i=0; i<this.size(); i++){
			if(this.get(i).getX() == x){
				if(this.get(i).getY() == y){
					System.out.println("MUCH SELECTING OF TOWER "+i);
					return this.get(i);		
				}
			}
		}
		return null;
	}	

	
	public int getTowerID(int y, int x){//this returns the ID or position in the towerlist array
		for(int i=0; i<this.size(); i++){
			if(this.get(i).getX() == x){
				if(this.get(i).getY() == y){
					System.out.println("MUCH SELECTING OF TOWER "+i);
					return i;		
				}
			}
		}
		return -1;
	}	

	
	
	
	public boolean buildtick(){// build tick cycles through the buildlog and adds all the necessary towers to the field

		int [] a;
		//if(buildlog.size() != 0){
		System.out.println("--enter buildtick "+buildlog.size());//}
		if (buildlog.size() == 0) {return false;}
		for (int i = buildlog.size()-1; i >= 0;i--){//goes through buildlog and adds appropriate towers
			a = buildlog.get(i);
			switch(a[0]){
			case 0:
				System.out.println("--built a sniper");
				this.add(new TowerSniper(a[1],a[2]));		
				break;
			case 1:
				System.out.println("--built a fast");
				this.add(new TowerFast(a[1],a[2]));		
				break;
			case 2:
				System.out.println("--built a strong");
				this.add(new TowerStrong(a[1],a[2]));		
				break;
			}
			buildlog.remove(i);//clears the buildlog
		}
		return true;	
	}


}
