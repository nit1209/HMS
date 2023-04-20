package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddpatientDetailsByDoctorPage
{
	@FindBy(name="patname")
	private WebElement patientname;

	@FindBy(name="patcontact")
	private WebElement patientcontact;

	@FindBy(id="patemail")
	private WebElement patientmail;

	@FindBy(name="pataddress")
	private WebElement patientaddress;

	@FindBy (xpath="//label[@for='rg-male']")
	private WebElement malegender;

	@FindBy (xpath="//label[@for='rg-female']")
	private WebElement femalegender;

	@FindBy(name="patage")
	private WebElement patientage;

	@FindBy(name="medhis")
	private WebElement patinetmedhis;

	@FindBy(id="submit")
	private WebElement sbtbtn;
	
	public WebElement getLogout() {
		return logout;
	}

	@FindBy(xpath="//span[@class='username']/following::a[contains(.,'Log Out')]")
	private WebElement logout;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement clickdoctorusername;

	public WebElement getClickdoctorusername() {
		return clickdoctorusername;
	}

	public AddpatientDetailsByDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}

	public WebElement getPatientname() {
		return patientname;
	}

	public WebElement getPatientcontact() {
		return patientcontact;
	}

	public WebElement getPatientmail() {
		return patientmail;
	}

	public WebElement getPatientaddress() {
		return patientaddress;
	}

	public WebElement getMalegender() {
		return malegender;
	}

	public WebElement getFemalegender() {
		return femalegender;
	}


	public WebElement getPatientage() {
		return patientage;
	}

	public WebElement getPatinetmedhis() {
		return patinetmedhis;
	}

	public WebElement getSbtbtn() {
		return sbtbtn;
	}


	public void EnterPatientname(String pname) {
		patientname.sendKeys(pname);
	}
	public void EnterpatientContact(String pnum) {
		patientcontact.sendKeys(pnum);
	}
	public void EnterPatientmail(String pmail) {
		patientmail.sendKeys(pmail);
	}
	public void EnterPatinetAddress(String paddress) {
		patientaddress.sendKeys(paddress);
	}
	public void PatientmaleGender() {

		malegender.click();
	}
	public void PatientfemaleGender() {
		femalegender.click();
	}

	public void EnterPatientAge(String age)
	{
		patientage.sendKeys(age);
	}

	public void EnterPatientMedhis(String medhis)
	{
		patinetmedhis.sendKeys(medhis);
	}

	public void Submitbtn()
	{
		sbtbtn.click();
	}
	
	public void clickDoctorusername()
	{
		clickdoctorusername.click();
	}

	public void DoctorLogout()
	{
		logout.click();
	}





}
