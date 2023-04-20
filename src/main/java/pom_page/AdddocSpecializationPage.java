package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdddocSpecializationPage 
{
	@FindBy(name="doctorspecilization")
	private WebElement selectDoctorSpecialization;

	public AdddocSpecializationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectDoctorSpecialization() {
		return selectDoctorSpecialization;
	}
	
	public void selectDocSpec(String spec)
	{
		selectDoctorSpecialization.sendKeys(spec);
	}
	
	
	
}
