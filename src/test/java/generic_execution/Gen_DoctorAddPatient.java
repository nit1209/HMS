package generic_execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gen_DoctorAddPatient {
	public static void main(String[] args) throws Throwable 
	{
		//create objects
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String  URL=flib.readDataFromPropertyFile("hms_url");
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		int rn=jlib.random();
		rn = 2*(rn*rn);
		
		//login as doctor
		wlib.WaitForPageLoad(d);
		d.get(URL);
		wlib.maximizeWindow(d);
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("test@demo.com");
		d.findElement(By.name("password")).sendKeys("Test@123");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		
		//make the mouse hover for drop down menu
		WebElement btn = d.findElement(By.xpath("//span[.=' Patients ']"));
		wlib.mousehover(d, btn);
			
		//select add patient and add details
		String pn="chandu"+rn;
		d.findElement(By.xpath("//span[contains(.,' Add Patient')]")).click();
		d.findElement(By.name("patname")).sendKeys(pn);
		d.findElement(By.name("patcontact")).sendKeys("1234567890");
		d.findElement(By.id("patemail")).sendKeys(pn+"@c.com");
		d.findElement(By.xpath("//label[@for='rg-male']")).click();
		d.findElement(By.name("pataddress")).sendKeys("jalahalli,bnglr");
		d.findElement(By.name("patage")).sendKeys("54");
		d.findElement(By.name("medhis")).sendKeys("got fever");
		d.findElement(By.id("submit")).click();
		
		Thread.sleep(2000);
		
		//re-initialize the mouse action (cuz page is refreshed after adding patient)
		btn = d.findElement(By.xpath("//span[.=' Patients ']"));
		wlib.mousehover(d, btn);
		d.findElement(By.xpath("//span[.=' Manage Patient ']")).click();
		
		//validate
		String actual=d.findElement(By.xpath("//td[.='"+pn+"']")).getText();
			
		if(pn.equals(actual))
		{
			System.out.println("SCRIPT IS PASSED");
		}
		else
		{
			System.out.println("SCRIPT IS FALIED");
		}
		d.quit();
	}
}
