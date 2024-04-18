package jdbc;

import java.sql.*;
import java.util.Scanner;

public class InsertEmployee59 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter e_id : ");
			int e_id=sc.nextInt();
			System.out.println("Enter e_name : ");
			sc.nextLine();
			String name= sc.nextLine();
			System.out.println("Enter e_designation : ");
			String designation = sc.nextLine();
			System.out.println("Enter e_Basic Salary : ");
			float b_sal=sc.nextFloat();
			float hra=(float) (b_sal+(b_sal*0.93));
			float da =(float) (b_sal+(b_sal*0.61));
			float totsal=(float)b_sal+hra+da;
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String username="c##pavan";
			String pwd="pavankumar";
			Connection con = DriverManager.getConnection(url,username,pwd);
			
			Statement stm = con.createStatement();
			
			int k= stm.executeUpdate("INSERT INTO employee59 VALUES("+e_id+",'"+name+"','"+designation+"',"+b_sal+","+hra+","+da+","+totsal+")");
			if(k>0)
				System.out.println("1 ROW CREATED");
			
			sc.close();
			con.close();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
