package Logic;

public class PathFactory {

	
	public static Path makePath(PathType type, int pos){

		Path path = new Path(pos);
		switch(type){
		case straightNS:
			path.entry=path.getNorth();
			path.exit= path.getSouth();
			break;
		case straightWE:
			path.entry=path.getWest();
			path.exit=path.getEast();
			break;
		case turnEN:
			path.entry=path.getEast();
			path.exit=path.getNorth();
			break;
		case turnNW:
			path.entry=path.getNorth();
			path.exit= path.getWest();
			break;
		case turnSE:
			path.entry=path.getSouth();
			path.exit=path.getEast();
			break;
		case turnWS:
			path.entry=path.getWest();
			path.exit=path.getSouth();
			break;
		case noDirection:
			path=null;
		
		default:
			path=null;
		}
		return path;
	}

}
