package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class Book59Main 
{
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		Book59 obj=new Book59();
		obj.connection();
		
		while(true)
		{
			System.out.println("*********CHOICE**********");
			System.out.println("1.Add Book"+"\n"+
									"2. View All Books"+"\n"+
										"3. View Book BY code"+"\n"+
									"4. Update Book By Code"+"\n"+
										"5. Delete Book By Code"+"\n"+
										"6. To Exit ");
			
			System.out.println("Select the option : ");
			int choice = Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:obj.AddBook();
				break;
			case 2:obj.ViewAllBooks();
				break;
			case 3:obj.ViewBookByCode();
				break;
			case 4:obj.UpadteBookDetailsByCode();
				break;
			case 5:obj.DeleteBookByCode();
				break;
			case 6:// to exit
				System.out.println("JVM SHUT DOWNS....!");
				System.exit(0);
			default :
				System.out.println("Invalid choice.....!");
			}
		}//end of while
	}
}
