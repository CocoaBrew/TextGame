package textGame;

import java.util.ArrayList;

public class Room extends Site
{
	private String roomName;
	private ArrayList<Item> stuff;
	private ArrayList<Site> exits;
	
	public Room(String name)
	{
		roomName = name.trim();
		stuff = new ArrayList<>();
		exits = new ArrayList<>();
	}
	
	public void entry()
	{
		System.out.println("This is the " + roomName + ". ");
		this.listContents();
		System.out.println(".");
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
		for (int i = 0; i < stuff.size(); i++)
		{
			System.out.print(stuff.get(i).getName());
			if (i < stuff.size() - 1)
			{
				System.out.print(", ");
			}
		}
		
		System.out.println();
	}
	
	public void removeItem(PortableItem thing)
	{
		stuff.remove(thing);
	}
	
	public String getName()
	{
		return roomName;
	}
}
