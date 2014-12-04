package textGame;

public class Weather 
{
	private final String[] PRECIP_TYPE = 
		{"clear", "raining", "snowing", "hailing", "sleeting"};
	private final String[] SUN_TYPE = 
		{"partly cloudy", "partly sunny", "cloudy"};
	private int temp;
	private String precip;
	private String sun;
	private final int TEMP_RANGE = 140;
	private final int MIN_TEMP = -30;
	private final int SUN_CHOICES = 3;
	private final int PRECIP_CHOICES = 5;
	
	public Weather()
	{
		temp = (int) (Math.random() * TEMP_RANGE) + MIN_TEMP;
		precip = PRECIP_TYPE[(int) Math.ceil(Math.random() * PRECIP_CHOICES)];
		sun = SUN_TYPE[(int) Math.ceil(Math.random() * SUN_CHOICES)];
	}
	
	public void print()
	{
		System.out.println("It is currently " + temp + " degrees, "
				+ sun + ", " + precip + ", " + "and very windy.");
	}
}
