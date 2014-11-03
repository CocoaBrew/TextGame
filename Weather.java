package textGame;

public class Weather 
{
	private final String[] PRECIP_TYPE = 
		{"clear", "raining", "snowing"};
	private final String[] SUN_TYPE = 
		{"sunny", "partly sunny", "cloudy"};
	private int temp;
	private String precip;
	private String sun;
	private final int TEMP_RANGE = 140;
	private final int MIN_TEMP = -30;
	private final int CHOICES = 3;
	
	public Weather()
	{
		temp = (int) (Math.random() * TEMP_RANGE) + MIN_TEMP;
		precip = PRECIP_TYPE[(int) Math.ceil(Math.random() * CHOICES)];
		sun = SUN_TYPE[(int) Math.ceil(Math.random() * CHOICES)];
	}
	
	public void print()
	{
		System.out.println("It is currently " + temp + " degrees, "
				+ sun + ", and " + precip + ".");
	}
}
