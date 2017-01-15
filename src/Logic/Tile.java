package Logic;


public abstract class Tile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pos;
	
	public int getPos(){
		return pos;
	}
	public void setPos(int pos){
		this.pos=pos;
	}
	
	/*
	 * Method that returns the Row coordinate of a Tile
	 */
	public int getRow(){
		return (pos/Map.getWidth());
	}
	public int getRow(int n){
		return (n/Map.getWidth());
	}
	

	/*
	 * Method that returns the Col coordinate of the Tile 
	 */
	public int getCol(){
		return pos%(Map.getWidth());
	}
	public int getCol(int n){
		return n%(Map.getWidth());
	}
	
	
	public boolean isPath(){
		if (this instanceof Path)
			return true;
		else
			return false;
	}
	
	public boolean isScenery(){
		if (this instanceof Scenery)
			return true;
		else
			return false;
	}
}
