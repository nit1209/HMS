package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraServerProject 
{

	public static void main(String[] args) throws Throwable 
	{	
		//common data


		//setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("http://rmgtestingserver:8084/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Random ran = new Random();
		int rn = ran.nextInt(300);
		String pname="HMS"+rn;
		String mname="valmiki"+rn;
		Connection con=null;


		try 
		{
			//login page
			d.findElement(By.name("username")).sendKeys("rmgyantra");
			d.findElement(By.name("password")).sendKeys("rmgy@9999");
			d.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//a[.='Projects']")).click();
			d.findElement(By.xpath("//button[@class='btn btn-success']")).click();
			d.findElement(By.name("projectName")).sendKeys(pname);
			d.findElement(By.name("createdBy")).sendKeys(mname);

			//create select class  and add project
			WebElement btn = d.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select s = new Select(btn);
			s.selectByVisibleText("On Gogin");
			d.findElement(By.xpath("//input[@value='Add Project']")).click();


			//read from database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement state = con.createStatement();
			String q="select * from project;";
			ResultSet result=state.executeQuery(q);
			boolean flag=false;
			while(result.next())
			{
				String exptpname=result.getString(4);
				System.out.println(result.getString(4));
				

				if(pname.equalsIgnoreCase(exptpname))
				{
					flag=true;
					break;

				}
			}
				if(flag)
				{
					System.out.println("----------------------------");
					System.out.println(pname);
					System.out.println("project created successfully");
					System.out.println("----------------------------");
				}
				else
				{
					System.out.println("-------------------");
					System.out.println("project not created");
					System.out.println("-------------------");
				}
			}
		
			catch (Exception e)
			{
				
			}
			finally 
			{
				con.close();
				d.quit();
			}
		}

	}


