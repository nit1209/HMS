package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelUtility;

public class TestNg_gen_fecthformExcel
{

	@Test(dataProvider = "data")
	public void getdatafromexcel(String src,String dst,String loc)
	{
		System.out.println("from--> "+src+"to--> "+dst+" "+loc);
		
	}
	
	
	
	@DataProvider
	public Object[][] data() throws Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		Object[][] value = elib.readsetofdata("DB");
		return value;
		
		
		
		
		
	}
	
}
