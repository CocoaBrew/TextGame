package textGame;

import java.util.ArrayList;

public abstract class Site 
{
	public abstract void listContents();
	
	public abstract void listExits();
	
	public abstract void entry();
	
	public abstract String getName();
	
	public abstract ArrayList<Person> getPeopleInRoom();
	
	public abstract Person getPersonInRoom(String name);
	
	public abstract ArrayList<Item> getItemsInRoom();
	
	public abstract Item getItemInRoom(String part2);
	
	public abstract void removeItem(Item thing);
}
