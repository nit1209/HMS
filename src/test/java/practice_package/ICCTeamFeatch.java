package practice_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCTeamFeatch {

	public static void main(String[] args) 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String teamname="India";
		List<WebElement> pos = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		
	
		for(int i=0; i<team.size(); i++)
		{
			System.out.println(pos.get(i).getText()+"\t"+team.get(i).getText()+"\t "+matches.get(i).getText()+"\t "+points.get(i).getText());
			
		}
		
		
		
	}

}
