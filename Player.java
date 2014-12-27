package textGame;

import java.util.ArrayList;

public class Player
{
	private ArrayList<Item> backpack = new ArrayList<>();
	private Site current;
	private Building currentBuilding;
	private int recLetters = 0; //Count of how many rec letters the player has.
	private boolean hasPamphlets = false;
	private int totalQuestions = 0;
	private int answersCorrect = 0;
	
	public Player(Room startRoom, Building startBuilding)
	{
		current = startRoom;
		currentBuilding = startBuilding;
	}
	
	public void addItem(Item thing)
	{
		if (hasPamphlets)
		{
			System.out.println("Your hands are full of pamphlets." +
				" You must drop them before you can take something else.");
		}
		else
		{
			backpack.add(thing);
		}
	}
	
	public void removeItem(String itemName)
	{
		if (backpack.contains(itemName))
		{
			for (Item i : backpack)
			{
				if (i.getName().equals(itemName))
				{
					backpack.remove(i); //Return the item in the room
				}
			}
		}
	}
	
	public void listItems()
	{
		for (Item i : backpack)
		{
			System.out.println(i.getName());
		}
	}
	
	public void speak(String name) //assumed to be the name of a person
	{
		ArrayList<Person> tempPeople = current.getPeopleInRoom();
		for (Person p : tempPeople)
		{
			if(p.getName().toLowerCase().equals(name))
			{
				p.speak();
			}
		}
	}
	
	public void incRecLetter()
	{
		recLetters++;
	}
	
	public void setLocation(Room here)
	{
		current = here;
	}
	
	public Building getCurrentBuilding()
	{
		return currentBuilding;
	}
	
	public void setBuilding(Building here)
	{
		currentBuilding = here;
	}
	
	public void setPamphlets(boolean value)
	{
		hasPamphlets = value;
	}
	
	public int getRecLetters()
	{
		return recLetters;
	}
	
	public int getBackPackSize()
	{
		return backpack.size();
	}
	
	public Site getCurrentRoom()
	{
		return current;
	}
	
	public void incCorrectTotal()
	{
		answersCorrect++;
	}
	
	public void incTotalQuestions()
	{
		totalQuestions++;
	}
	
	public int getCorrectTotal()
	{
		return answersCorrect;
	}
	
	public int getTotalQuestions()
	{
		return totalQuestions;
	}
	
	public int calcCoffee()
	{
		int numCoffees = 0;
		for (Item i : backpack)
		{
			if(i.getName().equals("coffee"))
			{
				numCoffees++;
			}
		}
		return numCoffees;
	}
}
