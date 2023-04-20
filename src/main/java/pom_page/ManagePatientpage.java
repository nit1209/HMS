package pom_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientpage 
{
	@FindBy(xpath="//span[.=' Manage Patient ']")
	private WebElement clickmanagepatient;

	public ManagePatientpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getClickmanagepatient() {
		return clickmanagepatient;
	}
	
	public void clickmanagepatient()
	{
		clickmanagepatient.click();
	}
	
	public void validatepatient(String pname,WebDriver driver )
	{
		String actual=driver.findElement(By.xpath("//td[.='"+pname+"']")).getText();
		if(actual.equalsIgnoreCase(pname))
		{
			System.out.println("SCRIPT PASS");
		}
		else
		{
			System.out.println("SCRIPT FAIL");
		}
		
	}
	
	
	
	
	
	
	
	
}
