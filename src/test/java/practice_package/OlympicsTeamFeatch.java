package practice_package;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsTeamFeatch {

	public static void main(String[] args) 
	{
		//div[@data-cy='table-content']/descendant::span[.='Argentina']
		//div[@data-cy='table-content']/descendant::span[@data-cy='country-name']
		//span[.='Australia']/following::span[@class='Medalstyles__Medal-sc-1tu6huk-1 gHnuPI']
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		List<WebElement> country = d.findElements(By.xpath("//span[@data-cy='country-name']"));
		ArrayList<String> list=new ArrayList<String>();
		
	//fetching all name of country
		int count=1;
		for(int i=0; i<country.size(); i++)
		{
			String countryname=country.get(i).getText();
			System.out.println(count+" "+countryname);
			count++;	
		}
		
		for(int i=0; i<country.size(); i++)
		{
			list.add(country.get(i).getText());
	
		}
		
		// teamname gives countryname 
		for(int i=0;i<list.size();i++)
		{
			String gold="//span[.='"+list.get(i)+"']/following::span[@class='Medalstyles__Medal-sc-1tu6huk-1 gHnuPI'";
			String Gold= d.findElement(By.xpath(gold)).getText();
			
			System.out.println("team-> "+list.get(i)+"->(gold) -> " + Gold);
			
		}

		
		
		
		
		
	}



}


