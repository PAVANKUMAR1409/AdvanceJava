package jdbc;

import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSet59 
{
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try 
			{
				RowSetFactory rsf= RowSetProvider.newFactory();
				System.out.println("*******CHOICE***********");
				System.out.println("\t1.JdbcRowSet"+"\n\t2.CachedRowSet");
				System.out.println("Enter the choice :");
				int choice=Integer.parseInt(s.nextLine());
				switch(choice)
				{
				case 1:
					JdbcRowSet jrs = rsf.createJdbcRowSet();
					jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
					jrs.setUsername("c##pavan");
					jrs.setPassword("pavankumar");
					jrs.setCommand("SELECT * FROM Product59");
					jrs.execute();
					System.out.println("===========Product Details===========");
					while(jrs.next())
					{
						System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getInt(4));
					}// end of while
					break;
				case 2:
					CachedRowSet crs= rsf.createCachedRowSet();
					crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
					crs.setUsername("c##pavan");
					crs.setPassword("pavankumar");
					crs.setCommand("SELECT * FROM Product59 WHERE code=?");
					System.out.println("enter the product code to display the details");
					String cd=s.nextLine();
					crs.setString(1, cd);
					crs.execute();
					if(crs.next())
						System.out.println(crs.getString(1)+"\t"+crs.getString(2)+"\t"+crs.getFloat(3)+"\t"+crs.getInt(4));
					else
						System.out.println("Please enter correct product code");
					break;
				}// end of switch
			}
			catch(Exception e)
			{
					e.printStackTrace();
			}
		}// end of try with resource
	}
}
