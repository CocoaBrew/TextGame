package textGame;

public class TrueFalseQ extends Question
{
	private String question;
	private boolean answer;
	
	public TrueFalseQ(String q, boolean ans)
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
		return ("" + answer);
	}

	////////////////////
	public void displayAnswers() {
		
	}
}
