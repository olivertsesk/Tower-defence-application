package Presentation;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.*;

public class PlayerInfo extends JPanel implements IObserver{
	
	private int playerHealth;
	private int playerMoney;
	private Game myGame;
	private JLabel lPlayerHealth;
	private JLabel lPlayerMoney;
	
	public PlayerInfo(){
		myGame = Game.getInstance();
		this.playerMoney = myGame.getMoney();
		this.playerHealth = myGame.getLife();
		this.setLayout(new GridLayout(1,2));
		lPlayerHealth = new JLabel(String.valueOf(playerHealth));
		lPlayerMoney = new JLabel(String.valueOf(playerMoney));
		this.add(lPlayerHealth);
		this.add(lPlayerMoney);
		setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		lPlayerHealth.setText(String.valueOf(myGame.getLife()));
		lPlayerMoney.setText(String.valueOf(myGame.getMoney()));
	}
	
}
