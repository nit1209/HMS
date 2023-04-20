package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_Dataprovider3x3SameClass {

	@Test(dataProvider = "data")
	public void getdata(String src,String dst,String loc)
	{
		System.out.println("from..->"+src+" "+"to..->"+dst+" "+loc);
	}

	@DataProvider
	public Object[][] data()
	{
		Object[][] obj =new Object[3][3];

		obj[0][0]="hebbal";
		obj[0][1]="testyantra";
		obj[0][2]="kattarguppe";

		obj[1][0]="banashankari";
		obj[1][1]="jp nagar";
		obj[1][2]="TY";

		obj[2][0]="india";
		obj[2][1]="amarica";
		obj[2][2]="plane";
		return obj;

	}
}
