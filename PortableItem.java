package textGame;

public class PortableItem implements Item
{
	private String itemName;
	private String itemDesc;
	
	public PortableItem(String name, String desc)
	{
		itemName = name.trim();
		itemDesc = desc;
	}
	
	public String getName()
	{
		return itemName;
	}
	
	public String getDescription()
	{
		return itemDesc;
	}
}
