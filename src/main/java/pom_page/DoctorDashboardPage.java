package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class DoctorDashboardPage {
	@FindBy(xpath="//span[.=' Patients ']")
	private WebElement mousehovertoaddPatients;

	@FindBy (xpath="//span[contains(.,' Add Patient')]")
	private WebElement clickonaddpatient;

	@FindBy(xpath="//span[@class='username']")
	private WebElement clickdoctorusername;
	
	@FindBy(xpath="//span[@class='username']/following::a[contains(.,'Log Out')]")
	private WebElement logout;
	
	@FindBy (xpath="//span[.=' Manage Patient ']")
	private WebElement ManagePatient;
	
	public WebElement getManagePatient() {
		return ManagePatient;
	}

	public WebElement getClickdoctorusername() {
		return clickdoctorusername;
	}

	public WebElement getLogout() {
		return logout;
	}

	public DoctorDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMousehovertoaddPatients() {
		return mousehovertoaddPatients;
	}

	public WebElement getClickonaddpatient() {
		return clickonaddpatient;
	}

	public void mousehoverAddPatients(WebDriverUtility wlib,WebDriver driver )
	{
		wlib.mousehover(driver, mousehovertoaddPatients);
	}
	
	public void clickaddpatient()
	{
		clickonaddpatient.click();
	}
	
	public void clickDoctorusername()
	{
		clickdoctorusername.click();
	}

	public void DoctorLogout()
	{
		logout.click();
	}

	
	public void selectManagePatient()
	{
		ManagePatient.click();
	}
	
	

}
