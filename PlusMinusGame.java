public class PlusMinusGame extends Game{

	private int findValue;
	
	public PlusMinusGame(String name, Key keyCondition, Key keyReward, int findValue) {
		super(name, keyCondition, keyReward);
		this.findValue = findValue;
	}

	@Override
	public boolean play(Key k, String input) {
		int tentatives = 0;
		String str[] = input.split(" ");
		
		if (!canPlay(k)) {
			System.out.println( "Key required" );
			return false;
		}
		
		while (tentatives < 10) {
			System.out.println( "Welcome to the " + getName()+ " game!" );
			
			for (String string : str) {
				if (this.findValue > Integer.parseInt(string)) {
					System.out.println("Plus");
					tentatives++;
				}
				else if (this.findValue < Integer.parseInt(string)) {
					System.out.println("Minus");
					tentatives++;
				}
				else if (this.findValue == Integer.parseInt(string)) {
					System.out.println( "win" );
					return true;
				}
			}
		}
			
		System.out.println( "Lose");
		return false;
}
		

	@Override
	public boolean canPlay(Key k) {
		return this.getKeyCondition() == k;
	}

	@Override
	public Key reward() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
