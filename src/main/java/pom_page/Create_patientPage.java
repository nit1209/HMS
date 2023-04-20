package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_patientPage {

	@FindBy(name="full_name")
	private WebElement Patinetname;
	
	@FindBy(name="address")
	private WebElement Patinetaddress;
	
	@FindBy(name="city")
	private WebElement PatinetCity;
	
	@FindBy(xpath="//label[@for='rg-male']")
	private WebElement Gender_male;
	
	@FindBy(xpath="//label[@for='rg-female']")
	private WebElement Gender_female;
	
	@FindBy(id="email")
	private WebElement Patientemail;
	
	@FindBy(id="password")
	private WebElement PatientPWD;
	
	@FindBy(id="password_again")
	private WebElement PatientCPWD;
	
	@FindBy(id="submit")
	private WebElement submitbtnP;

	public WebElement getPatinetname() {
		return Patinetname;
	}

	public WebElement getPatinetaddress() {
		return Patinetaddress;
	}

	public WebElement getPatinetCity() {
		return PatinetCity;
	}

	public WebElement getGender_male() {
		return Gender_male;
	}

	public WebElement getGender_female() {
		return Gender_female;
	}

	public WebElement getPatientemail() {
		return Patientemail;
	}

	public WebElement getPatientPWD() {
		return PatientPWD;
	}

	public WebElement getPatientCPWD() {
		return PatientCPWD;
	}

	public WebElement getSubmitbtnP() {
		return submitbtnP;
	}
	
	public Create_patientPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	
	public void PatientDetailsFill(String Ptname,String Paddress,String PCity,String Ptemail,String PtPWD,String PtCPWD)
	{
		Patinetname.sendKeys(Ptname);
		Patinetaddress.sendKeys(Paddress);
		PatinetCity.sendKeys(PCity);
		Patientemail.sendKeys(Ptemail);
		PatientPWD.sendKeys(PtPWD);
		PatientCPWD.sendKeys(PtCPWD);
		
	}
	
	
	public void Psubmitbtn()
	{
		submitbtnP.click();
	}
	
	public void Pgen_male()
	{
		Gender_female.click();
	}
	
	public void Pgen_female()
	{
		Gender_male.click();
	}
	
	
	
}
