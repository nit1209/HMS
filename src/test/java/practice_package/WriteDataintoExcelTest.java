package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcelTest {

	public static void main(String[] args) throws Throwable
	{
		//create object for physical file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//get workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//get sheet
		Sheet sh = wb.getSheet("sheet1");
		
		//get row
		Row row = sh.getRow(4);
		
		//create cell
		Cell cel = row.createCell(0);
		
		cel.setCellValue("dharamshala");
		
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		wb.write(fos);
		wb.close();
		
		
		
		
		

	}

}
