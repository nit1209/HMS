package adminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CD_TD_ForAdmin {

	public static void main(String[] args) throws Throwable 
	{
		//common data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties po = new Properties();
		po.load(fis);
		String URL= po.getProperty("url");
		String USERNAME=po.getProperty("username");
		String PASSWORD=po.getProperty("password");

		//test data
		FileInputStream FIS=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sh = wb.getSheet("sheet1");
		
		//browser setup
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		Random ran = new Random();
		int rn = ran.nextInt(300);
		int mn = ran.nextInt(888888888);
		int pwd = ran.nextInt(8888888);
		
		//log in as admin
		d.get(URL);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.xpath("//h3[.='Admin Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys(USERNAME);
		d.findElement(By.name("password")).sendKeys(PASSWORD);
		d.findElement(By.name("submit")).click();


		//mouse hover action admin to doctor 
		WebElement btn = d.findElement(By.xpath("//span[.=' Doctors ']"));
		Actions a=new Actions(d);
		a.moveToElement(btn).click().perform();

		//add specialization
		d.findElement(By.xpath("//span[.=' Doctor Specialization ']")).click();
		Thread.sleep(2000);
		d.findElement(By.name("doctorspecilization")).sendKeys("eye");
		d.findElement(By.name("submit")).click();

		//mouse hover 
		btn = d.findElement(By.xpath("//span[.=' Doctors ']"));
		a.moveToElement(btn).click().perform();
		d.findElement(By.xpath("//span[.=' Add Doctor']")).click();

		//create select class for drop down menu selection
		d.findElement(By.name("Doctorspecialization")).click();
		WebElement clk = d.findElement(By.name("Doctorspecialization"));
		Select s = new Select(clk);
		s.selectByVisibleText("eye");
		
		

		//fill doctor details
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<=sh.getLastRowNum(); i++)
		{
			String key= sh.getRow(i).getCell(0).getStringCellValue();
			String value= sh.getRow(i).getCell(1).getStringCellValue();
			String actual=sh.getRow(i).getCell(0).getStringCellValue();
			map.put(key, value);
			
		}
		
		/*for(Entry<String, String> set:map.entrySet())
		{
			d.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
			
		}*/


		
		d.findElement(By.name("docname")).sendKeys(map.get("docname"+rn));



	}

}
