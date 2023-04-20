package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations 
{

	@BeforeSuite
	public void connectDB()
	{
		System.out.println("conncect to DB is done");
	}
	
	@AfterSuite
	public void dissconectDB()
	{
		System.out.println("DB is dissconted");
	}
	
	@BeforeTest
	public void openbrowser()
	{
		System.out.println("parallel execution");
	}
	
	
	@BeforeClass
	public void launchbrowser()
	{
		System.out.println("browser is launched");
	}
	
	@AfterClass
	public void closebrowser()
	{
		System.out.println("browser is closed");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("logged into the app is done ");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("logged out from the app");
	}
	
	@Test
	public void execute1()
	{
		System.out.println("script-1 is executed");
	}
	
	@Test
	public void execute2()
	{
		System.out.println("Script-2 is executed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
