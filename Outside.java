package textGame;

import java.util.ArrayList;

public class Outside extends Site
{
	private String pathName;
	private ArrayList<Item> artifacts = new ArrayList<>();;
	private ArrayList<Site> exits = new ArrayList<>();
	private Weather weather;
	
	public Outside(String name)
	{
		pathName = name.trim();
	}
	
	public void entry()
	{
		System.out.println("You are now outside.");
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
		
		System.out.println();
	}
	
	public void setExit(Site area)
	{
		exits.add(area);
	}
	
	public void addArtifacts(Item thing)
	{
		artifacts.add(thing);
	}
	
	public void listContents()
	{
		System.out.print("You see: ");
		for (int i = 0; i < artifacts.size(); i++)
		{
			System.out.print(artifacts.get(i).getName());
			if (i < artifacts.size() - 1)
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

	///////////////////////////garbage below
	public ArrayList<Person> getPeopleInRoom() {
		return null;
	}

	public Person getPersonInRoom(String name) {
		return null;
	}

	public ArrayList<Item> getItemsInRoom() {
		return null;
	}

	public Item getItemInRoom(String part2) {
		return null;
	}
	
	public void removeItem(Item thing) {

	}
}
