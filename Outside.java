package textGame;

import java.util.ArrayList;

public class Outside extends Site
{
	private String pathName;
	private ArrayList<String> things;
	private ArrayList<Site> exits;
	private Weather weather;
	
	public Outside(String name)
	{
		pathName = name.trim();
		things = new ArrayList<>();
		exits = new ArrayList<>();
	}
	
	public void entry()
	{
		weather = new Weather();
		weather.print();
	}
	
	public void listExits()
	{
		for (Site place : exits)
		{
			System.out.print(place.getName());
			if (place != exits.get(exits.size() - 1))
			{
				System.out.print(", ");
			}
		}
	}
	
	public void setExit(Site area)
	{
		exits.add(area);
	}
	
	public void listContents()
	{
		System.out.print("You see: ");
		for (int i = 0; i < things.size(); i++)
		{
			System.out.print(things.get(i));
			if (i < things.size() - 1)
			{
				System.out.print(", ");
			}
		}
		
		System.out.println();
	}
	
	public String getName()
	{
		return pathName;
	}
}
