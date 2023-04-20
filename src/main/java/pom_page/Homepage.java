package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	//use findby annotaions for element Declaration
	@FindBy(xpath="//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")
	private WebElement Doctorlink;

	@FindBy(xpath ="//h3[.='Patients']/parent::div/descendant::a[.='Click Here']")
	private WebElement Patientlink;

	@FindBy(xpath="//h3[.='Admin Login']/parent::div/descendant::a[.='Click Here']")
	private WebElement Adminlink;

	//Initialization
	public Homepage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getDoctorlink() {
		return Doctorlink;
	}

	public WebElement getPatientlink() {
		return Patientlink;
	}

	public WebElement getAdminlink() {
		return Adminlink;
	}

	public void clickonDoctor()
	{
		Doctorlink.click();

	}

	public void clickonPatient()
	{
		Patientlink.click();
	}

	public void clickonAdmin()
	{
		Adminlink.click();
	}
}
