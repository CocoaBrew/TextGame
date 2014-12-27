package textGame;

public class MultiChoiceQ extends Question
{
	private String question;
	private String[] ansList = new String[3];
	private String answer;
	
	public MultiChoiceQ(String q, String[] ans, String optionNum)
	{
		question = q;
		ansList = ans;
		answer = optionNum;
	}
	
	public String getQ()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void displayAnswers()
	{
		for(String e : ansList)
		{
			System.out.println(e);
		}
	}
}
