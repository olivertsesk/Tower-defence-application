package Logic;

import java.util.*;

public class Subject {
	private List<IObserver> observers;
	
	public Subject(){
		observers = new ArrayList<IObserver>();
	}
	public void addObserver (IObserver o){
		observers.add(o);
	}
	public void removeObserver(IObserver o){
		observers.remove(o);
	}
	protected void notifyObservers(){
		for (IObserver o: observers){
			o.update();
		}
	}


}
