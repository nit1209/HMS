package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientBookAppointmentPage 
{
	@FindBy(xpath="Doctorspecialization")
	private WebElement DocSpecSelect;
	
	@FindBy(id="doctor")
	private WebElement SelectDoc;
	
	@FindBy(name="appdate")
	private WebElement appointDate;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//td[.='23']")
	private WebElement SelectDate;

	public PatientBookAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDocSpecSelect() {
		return DocSpecSelect;
	}

	public WebElement getSelectDoc() {
		return SelectDoc;
	}

	public WebElement getAppointDate() {
		return appointDate;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getSelectDate() {
		return SelectDate;
	}
	
	public void SelectDOctor(WebDriverUtility wlib,WebDriver driver,String spec )
	{
		wlib.select(DocSpecSelect, spec);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
