package doctorModule;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoctorAddPatientTest {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		Random ran = new Random();
		int rn = ran.nextInt(500);
		
		//login as doctor
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		d.manage().window().maximize();
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("test@demo.com");
		d.findElement(By.name("password")).sendKeys("Test@123");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		
		//make the mouse hover for drop down menu
		WebElement btn = d.findElement(By.xpath("//span[.=' Patients ']"));
		Actions a=new Actions(d);
		a.moveToElement(btn).click().perform();
			
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
		a.moveToElement(btn).click().perform();
		d.findElement(By.xpath("//span[.=' Manage Patient ']")).click();
		
		//validate
		String actual=d.findElement(By.xpath("//td[.='"+pn+"']")).getText();
			
		if(pn.equals(actual))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		d.quit();
	}

}
