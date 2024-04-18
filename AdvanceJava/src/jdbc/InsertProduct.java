package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertProduct 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		try {
			System.out.println("Enter user code : ");
			String code=scanner.nextLine();
			System.out.println("Enter item_name : ");
			String name=scanner.nextLine();
			System.out.println("Enter user price : ");
			int price = scanner.nextInt();
			System.out.println("Enter city : ");
			scanner.nextLine();
			String city = scanner.nextLine();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String username="c##pavan";
			String pwd="pavankumar";
			Connection con = DriverManager.getConnection(url,username,pwd);
			
			Statement stm= con.createStatement();
			
			int k = stm.executeUpdate("INSERT INTO product VALUES("+code+",'"+name+"',"+price+",'"+city+"')");
			
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
			e.printStackTrace();
			//System.out.println(e.toString());
		}
	}
}
