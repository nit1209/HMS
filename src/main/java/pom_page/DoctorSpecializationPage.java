package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSpecializationPage 
{
	@FindBy(name="doctorspecilization")
	private WebElement enterDocSpecialization;
	
	@FindBy(name="submit")
	private WebElement submitbtn;

	public DoctorSpecializationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEnterDocSpecialization() {
		return enterDocSpecialization;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
}
