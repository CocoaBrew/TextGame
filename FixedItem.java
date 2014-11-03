package textGame;

public class FixedItem implements Item
{
	private String itemName;
	
	public FixedItem(String name)
	{
		itemName = name.trim();
	}
	
	public String getName()
	{
		return itemName;
	}
}
