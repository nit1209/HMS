package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage
{
	@FindBy(name="username")
	private WebElement PatientUN;
	
	@FindBy(name="password")
	private WebElement PatientPWD;
	
	@FindBy(name="submit")
	private WebElement Submitbtn;
	
	@FindBy(xpath="//a[contains(.,'Create an account')]")
	private WebElement PatientCreateAccount;

	public PatientLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPatientUN() {
		return PatientUN;
	}

	public WebElement getPatientPWD() {
		return PatientPWD;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

	public WebElement getPatientCreateAccount() {
		return PatientCreateAccount;
	}
	
	
	public void PatinetCredentials(String PUN,String PPWD)
	{
		PatientUN.sendKeys(PUN);
		PatientPWD.sendKeys(PPWD);
	}
	
	public void PLsubmitbtn()
	{
		Submitbtn.click();
	}
	
	
	public void CreatePatienAccount()
	{
		PatientCreateAccount.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
