package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQuery {
public static void main(String[] args) throws Throwable {
	
	//Register or Load the database from SQL
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);
	
	//Get connect to database
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	
	//Create SQL Statement
	Statement s= conn.createStatement();
	String query = "insert into student(first_name,last_name,address)values('Abc','Srivastava','India')";
	
	//Execute Query
	int result = s.executeUpdate(query); //primitive datatype content level comparison 
	if(result==1)
	{
		System.out.println(" User is created");
	}
	else
		System.out.println("User Not Created");
	}
}

