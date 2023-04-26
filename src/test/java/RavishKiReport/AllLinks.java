package RavishKiReport;

import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {

	public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver d=new ChromeDriver();
    d.get("https://www.flipkart.com");
    List<WebElement> links = d.findElements(By.xpath("//a"));
    int count=links.size();
    System.out.println(count);
    for(WebElement i:links)
    {
    	i.getText();
//    	String data = i.getAttribute("href");
//    	System.out.println(data);
    }
	}
}
