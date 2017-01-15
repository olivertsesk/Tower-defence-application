package Logic;

public class CritterFactory {
	/**
	* Create a Critter with different characteristics 
	* @param type
	* @param ID
	* @return : the critter created 
	*/
	public static Critter makeCritter(CritterType type, int ID){
		Critter critter = new Critter(ID);
		
		switch (type){
		case SPEEDY:
			critter.setHealth(40);
			critter.setWaitingTime(1);
//			critter.setResistance(20);
			critter.setWorth();
			break;
		case HEALTHY:
			critter.setHealth(60);
			critter.setWaitingTime(5);
//			critter.setResistance(10);
			critter.setWorth();
			break;
		case RESISTANT:
			critter.setHealth(50);
			critter.setWaitingTime(3);
//			critter.setResistance(30);
			critter.setWorth();
			break;
		default:
			critter=null;
		}
		
		return critter;
	}
}
