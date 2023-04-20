package doctorModule;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_page.AddpatientDetailsByDoctorPage;
import pom_page.DoctorDashboardPage;
import pom_page.DoctorLoginPage;
import pom_page.Homepage;

public class TestNG_DoctorAddPatient extends BaseClass
{
	
	WebDriverUtility wlib=new WebDriverUtility();
	@Test(priority = 1,groups = "smock")
	public void execute2() throws Throwable
	{
		Homepage hp=new Homepage(driver);
		hp.clickonDoctor();
		System.out.println("doctor is logged IN");
		String DUSERNAME=flib.readDataFromPropertyFile("hms_tdoc_un");
		String DPASSWORD=flib.readDataFromPropertyFile("hms_tdoc_pwd");
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.DoctorUN(DUSERNAME);
		dlp.DoctorPWD(DPASSWORD);
		dlp.DoctorSumitbtn();
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.clickDoctorusername();
		ddp.DoctorLogout();
		System.out.println("doctor is logged OUT");
		Reporter.log("DOCTOR LOGIN AND LOG OUT IS DONE", true);
	}

	@Test(priority = 2)
	public void loginasDOc() throws Throwable
	{
		Random ran = new Random();
		int rn = ran.nextInt(500000);


	String pname="dhanno"+rn;
	String pmail=pname+"@gamil.com";
	String ppwd= "1"+rn;
	String padrs="kalaburagi"+rn;
	String pAge=""+rn;
	String medhis="broken leg";
	String pcon="785787"+rn;
	String pgen="male";
	
		Homepage hp=new Homepage(driver);
		hp.clickonDoctor();
		System.out.println("doctor is logged IN");
		String DUSERNAME=flib.readDataFromPropertyFile("hms_tdoc_un");
		String DPASSWORD=flib.readDataFromPropertyFile("hms_tdoc_pwd");
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.DoctorUN(DUSERNAME);
		dlp.DoctorPWD(DPASSWORD);
		dlp.DoctorSumitbtn();
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		
		ddp.mousehoverAddPatients(wlib, driver);
		
		ddp.clickaddpatient();
		AddpatientDetailsByDoctorPage apdd=new AddpatientDetailsByDoctorPage(driver);
		apdd.EnterPatientAge(pAge);
 		apdd.EnterpatientContact(pcon);
		apdd.EnterPatientmail(pmail);
		apdd.EnterPatientMedhis(medhis);
		apdd.EnterPatientname(pname);
		apdd.EnterPatinetAddress(padrs);
	
		apdd.PatientfemaleGender();
		apdd.Submitbtn();
		ddp.mousehoverAddPatients(wlib, driver);
	
		
		ddp.selectManagePatient();
		
		String actual=driver.findElement(By.xpath("//td[.='"+pname+"']")).getText();
		if(pname.equals(actual))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
		apdd.clickDoctorusername();
		apdd.DoctorLogout();
		Reporter.log("Doctor login and log out is DONE", true);
	}
	

	

		

	
	
	
	
	
}
