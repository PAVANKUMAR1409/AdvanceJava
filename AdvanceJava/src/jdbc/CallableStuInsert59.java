package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallableStuInsert59 
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
				
				CallableStatement cs= con.prepareCall("{call StuInsert59(?,?,?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter Stu-rno");
				String rno = s.nextLine();
				cs.setString(1,rno);
				
				System.out.println("Enter stu-Name");
				String ename=s.nextLine();
				cs.setString(2, ename);
				
				System.out.println("Enter stu-branch");
				String branch=s.nextLine();
				cs.setString(3, branch);
				
				System.out.println("Enter stu-city");
				String city=s.nextLine();
				cs.setString(4, city);
				
				System.out.println("Enter stu-State");
				String state=s.nextLine();
				cs.setString(5, state);
				
				System.out.println("Enter stu-PinCode");
				int pincode=Integer.parseInt(s.nextLine());
				cs.setInt(6, pincode);
				
				System.out.println("Enter stu-mailId");
				String mailId=s.nextLine();
				cs.setString(7,mailId);
				
				System.out.println("Enter stu-Phno");
				long phno=Long.parseLong(s.nextLine());
				cs.setLong(8,phno);
				
				System.out.println("Enter Stu-totMarks");
				int totMarks=Integer.parseInt(s.nextLine());
				cs.setInt(9, totMarks);
				
				float per= totMarks/6;
				cs.setFloat(10, per);
				
				String grade= (per>=90)?"A+":(per>=80)?"A":(per>=70)?"B+":(per>=60)?"B":"passed";
				cs.setString(11, grade);
				
				
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
