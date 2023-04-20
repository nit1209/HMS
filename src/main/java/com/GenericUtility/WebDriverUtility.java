package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility 
{
	/**
	 * 
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */

	public String readdataFromExcel (String SheetName, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath); 
		Workbook wb = WorkbookFactory.create(fi); 
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
		return value;
	}

	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getlastRowNum(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}

	/**
	 * 
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 */
	
	public void WriteDataIntoExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable {

		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		sh.getRow(RowNo).getCell(ColumnNo).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
	}

	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	
	public HashMap<String,String> ReadMultipleData(String SheetName) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count =sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<count; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key,value);	
		}
		return map;
	}	

	/**
	 * 
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();

	}
	/**
	 * 
	 * @param driver
	 */
	
	public void WaitForPageLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void ElementToBeVisible(WebDriver driver,WebElement element) {

		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param element
	 * @param value
	 */
	
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index ) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText); 
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void mousehover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	public void DragAndDrop(WebDriver driver,WebElement scr,WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(scr, dst);
	}

	public void DoubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	public void RightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	public void RightClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void enterKeyPress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void EnterKey(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	public void EnterRelease(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public void SwitchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}


	public void SwitchtoFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void SwitchtoFrame(WebDriver driver,WebElement address) {
		driver.switchTo().frame(address);
	}

	public void AcceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void CancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void SwitchToWindow(WebDriver driver,String partialTitle) {

		//Step-1: use getWindowhandles to capture all window id's
		Set<String> windows = driver.getWindowHandles();

		//Step-2: iterate through the windows
		Iterator<String> it = windows.iterator();

		//Step-3: check whether there is next window
		while(it.hasNext())
		{
			//Step-4: capture current window id
			String winId = it.next();

			//Step-5: Switch to current window and capture title
			String CurrentWinTitle = driver.switchTo().window(winId).getTitle();

			//Step-6: check the current window is expected
			if(CurrentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}

	public static String getScreenShot(WebDriver driver ,String screenshotname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenshotname+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;

	}

	public void ScrollBarAction(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");

	}

	public void ScrollAction(WebDriver driver, WebElement element ) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window .scrollBy(0,"+y+")", element);
		jse.executeScript("argument[0].scrollIntoView()", element);
	}

}
























