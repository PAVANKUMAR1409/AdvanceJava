package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Product59 
{
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
				String username="c##pavan";
				String pwd="pavankumar";
				Connection con = DriverManager.getConnection(url,username,pwd);
				
				PreparedStatement ps1=con.prepareStatement("INSERT INTO Product59 VALUES(?,?,?,?)");// Compilation
				
				PreparedStatement ps2= con.prepareStatement("SELECT * FROM Product59"); // compilation
				
				PreparedStatement ps3 = con.prepareStatement("SELECT * FROM Product59 WHERE code=?"); //compilation
				
				PreparedStatement ps4 = con.prepareStatement("UPDATE Product59 SET price=?,qty=qty+? WHERE code=?"); // Compilation
				
				PreparedStatement ps5 = con.prepareStatement("DELETE FROM Product59 WHERE code=?");
				
				while(true)
				{
					System.out.println("*********CHOICE**********");
					System.out.println("1.Add Product"+"\n"+
											"2. View All Product"+"\n"+
												"3. View Product BY code"+"\n"+
											"4. Update Product By Code"+"\n"+
												"5. Delete Product By Code"+"\n"+
												"6. To Exit ");
					
					System.out.println("Select the option : ");
					int choice = Integer.parseInt(s.nextLine());
					
					switch(choice)
					{
					case 1: // Inserting Product Details
						System.out.println("Enter Product Code");
						//s.nextLine();
						String code=s.nextLine();
						System.out.println("Enter Product Name");
						String name =s.nextLine();
						System.out.println("Enter Product Price");
						float price=Float.parseFloat(s.nextLine());
						System.out.println("Enter Product Qty");
						int qty=Integer.parseInt(s.nextLine());
						
						// assigning the value to parameter
						ps1.setString(1, code);
						ps1.setString(2, name);
						ps1.setFloat(3, price);
						ps1.setInt(4, qty);
						
						int k= ps1.executeUpdate();
						if(k>0)
							System.out.println("1 ROW CREATED.....");
						break;
					case 2:// View All Product
						ResultSet rs=ps2.executeQuery();
						System.out.println("==========Product Details===========");
						while(rs.next())
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
									rs.getInt(4));
						break;
					case 3:// View Product By Code
						System.out.println("Enter the Code of Product");
						//s.nextLine(); // not needed because we used pareInt();
						String code1=s.nextLine();
						//assigning the value to in parameter
						ps3.setString(1, code1);
						
						ResultSet rs2=ps3.executeQuery();
						System.out.println("Product Details of Specified Code......");
						while(rs2.next())
							System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+
													rs2.getFloat(3)+"\t"+rs2.getInt(4));
						break;
					case 4:
						System.out.println("Enter the Product code for Upadting...!");
						String code2=s.nextLine();
						ps3.setString(1,code2);
						ResultSet rs3=ps3.executeQuery();
						if(rs3.next())
						{
							System.out.println("Product Old Price : "+rs3.getFloat(3));
							System.out.println("Enter the new Product price : ");
							Float nPrice=Float.parseFloat(s.nextLine());
							System.out.println("Product Old Qty : "+rs3.getInt(4));
							System.out.println("Enter new Product qty :");
							int nqty=Integer.parseInt(s.nextLine());
							
							ps4.setFloat(1,nPrice);
							ps4.setInt(2, nqty);
							ps4.setString(3, code2);
							
							int k2= ps4.executeUpdate();
							if(k2>0)
							{
								System.out.println("1 ROW UPDATED...!");
							}
						}
						else {
							System.out.println("Invalid Product Code...!");
						}
						break;
					case 5:
						System.out.println("Enter the Product Code for Deleting....!");
						String code3=s.nextLine();
						ps3.setString(1, code3);
						ResultSet rs4=ps3.executeQuery();
						if(rs4.next())
						{
							ps5.setString(1, code3);
							int k3 = ps5.executeUpdate();
							if(k3>0) {
								System.out.println("1 ROW DELETED......!");
							}
						}else {
							System.out.println("Invalid Product Code.....!");
						}
						break;
					case 6 : 
						System.out.println("JVM SHUT DOWNS.....");
						System.exit(0);
						//break; No need break becoz exit() will stop the operation
					default :
						System.out.println("INVALID OPTION....");
						break;
						
					}// end of Switch
				}// end of while loop
			}// end of try
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}// end of try with resources
	}
}
