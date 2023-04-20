package adminModule;


import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtility.BaseClass;

import pom_page.AdminDashBoardPage;
import pom_page.AdminLoginPage;
import pom_page.DoctorDashboardPage;
import pom_page.DoctorLoginPage;
import pom_page.Homepage;


public class Testng_adminlogintest extends BaseClass{



	@Test
	public void execute1() throws Throwable
	{
		Homepage hp=new Homepage(driver);
		hp.clickonAdmin();
		String AUSERNAME=	flib.readDataFromPropertyFile("hms_ad_un");
		String APASSWORD=flib.readDataFromPropertyFile("hms_ad_pwd");
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.AdminUN(AUSERNAME);
		alp.AdminPWD(APASSWORD);
		alp.Adminsumitbtn();
		System.out.println("admin is logged IN");
		AdminDashBoardPage adp=new AdminDashBoardPage(driver);
		adp.clickAdminusername();
		adp.AdminLogout();
//		SoftAssert sa = new SoftAssert();
//		sa.fail();
		Assert.fail();
		Reporter.log("admin login is done", true);
		System.out.println("ADMIN LOGIN AND LOG OUT IS DONE");
//		sa.assertAll();
	}

	@Test
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


}
