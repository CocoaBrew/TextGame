package textGame;

/**
 * Stores info that is helpful for player. 
 * @author Sam Livingston and Dan Coleman
 * @version 12/4/14
 */
public class Student implements Person
{
	private String name;
	private String info;
	
	/**
	 * Constructs a student to display info.
	 * @param n Student's name.
	 * @param information What the student can say.
	 */
	public Student(String n, String information)
	{
		name = n;
		info = information;
	}
	
	/**
	 * Returns knowledge string.
	 * @return What the student can say.
	 */
	public String getInfo()
	{
		return info;
	}
	
	/**
	 * Causes student to display his useful info.
	 */
	public void speak()
	{
		System.out.println(info);
	}
	
	/**
	 * Returns student's name.
	 * @return Student's name.
	 */
	public String getName()
	{
		return name;
	}
}
