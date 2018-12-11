public class Dress implements Item{

	private String name ;
	private int lifePoints;
	private int defencePoints;
	
	
	public Dress() {}
	
	
	public Dress(int lifePoints, int defencePoints, String name){
		this.defencePoints = defencePoints;
		this.lifePoints = lifePoints;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
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

	public void put(Player player) {
		player.getHealthBar().addMaxPoint(this.lifePoints);
		player.getStats().addDefence(defencePoints);
	}

	public void remove(Player player) {
		
		player.getHealthBar().removeMaxPoint(this.lifePoints);
		player.getStats().removeDefence(this.defencePoints);
		
	}

}
