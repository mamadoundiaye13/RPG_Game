public abstract class Game {
	private String name;
	private Key keyCondition;
	private Key keyReward;
	
	
	public Game(String name, Key keyCondition, Key keyReward){
		this.keyCondition = keyCondition;
		this.keyReward = keyReward;
		this.name = name;
	}
	
	public abstract boolean play(Key k,String input);
	
	public abstract boolean canPlay(Key k);
	
	public abstract Key reward() ;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Key getKeyCondition() {
		return keyCondition;
	}
	public void setKeyCondition(Key keyCondition) {
		this.keyCondition = keyCondition;
	}
	public Key getKeyReward() {
		return keyReward;
	}
	public void setKeyReward(Key keyReward) {
		this.keyReward = keyReward;
	}
	
	
	
	
	
}
