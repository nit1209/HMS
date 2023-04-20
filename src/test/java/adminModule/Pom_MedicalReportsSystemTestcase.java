package adminModule;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_page.AddDoctorDetailsPage;
import pom_page.AdddocSpecializationPage;
import pom_page.AddpatientDetailsByDoctorPage;
import pom_page.AdminDashBoardPage;
import pom_page.AdminLoginPage;
import pom_page.Create_patientPage;
import pom_page.Homepage;
import pom_page.PatientDashBoard;
import pom_page.PatientLoginPage;






public class Pom_MedicalReportsSystemTestcase {

	public static void main(String[] args) throws Throwable 
	{
		//create object 
		DatabaseUtility dlib = new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		String URL = flib.readDataFromPropertyFile("hms_url");
		String AUN = flib.readDataFromPropertyFile("hms_ad_un");
		String APWD = flib.readDataFromPropertyFile("hms_ad_pwd");

		//browser setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wlib.maximizeWindow(driver);
		wlib.WaitForPageLoad(driver);

		Random ran = new Random();
		int rn = ran.nextInt(500);
		int mn = ran.nextInt(999999999);
		int pwd = ran.nextInt(999999);

		//admin login	
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.WaitForPageLoad(driver);
		Homepage hp = new Homepage(driver);
		hp.clickonAdmin();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.AdminUN(AUN);
		alp.AdminPWD(APWD);
		alp.Adminsumitbtn();
		//
		//doctor Specialization
		AdminDashBoardPage adp = new AdminDashBoardPage(driver);
		AdddocSpecializationPage spcd = new AdddocSpecializationPage(driver);
		String Spec="bones";

		adp.clickonDoctors(wlib, driver);
		adp.clickDoctorSpecialization();
		Thread.sleep(2000);
		spcd.selectDocSpec(Spec);
		adp.clicksubmit();

		//select add doctor
		adp.clickonDoctors(wlib, driver);
		adp.clickaddDoctor();

		//random gen doc details
		String DocName="tingri"+rn;
		String DocAddress="mount everest"+rn;
		String Docfee="1";
		String Doccontact="6"+mn;
		String Docmail=DocName+rn+"@gmail.com";
		String Docpwd="8"+pwd;
		String DocCPWD=Docpwd;

		//fill doctor details
		AddDoctorDetailsPage addp = new AddDoctorDetailsPage(driver);

		addp.selectDOCSPecialization(wlib, Spec);
		addp.fillDocDetailsAndSUBMIT(DocName, DocAddress, Docfee, Doccontact, Docmail, Docpwd, DocCPWD);
		addp.docdetailssubmit();		
		wlib.AcceptAlert(driver);
		adp.clickAdminusername();
		adp.AdminLogout();
		System.out.println("doctor added successfully");
		System.out.println("");
		
		//create patient
		String pn="chandu"+rn;
		String padd= "kalaburagi"+rn;
		String pcity="kalaburagi";
		String pmail=pn+rn+"@gmail.com";
		String ppwd="9"+pwd;

		Create_patientPage cp = new Create_patientPage(driver);
		PatientLoginPage pl = new PatientLoginPage(driver);
		Thread.sleep(1000);
		hp.clickonPatient();
		pl.CreatePatienAccount();
		cp.PatientDetailsFill(pn, padd, pcity, pmail, ppwd, ppwd);
		cp.Pgen_male();
		cp.Psubmitbtn();
		wlib.AcceptAlert(driver);
		System.out.println("patient account created successfully");
		
		//login as PAtient
		driver.get(URL);
		hp.clickonPatient();
		pl.PatinetCredentials(pmail, ppwd);
		pl.PLsubmitbtn();
		PatientDashBoard pdb = new PatientDashBoard(driver);
		pdb.BookAppointment();
		
			





















	}
}