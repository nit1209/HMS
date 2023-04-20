package practice_package;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNG_Feature_Practice {

	@Test(priority = -1)
	public void createCustomer()
	{
		
		System.out.println("............customer is created");
	}
	
	@Test(priority = 3)
	public void editcustomer()
	{
		
		System.out.println("............edition is done");
		//throw new SkipException("skip this exception");
	}
	
	@Test(priority = 1,dependsOnMethods = "editcustomer")
	public void deletecustomer()
	{
		System.out.println("............customer is deleted");
	}
	
	
	
	
	
	
}
