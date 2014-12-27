package textGame;

import java.util.ArrayList;

/**
 * Provides a room-containing class that splits up campus. 
 * @author Sam Livingston and Dan Coleman
 * @version 12/4/14
 */
public class Building
{
	private String buildName;
	private ArrayList<Room> roomList = new ArrayList<>();
	
	/**
	 * Constructs a building.
	 * @param name Name of building.
	 */
	public Building(String name)
	{
		buildName = name.trim();
	}
	
	/**
	 * Adds a room to those that are in the building.
	 * @param newRoom The room to be added.
	 */
	public void addRoom(Room newRoom)
	{
		roomList.add(newRoom);
	}
	
	/**
	 * Returns a room in the building. 
	 * @param index Room's location in array of rooms.
	 * @return The room given at the index indicated.
	 */
	public Room getRoom(int index)
	{
		return roomList.get(index);
	}
	
	/**
	 * Prints out the names of the rooms in the building.
	 */
	public void listRooms()
	{
		for (Site room : roomList)
		{
			System.out.print(room.getName());
			if (room != roomList.get(roomList.size() - 1))
			{
				System.out.print(", ");
			}
		}
		
		System.out.println(".");
	}
	
	/**
	 * Runs entry sequence when entering a building.
	 * @param buildName The building to enter.
	 */
	public void entry(String buildName)
	{
		System.out.print("You are standing in the entryway of " + buildName + ". "
				+ buildName + " has these rooms: ");
		this.listRooms();
	}
	
	/**
	 * Returns name of building.
	 * @return Name of building.
	 */
	public String getName()
	{
		return buildName;
	}
	
	/**
	 * Return a list of rooms in the building.
	 * @return List of building's rooms.
	 */
	public ArrayList<Room> getRoomList()
	{
		return roomList;
	}
	
	/**
	 * Returns a room based on the room's name.
	 * @param part2 Typed command argument. 
	 * @return Room indicated.
	 */
	public Room getRoom(String part2) //Part 2 is assumed to be a name
	{
		for (Room r : roomList)
		{
			if (r.getName().equals(part2))
			{
				return r; //Return the item in the room
			}
		}
		return null; //If item wasnt in room return null
	}
	
}