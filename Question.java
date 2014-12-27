package textGame;

public abstract class Question 
{
	private String question;
	
	public abstract String getQ();
	public abstract String getAnswer();
	public abstract void displayAnswers();
}
