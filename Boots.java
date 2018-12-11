public class Boots implements Item{

	private String name ;
	private int lifePoints;
	private int attackPoints;
	
	
	public Boots(int lifePoints, int attackPoints,String name){
		this.attackPoints = attackPoints;
		this.lifePoints = lifePoints;
		this.name = name;
	}
	
	public Boots(){}
	
	
	public String getName() {
		return this.name;
	}

	public void put(Player player) {
		
		player.getHealthBar().addMaxPoint(this.lifePoints);
		player.getStats().addAttack(attackPoints);
		
		
	}

	public void remove(Player player) {

		player.getHealthBar().removeMaxPoint(this.lifePoints);
		player.getStats().removeAttack(this.attackPoints);
		
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
