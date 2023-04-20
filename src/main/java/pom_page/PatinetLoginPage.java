package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatinetLoginPage 
{
	//declaration
	@FindBy(name="username")
	private WebElement enterpatinetname;
	
	@FindBy (name="password")
	private WebElement  enterpatientpwd;
	
	@FindBy (name="submit")
	private WebElement submitbtn;
	
	//Initialization
	public  PatinetLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	public WebElement getEnterpatinetname() {
		return enterpatinetname;
	}

	public WebElement getEnterpatientpwd() {
		return enterpatientpwd;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	public void PatientUN(String USERNAME)
	{
		enterpatinetname.sendKeys(USERNAME);
	}
	
	public void PatientPWD(String PASSWORD)
	{
		enterpatientpwd.sendKeys(PASSWORD);
	}
	
	public void PatientSumitbtn()
	{
		submitbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
