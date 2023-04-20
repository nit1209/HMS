package practice_package;

import org.testng.annotations.Test;

public class TestNg_DB_FetchingData 
{
	@Test(dataProviderClass = TestNg_DB_StoringData.class ,dataProvider = "data")
	public void getdata(String src,String dst,String loc)
	{
		System.out.println("from..->"+src+" "+"to..->"+dst+" "+loc);
	}
	
}
