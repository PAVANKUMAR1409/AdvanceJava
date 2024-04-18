package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableStStuRetrieve59 
{
	public static void main(String[] args) 
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				CallableStatement cs=con.prepareCall("{call StuRetrieve59(?,?,?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter Student roll No. ");
				String rollno=s.nextLine();
				cs.setString(1, rollno);
				
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.INTEGER);
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.BIGINT);
				cs.registerOutParameter(9, Types.INTEGER);
				cs.registerOutParameter(10, Types.INTEGER);
				cs.registerOutParameter(11, Types.VARCHAR);
				
				cs.execute();
				
				System.out.println("Student roll-no : "+rollno);
				System.out.println("Student name : "+cs.getString(2));
				System.out.println("Student branch : "+cs.getString(3));
				System.out.println("Student city : "+cs.getString(4));
				System.out.println("Student state : "+cs.getString(5));
				System.out.println("Student pincode : "+cs.getInt(6));
				System.out.println("Student mailId : "+cs.getString(7));
				System.out.println("Student Phno : "+cs.getLong(8));
				System.out.println("Student totalmarks : "+cs.getInt(9));
				System.out.println("Student Percentage : "+cs.getFloat(10));
				System.out.println("Student grade : "+cs.getString(11));
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
