package Database;
import java.io.*;
import java.util.*;
import java.sql.*;
public class ReadFileToTable {

	public static String Name;
	public static int Salary;
	public static int ID;
	
	public static void main(String[] args) {
		try {
			
			File myFile = new File("C:\\Users\\Admin\\eclipse-workspace\\Java_Programme\\src\\training_Java\\input.txt");
			Scanner reader = new Scanner(myFile);
			while(reader.hasNextLine()) {
				Name = "";
				String line = reader.nextLine();
				
				Scanner data = new Scanner(line);
				while(!data.hasNextInt()) {
					Name += data.next() + " ";
				}
				
				Name = Name.trim();
				
				if(data.hasNextInt()) {
					Salary = data.nextInt();
				}
				
				if(data.hasNextInt()) {
					ID = data.nextInt();
				}
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/demo_read_data_to_table";
				String username = "root";
				String password = "123456";
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement("Insert into Employees(Name, Salary, id) values(?, ?, ?);");
				
				pst.setString(1, Name);
				pst.setInt(2, Salary);
				pst.setInt(3, ID);
				
				pst.executeUpdate();
				
			}
		} catch(Exception e) {e.printStackTrace();}
	}

}
