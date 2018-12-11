public class ActionDamage implements Reaction{
	private int damagePoint;
	
	public ActionDamage() {
		// TODO Auto-generated constructor stub
	}
	
	public ActionDamage(int damagePoint) {
		
		this.damagePoint = damagePoint;
	}
	
	public ReactionType getTypeReaction() {
		return ReactionType.Damage;
	}

	public String getTextOfReaction() {
		return "Player takes damage";
	}

	public void action(Player player) {
		player.takeDamage(damagePoint);
	}
}
