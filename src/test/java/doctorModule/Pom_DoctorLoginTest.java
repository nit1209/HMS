package doctorModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.FileUtility;
import com.GenericUtility.IpathConstants;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_page.DoctorLoginPage;
import pom_page.Homepage;

public class Pom_DoctorLoginTest {

	public static void main(String[] args) throws Throwable {
		
		//create object for generic lib
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
	
		String URL = flib.readDataFromPropertyFile("hms_url");
		String USERNAME = flib.readDataFromPropertyFile("hms_tdoc_un");
		String PASSWORD = flib.readDataFromPropertyFile("hms_tdoc_pwd");
		
		
		//browser setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		Homepage hp = new Homepage(driver);
		
		//login as doctor
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.WaitForPageLoad(driver);
		hp.clickonDoctor();
		dlp.DoctorUN(USERNAME);
		dlp.DoctorPWD(PASSWORD);
		dlp.DoctorSumitbtn();
		
		

	}

}
