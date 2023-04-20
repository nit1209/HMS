package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class UpdateDataFromDatabaseTest 
{

	public static void main(String[] args) throws Throwable 
	{ 
		Connection con=null;
		int result =0;
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
//			String query = "INSERT INTO COUNTRY VALUES (5,'uganda','salsa',128937);";
			String query = "delete from country where lower(country) = 'uganda';";

			//5: update query
			result = state.executeUpdate(query);

		}

		catch (Exception e) 
		{

		}


		finally
		{
			if(result==1) 
			{
				System.out.println("data is updated");
			}
			else
			{
				System.err.println("data not updated");
			}


			//6:close DB connection.
			con.close();
		}








	}

}
