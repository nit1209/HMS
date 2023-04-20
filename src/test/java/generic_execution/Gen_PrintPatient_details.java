package generic_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gen_PrintPatient_details {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		DatabaseUtility dlib = new DatabaseUtility();
		
		
		
	}

}
