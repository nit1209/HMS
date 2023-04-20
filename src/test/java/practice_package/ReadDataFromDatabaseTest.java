package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;


public class ReadDataFromDatabaseTest 
{

	public static void main(String[] args) throws Throwable 
	{
		Connection con=null;
		try
		{
			//1 : create object for driver
			Driver driver= new Driver();

			//2: register the database
			DriverManager.registerDriver(driver);

			//3: get connection for the database
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/npm","root","root");

			//4: create statement 
			Statement state = con.createStatement();
			String query = "select * from country;";

			//5: execute query
			ResultSet result = state.executeQuery(query);

			while (result.next())
			{
				System.out.println(result.getString(1)+" "+ result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		}
		catch (Exception e)
		{

		}
		finally
		{
			//6:close DB connection.
			con.close();
		}

	}
}

