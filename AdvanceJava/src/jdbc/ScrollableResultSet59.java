package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ScrollableResultSet59 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar");
			Statement stm= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= stm.executeQuery("Select * from Product59");
			rs.last();
			System.out.println("-------last row-------");
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
			rs.absolute(2);
			System.out.println("-------2nd Row--------");
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
			rs.relative(+3);
			System.out.println("-------relative(+3)--------");
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
			
			System.out.println("======Type=====");
			System.out.println("Type Forward Only : "+ResultSet.TYPE_FORWARD_ONLY);
			System.out.println("TYPE_SCROLL_INSENSTIVE : "+ResultSet.TYPE_SCROLL_INSENSITIVE);
			System.out.println("TYPE_SCROLL_SENSITIVE : "+ResultSet.TYPE_SCROLL_SENSITIVE+"\n");
			
			System.out.println("========MODE========");
			System.out.println("CONCUR_READ_ONLY :"+ResultSet.CONCUR_UPDATABLE);
			System.out.println("CONCUR_UPDATABLE :"+ResultSet.CONCUR_UPDATABLE);
		}// end of try
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
