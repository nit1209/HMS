package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * this is used to read the excel data and get the last row number 
	 * @param Sheetname
	 * @param RowNo
	 * @param ColounNo
	 * @return
	 * @throws Throwable
	 * @author NPM
	 */

	public String readdataFromExcel(String Sheetname,int RowNo,int ColounNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		String value = sh.getRow(RowNo).getCell(ColounNo).getStringCellValue();
		return value;

	}

	public int getLastRowNo(String Sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		return count;
	}

	public HashMap<String,String> readmultipledata(String Sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();

		HashMap<String, String> Map = new HashMap<String,String>();
		for(int i=0;i<count;i++)
		{
			String key= sh.getRow(i).createCell(0).getStringCellValue();
			String value = sh.getRow(i).createCell(1).getStringCellValue();
			Map.put(key, value);
		}
		return Map;
	}

	/*public void writemultipledata(String Sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheetname");
		String v = sh.getRow(1).getCell(0).getStringCellValue();
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);	 

	}*/
	
	public Object[][] readsetofdata(String name) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(name);
		int lastrownum = sh.getLastRowNum()+1;
		int lastcellnum = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object [lastrownum][lastcellnum];
		
		for(int i=0; i<lastrownum; i++)
		{
			for (int j = 0; j < lastcellnum; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
		
		
		
	}
	
	
	
	
}

