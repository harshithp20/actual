package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		
		//Step-1- Register or load the mysql database
		Driver driverRef=new Driver();
		//register driver manager to the driver
		DriverManager.registerDriver(driverRef);
		
		//Step-2- Get connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harshithdb1","root","20031997");
		
		//Step-3- Create sql statement
		Statement stat = conn.createStatement();
		
		//Step-4- Execute statement/Query
		String selectquery = "select * from harsha";
		
		ResultSet result = stat.executeQuery(selectquery);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		//Step-5- Close the database connection
		conn.close();

	}

}
