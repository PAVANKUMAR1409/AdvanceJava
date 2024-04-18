package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableEmpRetrieve59 
{
	public static void main(String[] args) 
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				CallableStatement cs=con.prepareCall("{call EmpRetrieve59(?,?,?,?,?,?,?,?,?,?)}");
				System.out.println("Enter the Emp-Id");
				String id= s.nextLine();
				cs.setString(1, id);
				
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.INTEGER);
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.BIGINT);
				cs.registerOutParameter(9, Types.INTEGER);
				cs.registerOutParameter(10, Types.FLOAT);
				
				cs.execute();
				
				System.out.println("********************Employee Detailes**************");
				System.out.println("Emp-id : "+id);
				System.out.println("Emp-name : "+cs.getString(2));
				System.out.println("Emp-desg : "+cs.getString(3));
				System.out.println("Emp-city : "+cs.getString(4));
				System.out.println("Emp-state : "+cs.getString(5));
				System.out.println("Emp-PinCode : "+cs.getInt(6));
				System.out.println("Emp-mailId : "+cs.getString(7));
				System.out.println("Emp-Phno : "+cs.getLong(8));
				System.out.println("Emp-bsalary : "+cs.getInt(9));
				System.out.println("Emp-totSalary : "+cs.getFloat(10));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
