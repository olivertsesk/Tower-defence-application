package Tests;
import Logic.*;

public class CritterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int critterType =0;//speedy
		CritterType type=getType(critterType);
		Critter critter1=CritterFactory.makeCritter(type, 0);
		
	//	critterType =2;//speedy
	//	type=getType(critterType);
	//	Critter critter2=CritterFactory.makeCritter(type, 1);
	
		//critter1.moveThroughPath();
//		while(!critter1.getPath().isEmpty()){
//			critter1.tick();
//			
//		}
	}

	public static CritterType getType(int type){
		switch(type){
		case 0:
			return CritterType.SPEEDY;
		case 1:
			return CritterType.HEALTHY;
		case 2:
			return CritterType.RESISTANT;
		default:
			return null;//error
		}
	}
	

}
