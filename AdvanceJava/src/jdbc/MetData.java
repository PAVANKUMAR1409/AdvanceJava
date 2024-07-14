package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class MetData 
{
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con= DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar1425");
				System.out.println("*********DATABASE METADATA*************");
				DatabaseMetaData dmd=con.getMetaData();
				System.out.println("driver version : "+dmd.getDriverVersion());
				System.out.println("driver Major version : "+dmd.getDriverMajorVersion());
				System.out.println("driver Minor version : "+dmd.getDriverMinorVersion());
				System.out.println("driver  Driver Name : "+dmd.getDriverName());
				
				System.out.println("*********PARAMETER METADATA*************");
				PreparedStatement ps=con.prepareStatement("UPDATE Bank59 SET bal=? WHERE accno=?");
				ParameterMetaData pmd=ps.getParameterMetaData();
				System.out.println("count of parameters : "+pmd.getParameterCount());
				System.out.println("parameter mode : "+pmd.getParameterMode(1));
				
				System.out.println("*********RESULTSET METADATA*************");
				PreparedStatement ps2=con.prepareStatement("SELECT accno,bal FROM Bank59");
				ResultSet rs=ps2.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				System.out.println("colums count : "+rsmd.getColumnCount());
				System.out.println("coulmns name : "+rsmd.getColumnClassName(2));
				System.out.println("Coumn label : "+rsmd.getColumnLabel(1));
				
				
			}// end of try
			catch(Exception e) {e.printStackTrace();}
		}//end of try with resources
	}
}
