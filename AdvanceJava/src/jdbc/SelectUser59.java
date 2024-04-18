package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectUser59 
{
	public static void main(String[] args) 
	{
		try
		{
			//step-1 : Loading Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// step-2 : Creating Connection
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String username="c##pavan";
			String pwd="pavankumar";
			Connection con = DriverManager.getConnection(url,username,pwd);
			
			//step-3 : Preparing Statements
			Statement stm= con.createStatement();
			
			//step-4 : Executing queries
			ResultSet rs= stm.executeQuery("SELECT * FROM user59");
			
			System.out.println("=========USERDETAILS=========");
			while(rs.next())
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+
									rs.getLong(4));
			
			//step-5 : Closing the Connection
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
}
