package textGame;

public class ShortAnswerQ extends Question
{
	private String question;
	private String answer;
	
	public ShortAnswerQ(String q, String ans)
	{
		question = q;
		answer = ans;
	}
	
	public String getQ()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}

	////////////
	public void displayAnswers() {
	}
}
