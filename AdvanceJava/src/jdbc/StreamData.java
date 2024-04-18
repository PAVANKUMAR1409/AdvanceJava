package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StreamData 
{
	public static void main(String[] args) 
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				PreparedStatement ps=con.prepareStatement("INSERT INTO StreamTab59 VALUES(?,?)");
				System.out.println("Enter the id : ");
				String id=s.nextLine();
				ps.setString(1, id);
				
				System.out.println("Enter fName and fPath(Source) : ");
				File f=new File(s.nextLine());
				if(f.exists())
				{
					FileInputStream fis= new FileInputStream(f);
					ps.setBinaryStream(2, fis, f.length());
					int k= ps.executeUpdate();
					if(k>0)
					{
						System.out.println("Image stored in DataBase successfully.......");
					}
				}
				else {
					System.out.println("Invalid fName and fPath........");
				}
				
				
				
			}// end of try
			catch(Exception e) {e.printStackTrace();}
		}// end of try with resource
	}
	
}
