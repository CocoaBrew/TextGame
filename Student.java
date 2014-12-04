package textGame;

public class Student implements Person
{
	private String info;
	
	public Student(String information)
	{
		info = information;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public void speak()
	{
		System.out.println(info);
	}
}
