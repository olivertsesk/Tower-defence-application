package Logic;



public class Player {

	private int health;
	private int money;
	
	public Player(int health,int money){
		this.money = money;
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
