package pl.kielce.tu;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_object_technologies?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("\nConnection: " + myConn + "\n\n");
			System.out.println("Connection successfull !!!");
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
