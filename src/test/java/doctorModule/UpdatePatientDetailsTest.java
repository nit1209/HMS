package doctorModule;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdatePatientDetailsTest {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		Random rn = new Random();
		int ran = rn.nextInt(100);
		
		//login 
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		d.manage().window().maximize();
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("test@demo.com");
		d.findElement(By.name("password")).sendKeys("Test@123");
		d.findElement(By.xpath("//button[@type='submit']")).click();

		//search patient
		String pname="chandu268";
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
		
		//sign out doc
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
		String vmh=d.findElement(By.xpath("//td[.='he is near to reach god say him best of luck']")).getText();
		
		if(mh.equals(vmh))
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
