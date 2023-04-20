package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable 
	{
		//create object for physical file 
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//get workbook
		Workbook wb = WorkbookFactory.create(fi);
		
		//get sheet
		Sheet sh = wb.getSheet("sheet1");
		
		//get row
		Row row = sh.getRow(1);
		
		//get cell
		Cell cel = row.getCell(0);
		
		//get the value
		String value = cel.getStringCellValue();
		System.out.println(value);
		
		
		
		
		
	}

}
