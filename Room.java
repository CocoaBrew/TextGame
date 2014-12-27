package textGame;

import java.util.ArrayList;

/**
 * Location in which user can interact with people and items.
 * @author Sam Livingston and Dan Coleman
 * @version 12/4/14
 */
public class Room extends Site
{
	private String roomName;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Site> exits = new ArrayList<>();
	private ArrayList<Person> peopleInRoom = new ArrayList<>();
	
	/**
	 * Constructs a room with the given name.
	 * @param name Room's name.
	 */
	public Room(String name)
	{
		roomName = name.trim();
	}
	
	/**
	 * Runs entry sequence when entering a room.
	 */
	public void entry()
	{
		
		System.out.println("This is the " + roomName + ". ");
		this.listContents();
	}
	
	/**
	 * Prints a list of the exits from a room.
	 */
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
		
		System.out.println(".");
	}
	
	/**
	 * Adds an exit to the list.
	 * @param area Exit to be added.
	 */
	public void setExit(Site area)
	{
		exits.add(area);
	}
	
	/**
	 * Adds an item to the items list in the room.
	 * @param thing Item to be added.
	 */
	public void addItems(Item thing)
	{
		items.add(thing);
	}
	
	/**
	 * Prints what's in the room.
	 */
	public void listContents()
	{
		System.out.print("You see: ");
		for (int i = 0; i < items.size(); i++)
		{
			System.out.print(items.get(i).getName());
			if (i < items.size() - 1)
			{
				System.out.print(", ");
			}
		}
		
		System.out.print(". You can talk to: ");
		for (int i = 0; i < peopleInRoom.size(); i++)
		{
			System.out.print(peopleInRoom.get(i).getName());
			if (i < peopleInRoom.size() - 1)
			{
				System.out.print(", ");
			}
		}
		
		System.out.println(".");
	}
	
	/**
	 * Takes an item out of the room.
	 * @param thing Item to remove.
	 */
	public void removeItem(Item thing)
	{
		items.remove(thing);
	}
	
	/**
	 * Returns room's name.
	 * @return Room's name.
	 */
	public String getName()
	{
		return roomName;
	}
	
	/**
	 * Puts a person in a room.
	 * @param entity Person to put in the room.
	 */
	public void addPerson(Person entity)
	{
		peopleInRoom.add(entity);
	}
	
	/**
	 * Returns list of people in a room.
	 * @return People in a room.
	 */
	public ArrayList<Person> getPeopleInRoom()
	{
		return peopleInRoom;
	}
	
	/**
	 * Gets person from parsed string.
	 * @param part2 Typed command argument.
	 * @return Person with parsed name.
	 */
	public Person getPersonInRoom(String part2) //Part 2 is assumed to be a name
	{
		for (Person p : peopleInRoom)
		{
			if (p.getName().equals(part2))
			{
				return p; //Return the person in the room
			}
		}
		return null; //If guy wasnt in room return null
	}
	
	/**
	 * Returns items located in the room.
	 */
	public ArrayList<Item> getItemsInRoom()
	{
		return items;
	}
	
	/**
	 * Returns an item based on parsed string input.
	 */
	public Item getItemInRoom(String part2) //Part 2 is assumed to be a name
	{
		for (Item i : items)
		{
			if (i.getName().equals(part2))
			{
				return i; //Return the item in the room
			}
		}
		return null; //If item wasnt in room return null
	}
}
