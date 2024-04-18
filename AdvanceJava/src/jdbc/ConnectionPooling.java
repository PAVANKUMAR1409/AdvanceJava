package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPooling {
	public String dburl,uName,pWord;
	public Vector<Connection> v=null;
	
	public ConnectionPooling(String dburl,String uName, String pWord, Vector<Connection> v)
	{
		this.dburl=dburl;
		this.uName=uName;
		this.pWord=pWord;
		this.v=v;
	}
	public void createConnection(int n)
	{
		try {
			while(v.size()<n)
			{
				Connection con=DriverManager.getConnection(dburl,uName,pWord);
				v.addElement(con); // adding to pool (Vector object)
				System.out.println(con);
			}//end of loop
			if(v.size()==n)
				System.out.println("Pool is Full........");
		}// end of try
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Connection useConnectionFromPool()
	{
		Connection con=v.elementAt(0);
		v.removeElementAt(0);
		return con;
	}
	public void returnConnectionBackToPool(Connection con)
	{
		v.addElement(con);
		System.out.println("Connection added back to the pool.......");
	}
	
}
