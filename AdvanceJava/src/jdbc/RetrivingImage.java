package jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

public class RetrivingImage 
{
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
				
				PreparedStatement ps= con.prepareStatement("SELECT * FROM StreamTab59 WHERE id=?");
				System.out.println("Enter the id to retrive the image :");
				String id=s.nextLine();
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					Blob b=rs.getBlob(2);
					byte[] by=b.getBytes(1, (int)b.length());
					System.out.println("Enter the fName and fPath : ");
					File f= new File(s.nextLine());
					FileOutputStream fos=new FileOutputStream(f);
					fos.write(by);
					System.out.println("Image retrived successfully......");
					fos.close();
				}
				else {
					System.out.println("Invalid id......");
				}
				
			}catch(Exception e) {e.printStackTrace();}
		}// end of try with resources
	}
}
