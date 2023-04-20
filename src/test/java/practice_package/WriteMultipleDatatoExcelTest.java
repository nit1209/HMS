package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDatatoExcelTest {

	
		public static void main(String[] args) throws Throwable {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("sheet1");
			
			int count=sh.getLastRowNum();
			
			for (int i = 1; i <= count; i++) 
			{
				wb.getSheet("sheet1").getRow(i).createCell(3).setCellValue("home");
	
			}
			FileOutputStream fos =new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
			wb.write(fos);
			wb.close();
			

	}

}
