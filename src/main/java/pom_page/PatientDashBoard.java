package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashBoard {
@FindBy(xpath="//span[.=' Book Appointment ']")
private WebElement bookmyappointment;
	
@FindBy(xpath="//span[.=' Appointment History ']")
private WebElement PAppointmentHis;

public PatientDashBoard(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public WebElement getBookmyappointment() {
	return bookmyappointment;
}

public WebElement getPAppointmentHis() {
	return PAppointmentHis;
}

public void BookAppointment()
{
	bookmyappointment.click();
}

public void PAppointmentHistory()
{
	PAppointmentHis.click();
}




















}
