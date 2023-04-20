package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AccessExcelFileMethodsTest {

	public static void main(String[] args) throws Throwable  {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Sheet1");
//		Row rw = sh.getRow(1);
//		Cell cel = rw.getCell(0);
//		int count= sh.getLastRowNum();
//		String val="chinnaswami";
//		for(int i=1; i<=count; i++)
//		{
//			String std = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
//			String org = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			
			
			
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		
		for (int i=0; i<sheets; i++)
		{
			XSSFSheet sheet = wb.getSheetAt(i);
			//access all the rows for the sheet
			Iterator<Row> rows=sheet.iterator();	//access all rows
			Row firstrow = rows.next();
			Iterator<Cell> cel=firstrow.cellIterator();
			int count=0;
			int column=0;
			while(cel.hasNext()) 
			{
				Cell value=cel.next();
//				if(value.getStringCellValue().equalsIgnoreCase("wankhade"))
//				{
//					column=count;
//				}
				System.out.println(value);
			}
//			count++;
			
			
		}
		
	}
	}




