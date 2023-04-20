package doctorModule;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoctorLoginTest {

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		Random ran = new Random();
		String expt="NaiduDoc123";

		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("test@demo.com");
		d.findElement(By.name("password")).sendKeys("Test@123");
		d.findElement(By.xpath("//button[@type='submit']")).click();

		String actual=d.findElement(By.xpath("//span[@class='username']")).getText();
		
		if(actual.equals(expt))
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
