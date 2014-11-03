package textGame;

public class PortableItem implements Item
{
	private String itemName;
	
	public PortableItem(String name)
	{
		itemName = name.trim();
	}
	
	public String getName()
	{
		return itemName;
	}
}
