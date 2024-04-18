package jdbc;

import java.sql.*;
import java.util.Scanner;


public class InsertUser59 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		try {
			System.out.println("Enter user id : ");
			String id=scanner.nextLine();
			System.out.println("Enter user_name : ");
			String name=scanner.nextLine();
			System.out.println("Enter user mail-id : ");
			String mId = scanner.nextLine();
			System.out.println("Enter phone number : ");
			Long phno = scanner.nextLong();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String username="c##pavan";
			String pwd="pavankumar";
			Connection con = DriverManager.getConnection(url,username,pwd);
			
			Statement stm= con.createStatement();
			
			int k = stm.executeUpdate("INSERT INTO user59 VALUES("+id+",'"+name+"','"+mId+"',"+phno+")");
			
			if(k>0)
				System.out.println("1 ROW CREATED");
			
			scanner.close();
			con.close();
			
			
		}
		catch(SQLIntegrityConstraintViolationException s)
		{
			s.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
