public class Position {
	private int x;
	private int y;
	private String currentMap;
	
	public Position(int x, int y,String currentMap){
		this.x = x;
		this.y = y;
		this.currentMap = currentMap;
	}
	
	

	public String getCurrentMap() {
		return currentMap;
	}

	public void setCurrentMap(String currentMap) {
		this.currentMap = currentMap;
	}

	

	public void setX(int x) {
		this.x = x;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
}
