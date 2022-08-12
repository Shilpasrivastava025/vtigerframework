package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class LoadDataFromJDBC {
public static void main(String[] args) throws Throwable {
	
	//Step to register or load MYSQL data base
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);

	//Step 2  GET CONNECT TO DATABASE
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	
	//Step 3: CREATE SQL STATEMENT
	Statement s= conn.createStatement();
	String selectquery = "select * from student";
	
	//Step 4: Execute statement/ query
	ResultSet result = s.executeQuery(selectquery);
	while(result.next ()) // next() is used to move the cursor
	{
		System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	}
	
	//Step: 5 CLOSE THE DATABASE
	conn.close();
	
}
}
