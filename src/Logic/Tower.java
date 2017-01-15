package Logic;

public abstract class Tower {

	public Tower(){}
	
	//variables
	public static int cost;
	public int cooldown;//time between shots
	public int timer;//count down timer to next shot
	public int range;//how far it can shoot
	public int shotpower;//how much damage
	public int targetingstrategy;//which targeting strategy
	public int screenx;//x coord
	public int screeny;//ycoord
	public int upgraded;//how upgraded is it


	Game g= Game.getInstance();
	
	public int getCooldown() {//cooldown getter
		return cooldown;
	}

	public int getRange() {//range getter
		return range;
	}

	public int getShotpower() {//damage getter
		return shotpower;
	}
	

	public void tick() {		//every gamecycle
		if (timer > 0) {		//the countdown timer goes down (getting ready to shoot)
			timer -= 1;		//if it was already 0 and didn't shoot (no valid targets), it stays ready to shoot
		}
		if (timer == 0){
			if(firesequence()) {  //it shoots, if successful, timer resets, if not, it waits for the next gamecycle
				timer = cooldown;
			}
		}
	}

	public int targeting(){	//this method pick a critter id that satisfis the in range alive and on the field criteria and is the best target depending on the strategy
		int targetcandidate = -1;//default is no valid target
		int distance = 0;
		for(int i = 0; i < g.getCritterWave().getCritterInField().size(); i++) {//cycles through all the critters on the field
			if ((g.getCritterWave().getCritterInField().get(i).isAlive())) {//will not proceed with already dead criters
				Critter mycritter = g.getCritterWave().getCritterInField().get(i);
				distance = (int)(Math.pow(mycritter.getPosX() - screenx, 2) + Math.pow(mycritter.getPosY() - screeny, 2));//checks if inn range
				if (distance <= (int)Math.pow(range, 2)){
					//System.out.println("in range"+i);
					if (targetcandidate == -1){//it has met criteria, if there are no other valid targets found yet, it is the target
						targetcandidate = i;
						//System.out.println("found valid target"+i);
					}
					else{// these cases will compare the current target with the next valid criter in the list to see which is a better target, depending on the targeting strategy
						switch(targetingstrategy){
							case 0://closest 
								if(distance < (Math.pow(g.getCritterWave().getCritterInField().get(targetcandidate).getPosX()-screenx,2) + Math.pow(g.getCritterWave().getCritterInField().get(targetcandidate).getPosY()-screenx,2))){
									targetcandidate=i;
									//System.out.println("switched to"+i);
								}
							break;
							case 1://farthest 
								if(distance>((g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screenx)*(g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screenx))+((g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screeny)*(g.getCritterWave().getCritterInField().get(targetcandidate).getPosition()-screeny))){
									targetcandidate=i;						
								}
							break;
							case 2://least health 
								if(g.getCritterWave().getCritterInField().get(i).getHealth()<g.getCritterWave().getCritterInField().get(targetcandidate).getHealth()){
									targetcandidate=i;						
								}
							break;
							case 3://most health 
								if(g.getCritterWave().getCritterInField().get(i).getHealth()>g.getCritterWave().getCritterInField().get(targetcandidate).getHealth()){
									targetcandidate=i;						
								}
							break;
							case 4://first
								if(g.getCritterWave().getCritterInField().get(i).getCompletion()>g.getCritterWave().getCritterInField().get(targetcandidate).getCompletion()){
									targetcandidate=i;						
								}
							break;
							case 5://last 
								if(g.getCritterWave().getCritterInField().get(i).getCompletion()<g.getCritterWave().getCritterInField().get(targetcandidate).getCompletion()){
									targetcandidate=i;						
								}
							break;
						}				
					}			
			}
		}}
		
		if(targetcandidate != -1){System.out.println("targeting: "+targetcandidate+" distance of x "+(g.getCritterWave().getCritterInField().get(targetcandidate).getPosX())+" at "+screenx+" "+screeny);}
		return targetcandidate;//returns coordinates of the target
		}
	
	
	public boolean firesequence() {  //things it does when it fires
		int target = targeting();  //assings the target
		if (target == -1) {  //if no valid targets, firesequence fails
			return false;
		} else{
			g.getCritterWave().getCritterInField().get(target).updateHealth(shotpower);//if there is a target, shoot it
			//System.out.println("--shot"+target);
			return true;
		}
	}
	
	public boolean upgrade(){
		System.out.println("upgrade?money?"+g.getMoney()+"already upgrade?"+upgraded);
		boolean success=false;
		boolean allowable = false;//check the cost, depending on the type of tower
		if ((this.isTowerFast()) && ((int)((0.5)*(TowerFast.cost)))<= g.getMoney()){allowable=true;}
		if ((this.isTowerSniper()) && ((int)((0.5)*(TowerSniper.cost)))<= g.getMoney()){allowable=true;}
		if ((this.isTowerStrong()) && ((int)((0.5)*(TowerStrong.cost)))<= g.getMoney()){allowable=true;}
		if (allowable){
			switch(upgraded){
			case 0://level 1 increase range
				range +=1;
				success =  true;
				break;
			case 1://level 2 increase damage
				shotpower += 1;
				success =  true;
				break;
			case 2://maxfor now
				//cooldown -= 1;
				//if(cooldown<1){cooldown = 1;}
				success =  false;
				break;
			//case 3:
				//success =  false;
				//break;
			}
		}
		if (success){
			upgraded += 1;
			System.out.println("###UPGRADE");
			if (this.isTowerFast()){g.addMoney((int)((-0.5)*(TowerFast.cost)));}
			if (this.isTowerStrong()){g.addMoney((int)((-0.5)*(TowerStrong.cost)));}
			if (this.isTowerSniper()){g.addMoney((int)((-0.5)*(TowerSniper.cost)));}
		}
		return success;
	}
	
	public int getTargetingStrategy(){//getter tagetingstrategr
		return targetingstrategy;
	}
	
	public void setTargetingStrategy(int n){//setter tagetingstrategr
		if ((n >= 0)&&(n <= 5)){
			targetingstrategy = n;
			System.out.println("###changed strategy");
			
		}
	}
	
	public int getX(){//getter screenx
		return screenx;
	}
	
	public int getY(){//getter screeny
		return screeny;
	}
	public int getCost(){//getter of cost
		return cost;
	}
	
	
	public boolean isTowerSniper(){
		if(this instanceof TowerSniper){
			return true;
		}
		else
			return false;
	}
	
	public boolean isTowerStrong(){
		if(this instanceof TowerStrong){
			return true;
		}
		else
			return false;
	}
	
	public boolean isTowerFast(){
		if(this instanceof TowerFast){
			return true;
		}
		else
			return false;
	}

	public int getUpgraded() {//getter upgraded
		return upgraded;
	}
	
}