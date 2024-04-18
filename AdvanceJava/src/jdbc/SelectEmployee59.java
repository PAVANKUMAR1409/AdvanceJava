package jdbc;

import java.sql.*;

public class SelectEmployee59 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="c##pavan";
		String pwd="pavankumar";
		Connection con= DriverManager.getConnection(url,username,pwd);
		
		Statement stm=con.createStatement();
		
		ResultSet rs=stm.executeQuery("SELECT * FROM employee59");
		while(rs.next())
			System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+
															rs.getFloat(5)+"\t"+rs.getFloat(6)+"\t"+rs.getFloat(7));
		con.close();			
	}
}
