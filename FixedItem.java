package textGame;

public class FixedItem implements Item
{
	private String itemName;
	private String itemDesc;
	
	public FixedItem(String name, String desc)
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
