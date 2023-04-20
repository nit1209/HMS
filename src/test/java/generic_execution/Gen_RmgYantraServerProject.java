package generic_execution;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gen_RmgYantraServerProject {

	public static void main(String[] args) throws Throwable 
	{	
		
		DatabaseUtility dlib = new DatabaseUtility();

		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		//setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		//common data
		String URL = flib.readDataFromPropertyFile("ty_url");
		String USERNAME=flib.readDataFromPropertyFile("ty_un");
		String PASSWORD=flib.readDataFromPropertyFile("ty_pwd");
		d.get(URL);
		wlib.maximizeWindow(d);
		wlib.WaitForPageLoad(d);
		int rn = jlib.random();
		String pname="HMS"+rn;
		String mname="valmiki"+rn;


		//login page
		Thread.sleep(2000);
		d.findElement(By.name("username")).sendKeys(USERNAME);
		d.findElement(By.name("password")).sendKeys(PASSWORD);
		d.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[.='Projects']")).click();
		d.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		d.findElement(By.name("projectName")).sendKeys(pname);
		d.findElement(By.name("createdBy")).sendKeys(mname);

		//create select class  and add project

		WebElement btn = d.findElement(By.xpath("(//select[@name='status'])[2]"));
		wlib.select(btn, "On Going");
		d.findElement(By.xpath("//input[@value='Add Project']")).click();


		//read from database
		dlib.connectToDB_TY();
		String query="select * from project;";
		dlib.executeQueryAndGetData(query, pname, 4);
		dlib.closeDB();
		d.quit();


	}
}
