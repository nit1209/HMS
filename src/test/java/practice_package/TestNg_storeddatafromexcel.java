package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.IpathConstants;

public class TestNg_storeddatafromexcel 
{
	@DataProvider
	public Object[][] data1() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DB1");
		int lastrownum = sh.getLastRowNum()+1;
		int lastcellnum = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrownum][lastcellnum];
		
		for(int i=0; i<lastrownum; i++)
		{
			for(int j=0; j<lastcellnum; j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	
	
	
	
	
	
	
	
}
