package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDoctorDetailsPage 
{
	@FindBy(name="Doctorspecialization")
	private WebElement selectDOCSPecialization;

	@FindBy(name="docname")
	private WebElement EnterDocName;
	
	@FindBy(name="clinicaddress")
	private WebElement EnterDocAddress;

	@FindBy(name="docfees")
	private WebElement EnterDocfee;

	@FindBy(name="doccontact")
	private WebElement EnterDoccontact;

	@FindBy(name="docemail")
	private WebElement EnterDocmail;

	@FindBy(name="npass")
	private WebElement EnterDocpwd;

	@FindBy(name="cfpass")
	private WebElement EnterDocCPWD;

	@FindBy(id="submit")
	private WebElement submitbtn;

	public AddDoctorDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSelectDOCSPecialization() {
		return selectDOCSPecialization;
	}

	public WebElement getEnterDocAddress() {
		return EnterDocAddress;
	}

	public WebElement getEnterDocfee() {
		return EnterDocfee;
	}

	public WebElement getEnterDoccontact() {
		return EnterDoccontact;
	}

	public WebElement getEnterDocmail() {
		return EnterDocmail;
	}

	public WebElement getEnterDocName() {
		return EnterDocName;
	}

	public WebElement getEnterDocpwd() {
		return EnterDocpwd;
	}

	public WebElement getEnterDocCPWD() {
		return EnterDocCPWD;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	
	public void selectDOCSPecialization(WebDriverUtility wlib,String docspecializationNAME)
	{
		selectDOCSPecialization.click();
		wlib.select(selectDOCSPecialization, docspecializationNAME);
	}


	public void fillDocDetailsAndSUBMIT(String DocName,String DocAddress,String Docfee,String Doccontact,String Docmail,String Docpwd,String DocCPWD)
	{
		EnterDocName.sendKeys(DocName);
		EnterDocAddress.sendKeys(DocAddress);
		EnterDocfee.sendKeys(Docfee);
		EnterDoccontact.sendKeys(Doccontact);
		EnterDocmail.sendKeys(Docmail);
		EnterDocpwd.sendKeys(Docpwd);
		EnterDocCPWD.sendKeys(DocCPWD);
		
	}
	public void docdetailssubmit()
	{
		submitbtn.click();
	}

}
