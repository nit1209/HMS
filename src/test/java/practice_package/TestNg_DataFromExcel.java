package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtility.IpathConstants;

public class TestNg_DataFromExcel 
{
	@DataProvider
	public Object[][] data() throws Throwable
	{
		//connect to excel
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DB");
		int lastrownum = sh.getLastRowNum()+1;
		int lastcellnum = sh.getRow(0).getLastCellNum();

		//create object array to store excel data in it
		Object[][] obj = new Object[lastrownum][lastcellnum];

		//write loop for storing data in obj array
		for (int i=0; i<lastrownum; i++)		//rows
		{
			for(int j=0; j<lastcellnum; j++)	//Columns
			{
				obj[i][j]=sh.getRow(i).getCell(i).getStringCellValue();

			}
		}
		return obj;


	}

}
