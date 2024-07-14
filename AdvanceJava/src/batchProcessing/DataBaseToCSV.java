//DataBaseToCSV.java
package batchProcessing;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseToCSV {

	static long count;
	public static void main(String[] args) throws Exception {
		
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar1425");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_info");
			ResultSet rs = ps.executeQuery();
			FileWriter fw = new FileWriter("E:\\emp_info.csv");
			fw.write("ID,FNAME,LNAME,MAILID,GENDER");
			while(rs.next()) {
				String format = String.format("%s, %s, %s, %s, %s", rs.getString(1), rs.getString(2),
								rs.getString(3),rs.getString(4),rs.getString(5));
				fw.append('\n');
				fw.write(format);
				count++;
				
			}
			System.out.println(count+" Data Saved to the Files");
			fw.close();
		}//try
		catch(Exception e) {e.printStackTrace();}
	}
}
