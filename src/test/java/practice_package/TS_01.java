package practice_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class TS_01 extends BaseClass{

	@Test(retryAnalyzer = com.GenericUtility.IretryAnalyserImplementationClass.class)
	public void script_01()
	{
		System.out.println("--Test-script-01 is Executed--");
		Assert.fail();
		
	}
	

}
