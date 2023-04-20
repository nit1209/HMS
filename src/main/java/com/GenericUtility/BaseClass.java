package com.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_page.AdminDashBoardPage;
import pom_page.AdminLoginPage;
import pom_page.Homepage;


public class BaseClass 
{
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wlib =new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver edriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dlib.connectToDB_MY();
		System.out.println("-----connect to DB-----");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(/*String BROWSER*/) throws Throwable
	{
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String URL=flib.readDataFromPropertyFile("hms_url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		System.out.println("browser is launched");
		edriver=driver;
		wlib.maximizeWindow(driver);
		driver.get(URL);
		wlib.WaitForPageLoad(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
//		Homepage hp=new Homepage(driver);
//		hp.clickonAdmin();
//		String AUSERNAME=	flib.readDataFromPropertyFile("hms_ad_un");
//		String APASSWORD=flib.readDataFromPropertyFile("hms_ad_pwd");
//		AdminLoginPage alp=new AdminLoginPage(driver);
//		alp.AdminUN(AUSERNAME);
//		alp.AdminPWD(APASSWORD);
//		alp.Adminsumitbtn();
//		System.out.println("admin is logged in");
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
//		AdminDashBoardPage adp=new AdminDashBoardPage(driver);
//		adp.clickAdminusername();
//		adp.AdminLogout();
//		System.out.println("admin logged out");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		
		driver.quit();
		System.out.println("browser is closed");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		dlib.closeDB();
		System.out.println("database closed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
