package ppp1;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



import io.github.bonigarcia.wdm.WebDriverManager;

public class WEBELEMET_action {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//handle suggestions
	/*	driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("inputValEnter")).sendKeys("dress");
		List<WebElement> sug = driver.findElements(By.xpath("//ul[@class='suggestionList_menu']"));
			for(WebElement e:sug)
			{
				System.out.println(e.getText());
			}*/
			
		//mouse hover with click 
		/*	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement mh=driver.findElement(By.id("mousehover"));
		
		Actions a = new Actions(driver);
		a.moveToElement(mh).click().perform();
		String tt = driver.findElement(By.linkText("Top")).getText();
		System.out.println(tt);
		driver.quit(); */
		
		//drop down menu(tag should be select
	/*	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement sc = driver.findElement(By.name("dropdown-class-example"));
		
		Select s = new Select(sc);
		s.selectByIndex(2);
		Thread.sleep(1000);
		s.selectByVisibleText("Option3");
		Thread.sleep(2000);
		driver.quit();	*/
		
	/*	//scrollbar
		driver.get("https://skillrary.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");	*/
		
	/*	//takeScreen shot 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./pht/1.png");
		
		
		FileUtils.copyDirectory(src, dst); */
		
	/* //switch to frame
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement sign = driver.findElement(By.xpath("//span[contains(.,'Sign In')]"));
		Actions a = new Actions(driver);
		a.moveToElement(sign).perform();
		driver.findElement(By.xpath("//a[.='login']")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement frm = driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-delete-sign fnt-22']"));
		
		driver.switchTo().frame("loginIframe");
		driver.findElement(By.name("username")).sendKeys("3245364343");
		driver.findElement(By.id("checkUser")).click();
		driver.quit();		*/
		
		
	/*	//accept and cancel the alert
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.quit();		*/
		
	/*	//window handle
		driver.get("https://skpatro.github.io/demo/links/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("NewWindow")).click();
		String parent_id = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String required="about-me";
		while(it.hasNext())
		{
			String s=it.next();
			driver.switchTo().window(s);
			if(s.contains(required))
			{
				break;
			}
		}
		driver.close();
		driver.switchTo().window(parent_id);
		driver.close();			*/
	
	
	
	
	}


}
