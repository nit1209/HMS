package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con=null;
	public void connectToDB_TY() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL_TY, IpathConstants.DBUSRNAME_TY, IpathConstants.DBPASSWORD);
		
	}
	public void connectToDB_MY() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL_MY, IpathConstants.DBUSRNAME_MY, IpathConstants.DBPASSWORD);
		
	}
	
	public String executeQueryAndGetData(String query,String expdata,int columnIndex) throws Throwable 
	{
		System.out.println("");
		System.out.println("Database connected");
		System.out.println("");
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data= result.getString(columnIndex);
			
			if(data.equalsIgnoreCase(expdata))
			{
				flag = true;
				break;
			}
		}	
		if(flag)
		{
			System.out.println("data is verified");
		return expdata;
		}
		else
		{
			System.out.println("data not updated");
			return "";
		}
	}
	
	public void closeDB() throws Throwable {
		con.close();
		
		
	} 
	
}
