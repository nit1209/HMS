package generic_execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.FileUtility;

import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gen_DoctorLoginTest {

	public static void main(String[] args) throws Throwable 
	{
		//create object 
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		
		String URL = flib.readDataFromPropertyFile("hms_url");
		String USERNAME=flib.readDataFromPropertyFile("hms_tdoc_un");
		String PASSWORD=flib.readDataFromPropertyFile("hms_tdoc_pwd");
	
		//setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		String expt="NaiduDoc123";

		//login as doctor
		wlib.WaitForPageLoad(d);
		
		d.get(URL);
		d.findElement(By.xpath("//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		d.findElement(By.name("password")).sendKeys(PASSWORD);
		d.findElement(By.xpath("//button[@type='submit']")).click();

		String actual=d.findElement(By.xpath("//span[@class='username']")).getText();
		
		if(actual.equals(expt))
		{
			System.out.println("SCRIPT PASSED ");
		}
		else
		{
			System.out.println("SCRIPT FAILED");
		}
		d.quit();
	}
	
}
