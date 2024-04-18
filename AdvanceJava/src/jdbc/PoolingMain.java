package jdbc;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class PoolingMain
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try 
			{
				System.out.println("Enter DB-Url : ");
				String dburl=s.nextLine();
				System.out.println("Enter username : ");
				String uName=s.nextLine();
				System.out.println("Enter password : ");
				String pWord=s.nextLine();
				ConnectionPooling cp=new ConnectionPooling(dburl,uName,pWord,new Vector<Connection>());
				
				System.out.println("Enter number of connection : ");
				int n=s.nextInt();
				cp.createConnection(n);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("=====user pavan=====");
				Connection con1=cp.useConnectionFromPool();
				System.out.println(con1);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("=====user surya=====");
				Connection con2=cp.useConnectionFromPool();
				System.out.println(con2);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("=====user radha=====");
				Connection con3=cp.useConnectionFromPool();
				System.out.println(con3);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("=====user pavan=====");
				cp.returnConnectionBackToPool(con1);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("=====user surya=====");
				cp.returnConnectionBackToPool(con2);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("=====user radha=====");
				cp.returnConnectionBackToPool(con3);
				System.out.println("Pool size : "+cp.v.size());
				
				System.out.println("******DISPLAY CONNECTIONS**********");
				Iterator<Connection> it = cp.v.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
			}
			catch(Exception e)
			{
				
			}
		}// end of try with resource
	}
}
