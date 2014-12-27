package textGame;

import java.util.Scanner;

public class Faculty implements Person
{
	private String name;
	private Question question;
	private Player player;
	private boolean hasLetter = true;
	
	public Faculty(String n, Question q, Player playerArg)
	{
		name = n;
		question = q;
		player = playerArg;
	}
	
	public void speak()
	{
		System.out.println(question.getQ());
		question.displayAnswers();
		if (this.checkAnswer())
		{
			if (this.name.equals("Paino"))
			{
				System.out.println("Here is your diploma.");
				Game.setGameOver(true);
			}
			else
			{
				if (hasLetter == true)
				{
					System.out.println("That is correct! Here is a letter of recommendation.");
					this.giveRecLetter();
					hasLetter = false;
				}
				else
				{
					System.out.println("I appreciate you taking time to answer my question again");
					System.out.println("but I can't really give you another letter of recommendation.");
				}
			}
		}
	}
	
	private boolean checkAnswer()
	{
		Scanner in = new Scanner(System.in);
		String answer;
		
		boolean isCorrect = false;
		while (isCorrect == false)
		{
			answer = in.nextLine().trim().toLowerCase();
			if (answer.equals(question.getAnswer()))
			{
				isCorrect = true;
				player.incCorrectTotal();
			}
			else
			{
				System.out.println("Not quite. Try again.");
			}
			
			player.incTotalQuestions();
		}
		return isCorrect;
	}
	
	private void giveRecLetter()
	{
		PortableItem recLetter = new PortableItem("RecLetter","The letter reads: "
			+ "This student is great! 10/10 would teach again.");
		player.addItem(recLetter);
		player.incRecLetter();
		System.out.println("You now have " + player.getRecLetters() + 
			" letter(s) of recommendation.");
	}
	
	public String getName()
	{
		return name;
	}
}
