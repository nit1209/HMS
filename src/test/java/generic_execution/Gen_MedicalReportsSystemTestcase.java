package generic_execution;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gen_MedicalReportsSystemTestcase
{
	public static void main(String[] args) throws Throwable 
	{
		//create object for Generic Library
		DatabaseUtility dlib = new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		//browser setup
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		int rn = jlib.random();
		int mn = 942342+rn;
		int pwd = 851+rn;
		String URL = flib.readDataFromPropertyFile("hms_url");
		String Ad_Username = flib.readDataFromPropertyFile("hms_ad_un");
		String Ad_Password = flib.readDataFromPropertyFile("hms_ad_pwd");
		
		//admin login
		d.get(URL);
		wlib.maximizeWindow(d);
		wlib.WaitForPageLoad(d);
		d.findElement(By.xpath("//h3[.='Admin Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys(Ad_Username);
		d.findElement(By.name("password")).sendKeys(Ad_Password);
		d.findElement(By.name("submit")).click();

		//mouse hover action admin to doctor 
		WebElement btn = d.findElement(By.xpath("//span[.=' Doctors ']"));
		wlib.mousehover(d, btn);
		

		//add specialization
		d.findElement(By.xpath("//span[.=' Doctor Specialization ']")).click();
		Thread.sleep(2000);
		d.findElement(By.name("doctorspecilization")).sendKeys("mental");
		d.findElement(By.name("submit")).click();

		//mouse hover
		btn = d.findElement(By.xpath("//span[.=' Doctors ']"));
		wlib.mousehover(d, btn);
		d.findElement(By.xpath("//span[.=' Add Doctor']")).click();


		//create select class for drop down menu selection
		d.findElement(By.name("Doctorspecialization")).click();
		WebElement clk = d.findElement(By.name("Doctorspecialization"));
		wlib.select(clk, "mental");

		//add doctor details
		String dn="ramu"+rn;
		String add="bnglr hebbal"+rn;
		String tempmail=dn+rn+"@gmail.com";
		String temppwd="9854"+pwd;
		
		d.findElement(By.name("docname")).sendKeys(dn);
		d.findElement(By.name("clinicaddress")).sendKeys(add);
		d.findElement(By.name("docfees")).sendKeys("500");
		d.findElement(By.name("doccontact")).sendKeys("9"+mn);
		d.findElement(By.id("docemail")).sendKeys(tempmail);
		d.findElement(By.name("npass")).sendKeys(temppwd);	
		d.findElement(By.name("cfpass")).sendKeys(temppwd);
		d.findElement(By.id("submit")).click();

		//handle alert pop up 
		wlib.AcceptAlert(d);


		//logout as admin
		d.findElement(By.xpath("//span[@class='username']")).click();
		d.findElement(By.xpath("//span[@class='username']/following::a[contains(.,'Log Out')]")).click();

		//create patient
		String pn="chandu"+rn;
		String padd= "kalaburagi"+rn;
		String pcity="kalaburagi";
		String pmail=pn+rn+"@gmail.com";
		String ppwd="964534"+pwd;

		d.get(URL);
		Thread.sleep(2000);
		d.findElement(By.xpath("//h3[.='Patients']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//a[contains(.,'Create an account')]")).click();

		d.findElement(By.name("full_name")).sendKeys(pn);
		d.findElement(By.name("address")).sendKeys(padd);
		d.findElement(By.name("city")).sendKeys(pcity);
		d.findElement(By.xpath("//label[@for='rg-male']")).click();
		d.findElement(By.id("email")).sendKeys(pmail);
		d.findElement(By.id("password")).sendKeys(ppwd);
		d.findElement(By.id("password_again")).sendKeys(ppwd);
		d.findElement(By.id("submit")).click();

		System.out.println("Patient creadential created successfully");
		System.out.println("patient mail id :- "+pmail);
		System.out.println("Patinet pwd:- "+ppwd);
		System.out.println("");
		wlib.AcceptAlert(d);

		//login as patient
		d.get(URL);
		Thread.sleep(2000);
		d.findElement(By.xpath("//h3[.='Patients']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys(pmail);
		d.findElement(By.name("password")).sendKeys(ppwd);
		d.findElement(By.name("submit")).click();

		//book appointment & reinitialize select class
		d.findElement(By.xpath("//span[.=' Book Appointment ']")).click();
		d.findElement(By.name("Doctorspecialization")).click();
		clk = d.findElement(By.name("Doctorspecialization"));
		wlib.select(clk, "mental");

		d.findElement(By.id("doctor")).click();
		clk=d.findElement(By.id("doctor"));
		wlib.select(dn, clk);
		d.findElement(By.name("appdate")).click();
		d.findElement(By.xpath("//td[.='23']")).click();
		d.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		wlib.AcceptAlert(d);

		//log out as patient
		d.findElement(By.xpath("//span[@class='username']")).click();
		d.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();

		//login as doctor
		System.out.println("doc maid id :- "+tempmail);
		System.out.println("doc pwd :- "+temppwd);
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys(tempmail);
		d.findElement(By.name("password")).sendKeys(temppwd);
		d.findElement(By.xpath("//button[@type='submit']")).click();

		//appointment history check
		d.findElement(By.xpath("//span[.=' Appointment History ']")).click();
		String pvalid = d.findElement(By.xpath("//td[.='mental']/preceding-sibling::td[.='"+pn+"']")).getText();


		if(pn.equals(pvalid))
		{
			d.findElement(By.xpath("//a[.='Cancel']")).click();
			d.switchTo().alert().accept();
		}
		else
		{
			System.out.println("failed to find cancle button/failed to click on ok failed script");
			d.quit();
		}

		//mouse hover action for doc to patient
		btn = d.findElement(By.xpath("//span[.=' Patients ']"));
		wlib.mousehover(d, btn);

		//logout as user
		d.findElement(By.xpath("//span[@class='username']")).click();
		d.findElement(By.xpath("//span[@class='username']/following::a[contains(.,'Log Out')]")).click();

		//login as patient
		d.get(URL);
		Thread.sleep(2000);
		d.findElement(By.xpath("//h3[.='Patients']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys(pmail);
		d.findElement(By.name("password")).sendKeys(ppwd);
		d.findElement(By.name("submit")).click();

		//look for patient appointment history
		Thread.sleep(1000);
		d.findElement(By.xpath("//span[.=' Appointment History ']")).click();
		String appcan = d.findElement(By.xpath("//td[.='"+dn+"']/following-sibling::td[.='mental']/following-sibling::td[contains(.,'Cancel by Doctor')]")).getText();
		String cancle="Cancel by Doctor";
		
		System.out.println("");
		
		if(cancle.equals(appcan))
		{
			System.out.println("SCRIPT IS PASSED");
		}
		else
		{
			System.out.println("SCRIPT IS FAIL");
		}
		d.close();
	}

}

	
	

