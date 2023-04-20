package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage 
{

	@FindBy(xpath="//input[@name='username']")
	private WebElement enterDoctorUN;

	@FindBy(name="password")
	private WebElement enterDoctorPWD;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitbtn;

	//initialization
	public DoctorLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);	
		}
		
		
	public WebElement getEnterDoctorUN() {
		return enterDoctorUN;
	}

	public WebElement getEnterDoctorPWD() {
		return enterDoctorPWD;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public void DoctorUN(String USERNAME)
	{
		enterDoctorUN.sendKeys(USERNAME);
	}
	
	public void DoctorPWD(String PASSWORD)
	{
		enterDoctorPWD.sendKeys(PASSWORD);
	}
	
	public void DoctorSumitbtn()
	{
		submitbtn.click();
	}


}
