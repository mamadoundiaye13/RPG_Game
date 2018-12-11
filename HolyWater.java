public class HolyWater implements Tangible {

	private int lifesToAdd;
	
	public HolyWater() {
		// TODO Auto-generated constructor stub
	}
	
	public HolyWater(int lifesToAdd) {
		this.lifesToAdd = lifesToAdd;
	}
	
	public char showAs() {
		return 'H';
	}

	public void action(Player player) {
		player.getHealthBar().addCurrentPoint(lifesToAdd);
		
	}

}
