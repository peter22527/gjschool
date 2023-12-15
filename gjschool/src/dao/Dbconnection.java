package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection  
{

	
	public static void main(String[] args) //動態class > Dbconnection
{
		//DbConnection db=new DbConnection();
		//System.out.println(db.name);
		
		System.out.println(Dbconnection.getDb());
}
	
	String name; //靜態class
	
	public static Connection getDb() //只有get，
	{
		Connection conn=null; 
		String url="jdbc:mysql://localhost:3306/school";
		String user="root";
		String password="0000";
		
		try {conn=DriverManager.getConnection(url,user,password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("no Driver");
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			System.out.println("no connection");
			e.printStackTrace();
		}
		return conn;
		
		
		

    }
	
}