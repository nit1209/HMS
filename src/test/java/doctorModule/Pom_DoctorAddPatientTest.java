package doctorModule;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_page.DoctorDashboardPage;
import pom_page.AddpatientDetailsByDoctorPage;
import pom_page.DoctorLoginPage;
import pom_page.Homepage;
import pom_page.ManagePatientpage;

public class Pom_DoctorAddPatientTest {

	public static void main(String[] args) throws Throwable 
	{
		//creating objects 
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.random();
		Random ran1 = new Random();
		int rn = ran1.nextInt(100);
		ran=ran*ran;
		//patient random details generator
		String pname="dhanno"+ran;
		String pmail=pname+"@gamil.com";
		String ppwd= "1"+ran;
		String padrs="kalaburagi"+ran;
		String pAge=""+rn;
		String medhis="broken leg";
		String pcon="785787"+ran;
		String pgen="male";

		//doctor login details
		String URL = flib.readDataFromPropertyFile("hms_url");
		String DUN = flib.readDataFromPropertyFile("hms_tdoc_un");
		String DPWD = flib.readDataFromPropertyFile("hms_tdoc_pwd");

		//browser setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Homepage hp = new Homepage(driver);
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		DoctorDashboardPage app = new DoctorDashboardPage(driver);
		AddpatientDetailsByDoctorPage apd = new AddpatientDetailsByDoctorPage(driver);
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.WaitForPageLoad(driver);
		hp.clickonDoctor();

		//login as doctor
		dlp.DoctorUN(DUN);
		dlp.DoctorPWD(DPWD);
		dlp.DoctorSumitbtn();

		//add patients
		app.mousehoverAddPatients(wlib, driver);
		app.clickaddpatient();

		//fill patient details
		apd.EnterPatientname(pname);
		apd.EnterpatientContact(pcon);
		apd.EnterPatientAge(pAge);
		apd.EnterPatientmail(pmail);
		apd.EnterPatinetAddress(padrs);
		apd.EnterPatientMedhis(medhis);
		apd.PatientfemaleGender();
		apd.Submitbtn();

		System.out.println(pname);
		System.out.println(pmail);
		System.out.println(pcon);
		System.out.println("");

		//manage patient for validation
		ManagePatientpage mp = new ManagePatientpage(driver);
		app.mousehoverAddPatients(wlib, driver);
		mp.clickmanagepatient();
		mp.validatepatient(pname, driver);

		/*String actual=driver.findElement(By.xpath("//td[.='"+pname+"']")).getText();

		if(actual.equalsIgnoreCase(pname))
		{
			System.out.println("SCRIPT PASS");
			driver.quit();
		}
		else
		{
			System.out.println("SCRIPT FAIL");
			driver.quit();
		}*/
	}

}
