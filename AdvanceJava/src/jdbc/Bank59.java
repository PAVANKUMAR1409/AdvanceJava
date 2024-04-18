package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Scanner;

public class Bank59 
{
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				PreparedStatement ps1 = con.prepareStatement("Select * from Bank59 where accno=?");
				PreparedStatement ps2 = con.prepareStatement("update Bank59 set bal=bal+? where accno=?");
				
				System.out.println("Commit status : "+con.getAutoCommit());
				con.setAutoCommit(false);
				System.out.println("Commit status : "+con.getAutoCommit());
				Savepoint sp= con.setSavepoint();
				
				System.out.println("Enter home accno : ");
				long hAccNo=s.nextLong();
				ps1.setLong(1, hAccNo);
				
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next())
				{
					float bl=rs1.getFloat(3);
					System.out.println("Enter Benificiary acc no :");
					long bAccNo=s.nextLong();
					ps1.setLong(1, bAccNo);
					
					ResultSet rs2=ps1.executeQuery();
					if(rs2.next())
					{
						System.out.println("Enter amount to transfer : ");
						float amt=s.nextFloat();
						if(amt<bl)
						{
							ps2.setFloat(1,-amt);
							ps2.setLong(2,hAccNo);
							int i= ps2.executeUpdate();
							// buffer updated
							
							ps2.setFloat(1,+amt);
							ps2.setLong(2,bAccNo);
							int j= ps2.executeUpdate();
							// buffer updated
							
							if(i==1 && j==1)
							{
								con.commit();
								System.out.println("Transcation Successfull.......");
							}
							else {
								con.rollback(sp);
								System.out.println("Transcation Failed....... ");
							}
							
						}
						else
						{
							System.out.println("Insufficient Balance");
						}
						
					}
					else {
						System.out.println("Invalid Benificiary acc no............");
					}
				}
				else {
					System.out.println("Invalid home acc no ...............");
				} 
			}//end of try
			catch(Exception e){e.printStackTrace();}
		}// end of try with resource
	}
}
