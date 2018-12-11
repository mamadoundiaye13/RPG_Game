public class GameRunner {
	private String input;
	private Key keyToPlay;
	
	public GameRunner(Key key,String input){
		this.keyToPlay = key;
		this.input = input;
	}
	
	public boolean playGame(Game game){
		
		return game.play(keyToPlay, input);
		
	}
}
