package Practice;

import org.testng.annotations.Test;

public class sampletestNG {
	
	@Test(priority=2)
	
	public void createContact()
	{
		System.out.println("contact Created");
	}
	
	@Test(priority=1)
	public void modifyContact()
	{
		System.out.println(" modified contact");
	}
@Test(priority=3)
public void DeleteContact()
{
	System.out.println("Deleted Contact");
}
}
