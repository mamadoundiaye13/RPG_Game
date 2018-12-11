public class Acid implements Tangible {
	private int damagePoint;
	
	public Acid(int damagePoint) {
		this.damagePoint = damagePoint;
	}
	
	public Acid() {
		// TODO Auto-generated constructor stub
	}
	
	public char showAs() {
		return 'A';
	}

	public void action(Player player) {
		player.getHealthBar().removeCurrentPoint(damagePoint);
		
	}

}
