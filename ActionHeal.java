public class ActionHeal implements Reaction{
	
	private int healPoint;
	
	public ActionHeal() {
		// TODO Auto-generated constructor stub
	}
	
	public ActionHeal(int healPoint) {
		this.healPoint = healPoint;
	}
	
	public ReactionType getTypeReaction() {
		return ReactionType.Heal;
	}

	public String getTextOfReaction() {

		return "Player gets health";
	}

	public void action(Player player) {
		player.heal(healPoint);
		
	}

	

}
