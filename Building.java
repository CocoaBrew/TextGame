package textGame;

import java.util.ArrayList;

public class Building
{
	private String buildName;
	private ArrayList<Room> roomList;
	
	public Building(String name)
	{
		buildName = name.trim();
		roomList = new ArrayList<>();
	}
	
	public void addRoom(Room newRoom)
	{
		roomList.add(newRoom);
	}
	
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
	}
	
	public void entry()
	{
		System.out.print("You are standing in the entryway of " + buildName + ". "
				+ buildName + " has these rooms: ");
		this.listRooms();
		System.out.println(".");
	}
}
