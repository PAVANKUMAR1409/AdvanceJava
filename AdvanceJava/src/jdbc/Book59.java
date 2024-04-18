package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book59 extends Book59Main
{
	Scanner sc= new Scanner(System.in);
	static Connection con=null;
	static PreparedStatement ps1=null, ps2=null, ps3=null,ps4=null, ps5=null;
	static ResultSet rs=null,rs2=null,rs3=null;
	void connection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String username="c##pavan";
			String pwd="pavankumar";
			con = DriverManager.getConnection(url,username,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	void AddBook() throws SQLException
	{
		ps1=con.prepareStatement("INSERT INTO Book59 VALUES(?,?,?,?,?)");
		
		System.out.println("Enter Book code");
		int bcode=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Book name");
		String bname=sc.nextLine();
		System.out.println("Enter Book author");
		String bauthor = sc.nextLine();
		System.out.println("Enter Book Price");
		float bprice=Float.parseFloat(sc.nextLine());
		System.out.println("Enter Book qty");
		int bqty=Integer.parseInt(sc.nextLine());
		
		ps1.setInt(1, bcode);
		ps1.setString(2, bname);
		ps1.setString(3, bauthor);
		ps1.setFloat(4, bprice);
		ps1.setInt(5, bqty);
		
		int k=ps1.executeUpdate();
		if(k>0)
		{
			System.out.println("1 ROW CREATED....!");
		}
		
	}
	void ViewAllBooks() throws SQLException
	{
		ps2=con.prepareStatement("SELECT * FROM Book59");
		
		rs=ps2.executeQuery();
		while(rs.next())
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+
					rs.getFloat(4)+"\t"+rs.getInt(5));
	}
	void ViewBookByCode() throws SQLException
	{
		ps3=con.prepareStatement("SELECT * FROM Book59 WHERE bcode=?");
		
		System.out.println("Enter the Book Code");
		int bcode2=Integer.parseInt(sc.nextLine());
		ps3.setInt(1, bcode2);
		
		rs2=ps3.executeQuery();
		if(rs2.next())
			System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+
					rs2.getFloat(4)+"\t"+rs2.getInt(5));
	}
	void UpadteBookDetailsByCode() throws SQLException
	{
		ps3=con.prepareStatement("SELECT * FROM Book59 WHERE bcode=?");
		ps4=con.prepareStatement("UPDATE Book59 SET bprice=?,bqty=bqty+? WHERE bcode=?");
		
		System.out.println("Enter the Book Code");
		int bcode3=Integer.parseInt(sc.nextLine());
		ps3.setInt(1, bcode3);
		rs3=ps3.executeQuery();
		if(rs3.next())
		{
			System.out.println("The old price of Book is : "+rs3.getFloat(4));
			System.out.println("Enter new price ");
			float bprice2=Float.parseFloat(sc.nextLine());
			System.out.println("The old qty of book is : "+rs3.getInt(5));
			System.out.println("Enter new qty");
			int bqty2=Integer.parseInt(sc.nextLine());
			
			ps4.setInt(3, bcode3);
			ps4.setFloat(1, bprice2);
			ps4.setInt(2, bqty2);
			
			int k=ps4.executeUpdate();
			if(k>0)
				System.out.println("1 ROW UPDATED.....!");
		}
		else {
			System.out.println("INVALID CODE.....!");
		}
	}
	void DeleteBookByCode() throws SQLException
	{
		ps3=con.prepareStatement("SELECT * FROM Book59 WHERE bcode=?");
		ps5=con.prepareStatement("DELETE FROM Book59 WHERE bcode=?");
		
		System.out.println("Enter the Book code to delete...");
		int bcode4=Integer.parseInt(sc.nextLine());
		ps3.setInt(1, bcode4);
		rs3=ps3.executeQuery();
		if(rs3.next()) {
			ps5.setInt(1,bcode4);
			int k=ps5.executeUpdate();
			if(k>0)
				System.out.println("1 ROW DELETE .......!");
		}
		else {
			System.out.println("INVALID CODE......!");
		}
	}
	
	
}
