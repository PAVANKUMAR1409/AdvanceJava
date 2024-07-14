package batchProcessing;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CSVToDataBase {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##pavan","pavankumar1425");
			PreparedStatement ps = con.prepareStatement("INSERT INTO emp_info VALUES(?,?,?,?,?)");
			
			FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Downloads\\emp_info.csv");
			
			Scanner sc= new Scanner(fis);
			sc.nextLine();
			while(sc.hasNext()) {
				//System.out.println(sc.nextLine());
				String line = sc.nextLine();
				String[] split = line.split(",");
				for(int i=1;i<=split.length;i++) {
					ps.setString(i, split[i-1]);
				}
				
				//ps.executeUpdate();
				ps.addBatch();
				
			}//while
			ps.executeBatch();
			System.out.println("Batch Processing Done");
			sc.close();
		}// try
		catch(Exception e) {e.printStackTrace();}
		
	}
}
