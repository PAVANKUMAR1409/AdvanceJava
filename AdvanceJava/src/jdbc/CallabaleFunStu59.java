package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallabaleFunStu59
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				CallableStatement cs=con.prepareCall("{call ?:=RetrieveTotMarks59(?)}");
				cs.registerOutParameter(1, Types.VARCHAR);
				System.out.println("Enter Student rollno :");
				String rollno=s.nextLine();
				cs.setString(2, rollno);
				cs.execute();
				System.out.println("Student Rollno :"+rollno);
				System.out.println("Student grade : "+cs.getString(1));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
