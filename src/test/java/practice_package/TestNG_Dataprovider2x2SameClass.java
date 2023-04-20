package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_Dataprovider2x2SameClass
{
	@Test(dataProvider = "data")
	public void getdata(String src,String dst)
	{
		System.out.println("from..->"+src+" "+"to..->"+dst);
	}

	@DataProvider
	public Object[][] data()
	{
		Object[][] obj =new Object[2][2];

		obj[0][0]="hebbal";
		obj[0][1]="testyantra";

		obj[1][0]="banashankari";
		obj[1][1]="jp nagar";


		return obj;

	}





}
