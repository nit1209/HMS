package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Test1 {
	public static void main(String[] args) throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/npm","root","root");
		Statement state = con.createStatement();
		ResultSet result= state.executeQuery("select * from country");

		while(result.next())
		{
			System.out.println(result.getString(1)+""+result.getString(2));
		}


		con.close();







	}

}
