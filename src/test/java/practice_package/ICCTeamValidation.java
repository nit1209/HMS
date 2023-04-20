package practice_package;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCTeamValidation {

	public static void main(String[] args) 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		List<WebElement> pos = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		
		boolean flag=false;
		String teamname="India";
		
		for(WebElement e:team)
		{
			String text=e.getText();
			if(text.equals(teamname))
			{
				System.out.println(teamname+" team exist");
				flag=true;
				break;
			}			
		}
		if(!flag)
		{
			System.out.println(teamname+" this team does not exist");
		}
	
		
	}

}
