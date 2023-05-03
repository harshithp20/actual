package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ReadDataFromMySqlNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		
		//Step-1- Register or load the mysql database
		Driver driverRef=new Driver();
		//register driver manager to the driver
		DriverManager.registerDriver(driverRef);
		
		//Step-2- Get connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harshithdb1","root","20031997");
		
		//Step-3- Create sql statement
		Statement stat = conn.createStatement();
		
		//Inserting data into database 
		String query = "insert into harsha(first_name,last_name,address)values('prakash','thriveni','crp')";
		
		//Step-4- Execute statement/Query
		
		int result = stat.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("Data is added");
		}
		else
		{
			System.out.println("Data is not added");
		}
		
		//Step-5- Close the database connection
		conn.close();

	}
}
