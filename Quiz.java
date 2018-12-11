import java.util.*;

public class Quiz extends Game{
	
	private List<Question> listQuestion;
	Scanner sc = new Scanner(System.in);

	public Quiz(String name, Key keyCondition, Key keyReward, List<Question> listQuestion) {
		super(name, keyCondition, keyReward);
		this.listQuestion = listQuestion;
	}
	
	@Override
	public boolean play(Key k, String input) {
		
		String str[] = input.split(" ");
		
		if (!canPlay(k)) {
			System.out.println("Key required");
			return false;
		}
		System.out.println("Welcome to the quiz");
		
		int n = 0;
		for (Question question : listQuestion) {
			
			for (int i = 0; i < str.length; i++) {
				if (i == n) {
					
					System.out.println(question.getQuestion());
					System.out.println(question.getResponse1());
					System.out.println(question.getResponse2());
					System.out.println(question.getResponse3());
					System.out.println(question.getResponse4());
					
					if ((str[i].equals(question.getAnswer()))) {
						System.out.println("Correct");
					}
					else {
						System.out.println("Wrong");
						return false;
					}
				}
				
			}
			n++;
			
			
		}
		System.out.println("Win");
		return true;
	}

	@Override
	public boolean canPlay(Key k) {
		return k == getKeyCondition();
	}

	@Override
	public Key reward() {
		// TODO Auto-generated method stub
		return null;
	}

}
