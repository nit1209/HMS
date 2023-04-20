package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class AdminDashBoardPage {
	@FindBy(xpath="//span[.=' Doctors ']")
	private WebElement mousehovertoDoctor;

	@FindBy(xpath="//span[.=' Doctor Specialization ']")
	private WebElement clickDoctorSpecialization;

	@FindBy(xpath="//span[.=' Add Doctor']")
	private WebElement clickAddDoctor;

	@FindBy(name="Doctor Specialization")
	private WebElement selectDoctorSpecialization;
	
	@FindBy(name="submit")
	private WebElement docspcsubmitbtn;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement clickAdminusername;
	
	@FindBy(xpath="//span[@class='username']/following::a[contains(.,'Log Out')]")
	private WebElement logout;

	public WebElement getSelectDoctorSpecialization() {
		return selectDoctorSpecialization;
	}

	public WebElement getDocspcsubmitbtn() {
		return docspcsubmitbtn;
	}

	public AdminDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMousehovertoDoctor() {
		return mousehovertoDoctor;
	}

	public WebElement getClickDoctorSpecialization() {
		return clickDoctorSpecialization;
	}

	public WebElement getClickAddDoctor() {
		return clickAddDoctor;
	}
	
	

	public WebElement getClickusername() {
		return clickAdminusername;
	}

	public WebElement getLogout() {
		return logout;
	}


	public void clickonDoctors(WebDriverUtility wlib,WebDriver driver)
	{
		wlib.mousehover(driver, mousehovertoDoctor);
	}

	public void clickDoctorSpecialization()
	{
		clickDoctorSpecialization.click();
	}

	public void clickaddDoctor()
	{
		clickAddDoctor.click();
	}

	public void enterdocspec(String spec)
	{
		selectDoctorSpecialization.sendKeys(spec);
	}

	public void clicksubmit()
	{
		docspcsubmitbtn.click();
	}

	public void clickAdminusername()
	{
		clickAdminusername.click();
	}

	public void AdminLogout()
	{
		logout.click();
	}








}
