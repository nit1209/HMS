package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	//Declaration
	@FindBy(xpath="//input[@name='username']")
	private WebElement enteradminname;
	
	@FindBy(name="password")
	private WebElement enteradminpwd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitbtn;
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}


	

	//utilization
	public WebElement getEnteradminname() {
		return enteradminname;
	}


	public WebElement getEnteradminpwd() {
		return enteradminpwd;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public void AdminUN(String USERNAME)
	{
		enteradminname.sendKeys(USERNAME);
	}
	
	public void AdminPWD(String PASSWORD)
	{
		enteradminpwd.sendKeys(PASSWORD);
	}
	
	public void Adminsumitbtn()
	{
		submitbtn.click();
	}
	
	
	
	
}
