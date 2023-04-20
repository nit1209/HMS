package practice_package;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCTeamRankFetchByXpathmod {

	public static void main(String[] args) 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		ArrayList<String> list= new ArrayList<String>();
		
		
		for(int i=0; i<team.size(); i++)
		{
			list.add(team.get(i).getText());
	
		}
		
		for(String myteam:list)
		{
			String rating="//span[.='"+myteam+"']/../following-sibling::td[3]";
			String Rating= driver.findElement(By.xpath(rating)).getText();
			
			System.out.println("team-> "+myteam+"->(rating is) -> " + Rating);
			
		}
		

	}

}
