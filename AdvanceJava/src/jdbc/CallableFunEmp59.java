package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableFunEmp59 
{
	public static void main(String[] args) 
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				CallableStatement cs= con.prepareCall("{call ?:=RetrieveTotSal59(?)}");
				cs.registerOutParameter(1, Types.FLOAT);
				System.out.println("Enter Emp-Id :");
				String id=s.nextLine();
				cs.setString(2, id);
				cs.execute();
				System.out.println("Emp-Id : "+id);
				System.out.println("Emp-TotalSalary : "+cs.getFloat(1));
			}catch(Exception e) {e.printStackTrace();}
		}
	}
}
