package practice_package;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class TS_03 extends BaseClass {
	@Test(groups = "regression")
	public void script_05()
	{
		System.out.println("--Test-script-05 is Executed--");
		
	}
	
	@Test
	public void script_06()
	{
		System.out.println("--Test-script-06 is Executed--");
		
	}
}
