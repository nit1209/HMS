package generic_execution;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gen_UpdatePatientDetails {
	public static void main(String[] args) throws Throwable
	{
		//create object 
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		String URL = flib.readDataFromPropertyFile("hms_url");
		String USERNAME=flib.readDataFromPropertyFile("hms_tdoc_un");
		String PASSWORD=flib.readDataFromPropertyFile("hms_tdoc_pwd");

		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		int ran = jlib.random();
		ran=ran*ran;

		//login as doctor
		wlib.WaitForPageLoad(d);
		d.get(URL);
		d.manage().window().maximize();
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		d.findElement(By.name("password")).sendKeys(PASSWORD);
		d.findElement(By.xpath("//button[@type='submit']")).click();

		//search patient
		String pname="chandu";
		d.findElement(By.xpath("//span[.=' Search ']")).click();
		d.findElement(By.id("searchdata")).sendKeys(pname);
		d.findElement(By.xpath("//button[@type='submit']")).click();

		String val=d.findElement(By.xpath("//td[.='"+pname+"']")).getText();

		if(val.equals(pname))
		{
			d.findElement(By.xpath("//i[@class='fa fa-edit']")).click();
		}
		else
		{
			System.out.println("patient not exist script failed");
			d.quit();
		}

		//update patient details
		String mh="he is near to reach god say him best of luck";
		d.findElement(By.name("patage")).clear();
		d.findElement(By.name("patage")).sendKeys("55");
		d.findElement(By.name("medhis")).clear();
		d.findElement(By.name("medhis")).sendKeys(mh);
		d.findElement(By.name("submit")).click();

		//log out doc
		d.findElement(By.xpath("//span[@class='username']")).click();
		d.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();

		//login as admin
		d.findElement(By.xpath("//h3[.='Admin Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys("admin");
		d.findElement(By.name("password")).sendKeys("Test@12345");
		d.findElement(By.name("submit")).click();

		//search patient
		d.findElement(By.xpath("//span[.=' Patient Search ']")).click();
		d.findElement(By.name("searchdata")).sendKeys(pname);
		d.findElement(By.id("submit")).click();

		//script validate
		d.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		String vmh=d.findElement(By.xpath("//td[.='"+mh+"']")).getText();

		if(mh.equals(vmh))
		{
			System.out.println("SCRIPT PASS");
		}
		else
		{
			System.out.println("SCRIPT FAIL");
		}
		d.quit();

	}
}
