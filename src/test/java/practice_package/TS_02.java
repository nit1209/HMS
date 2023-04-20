package practice_package;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class TS_02 extends BaseClass {
	@Test(groups = "smock")
	public void script_03()
	{
		System.out.println("--Test-script-03 is Executed--");
		
	}
	
	@Test(groups = {"smock","regression"})
	public void script_04()
	{
		System.out.println("--Test-script-04 is Executed--");
		
	}
}
