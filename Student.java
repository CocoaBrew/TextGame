package textGame;

import java.util.ArrayList;

public class Student implements Person
{
	private ArrayList<Item> possessions;
	
	public Student()
	{
		possessions = new ArrayList<>();
	}
	
	public void takeItem(PortableItem thing)
	{
		possessions.add(thing);
	}
}
