package practice_package;

import org.testng.annotations.Test;

public class TestNg_FetchDataExcel {

	@Test(dataProviderClass =TestNg_DataFromExcel.class,dataProvider = "data" )
	public void getExceldata(String src,String dst,String loc)
	{
		System.out.println("from..->"+src+" "+"to..->"+dst+" "+loc);
	}
	
}
