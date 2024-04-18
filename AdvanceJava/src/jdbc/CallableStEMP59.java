package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableStEMP59 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
				String username="c##pavan";
				String pwd="pavankumar";
				Connection con = DriverManager.getConnection(url,username,pwd);
				
				CallableStatement cs= con.prepareCall("{call EmpInsert59(?,?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter Emp-Id");
				String eid = s.nextLine();
				cs.setString(1,eid);
				
				System.out.println("Enter Emp-Name");
				String ename=s.nextLine();
				cs.setString(2, ename);
				
				System.out.println("Enter Emp-desg");
				String desg=s.nextLine();
				cs.setString(3, desg);
				
				System.out.println("Enter Emp-city");
				String city=s.nextLine();
				cs.setString(4, city);
				
				System.out.println("Enter Emp-State");
				String state=s.nextLine();
				cs.setString(5, state);
				
				System.out.println("Enter Emp-PinCode");
				int pincode=Integer.parseInt(s.nextLine());
				cs.setInt(6, pincode);
				
				System.out.println("Enter Emp-mailId");
				String mailId=s.nextLine();
				cs.setString(7,mailId);
				
				System.out.println("Enter Emp-Phno");
				long phno=Long.parseLong(s.nextLine());
				cs.setLong(8,phno);
				
				System.out.println("Enter Emp=bsal");
				int bsal=Integer.parseInt(s.nextLine());
				cs.setInt(9, bsal);
				float totsal=bsal+(0.93F*bsal)+(0.61F*bsal);
				cs.setFloat(10,totsal);	
				
				cs.execute();
				System.out.println("Procedure Executed");
			}// end of try
			catch(Exception e)
			{
				e.printStackTrace();	
			}
		}// end of try with resource
	}
}
