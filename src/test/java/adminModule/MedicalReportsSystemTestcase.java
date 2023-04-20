package adminModule;

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

public class MedicalReportsSystemTestcase {

	public static void main(String[] args) throws Throwable 
	{
		//create object 
		DatabaseUtility dlib = new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		Random ran = new Random();
		int rn = ran.nextInt(500);
		int mn = ran.nextInt(999999999);
		int pwd = ran.nextInt(999999);

		//admin login
		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.xpath("//h3[.='Admin Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys("admin");
		d.findElement(By.name("password")).sendKeys("Test@12345");
		d.findElement(By.name("submit")).click();

		//mouse hover action admin to doctor 
		WebElement btn = d.findElement(By.xpath("//span[.=' Doctors ']"));
		Actions a=new Actions(d);
		a.moveToElement(btn).click().perform();

		//add specialization
		d.findElement(By.xpath("//span[.=' Doctor Specialization ']")).click();
		Thread.sleep(2000);
		d.findElement(By.name("doctorspecilization")).sendKeys("mental");
		d.findElement(By.name("submit")).click();

		//mouse hovar
		btn = d.findElement(By.xpath("//span[.=' Doctors ']"));
		a.moveToElement(btn).click().perform();
		d.findElement(By.xpath("//span[.=' Add Doctor']")).click();


		//create select class for drop down menu selection
		d.findElement(By.name("Doctorspecialization")).click();
		WebElement clk = d.findElement(By.name("Doctorspecialization"));
		Select s = new Select(clk);
		s.selectByVisibleText("mental");

		//add doctor details
		String dn="ramu"+rn;
		String add="bnglr hebbal"+rn;
		String tempmail=dn+rn+"@gmail.com";
		String temppwd="9"+pwd;
		
		d.findElement(By.name("docname")).sendKeys(dn);
		d.findElement(By.name("clinicaddress")).sendKeys(add);
		d.findElement(By.name("docfees")).sendKeys("500");
		d.findElement(By.name("doccontact")).sendKeys("9"+mn);
		d.findElement(By.id("docemail")).sendKeys(tempmail);
		d.findElement(By.name("npass")).sendKeys(temppwd);	
		d.findElement(By.name("cfpass")).sendKeys(temppwd);
		d.findElement(By.id("submit")).click();

		//handle pop up with validation
		String pop = d.switchTo().alert().getText();
		String popmsg="Doctor info added Successfully";

		if(pop.equals(popmsg))
		{
			System.out.println("Doctor credential created Successfully");
		}
		d.switchTo().alert().accept();

		//logout as admin
		d.findElement(By.xpath("//span[@class='username']")).click();
		d.findElement(By.xpath("//span[@class='username']/following::a[contains(.,'Log Out')]")).click();

		//create patient
		String pn="chandu"+rn;
		String padd= "kalaburagi"+rn;
		String pcity="kalaburagi";
		String pmail=pn+rn+"@gmail.com";
		String ppwd="9"+pwd;

		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
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
		d.switchTo().alert().accept();

		//login as patient
		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		Thread.sleep(2000);
		d.findElement(By.xpath("//h3[.='Patients']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys(pmail);
		d.findElement(By.name("password")).sendKeys(ppwd);
		d.findElement(By.name("submit")).click();

		//book appointment & reinitialize select class
		d.findElement(By.xpath("//span[.=' Book Appointment ']")).click();
		d.findElement(By.name("Doctorspecialization")).click();
		clk = d.findElement(By.name("Doctorspecialization"));
		s = new Select(clk);
		s.selectByVisibleText("mental");

		d.findElement(By.id("doctor")).click();
		clk=d.findElement(By.id("doctor"));
		s = new Select(clk);
		s.selectByVisibleText(dn);
		d.findElement(By.name("appdate")).click();
		d.findElement(By.xpath("//td[.='23']")).click();
		d.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		d.switchTo().alert().accept();

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
		a=new Actions(d);
		a.moveToElement(btn).click().perform();

		//logout as user
		d.findElement(By.xpath("//span[@class='username']")).click();
		d.findElement(By.xpath("//span[@class='username']/following::a[contains(.,'Log Out')]")).click();

		//login as patient
		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
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
