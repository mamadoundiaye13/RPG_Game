public class Hat implements Item{
	private String name;
	private int defencePoints;
	
	public Hat(int defencePoints,String name){
		this.defencePoints = defencePoints;
		this.name = name;
	}
	public Hat() {}
		
	public String getName() {
		return this.name;
	}

	public void put(Player player) {
		player.getStats().addDefence(defencePoints);
	}

	public void remove(Player player) {
			
		player.getStats().removeDefence(defencePoints);
	}

	public int getDefencePoints() {
		return defencePoints;
	}

	public void setDefencePoints(int defencePoints) {
		this.defencePoints = defencePoints;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
