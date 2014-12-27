package textGame;

import java.util.Scanner;

public class Pamphleteer implements Person
{
    private String name = "Annoying Pamphleteer";
    private PortableItem pamphlet = new PortableItem("pamphlet", "The pamphlet "
        + "reads: Santa's rebellion - Saturday 3PM - Free candy canes w/ "
        + "purchase of ElfCo War Bonds.");
	private Player player;
	private String[] options = {"yes", "no"};
	private MultiChoiceQ question = 
	    new MultiChoiceQ("Santa is real! His elves are in fact living among " 
               + "us as we speak. It is imperative that you understand what "
               + "safety measures are in place in the event that they rebel. "
               + "Can I give you an informative brochure? ", options, 
               "yes");

    public Pamphleteer(Player playerArg)
    {
        player = playerArg;
    }
     
    public void speak()
    {
		if (checkAnswer())
		{
		    System.out.println("Here you go!");
		    this.givePamphlet();
		}
		else
		{
		    System.out.println("Really? Well, you've been warned!");
		}
    }
    
    private boolean checkAnswer()
	{
		Scanner in = new Scanner(System.in);
		String answer = in.nextLine().trim().toLowerCase();

		boolean isCorrect = false;
		if (answer.equals(question.getAnswer()))
		{
			isCorrect = true;
		}

		return isCorrect;
	}
	
    private void givePamphlet()
    {
	     player.addItem(pamphlet);
	     player.setPamphlets(true);
    }
    
    public String getName()
    {
    	return name;
    }
}