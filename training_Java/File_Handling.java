package training_Java;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
public class File_Handling {
	
	public static void main(String[] args) {
		try {
			File myFile = new File("C:\\Users\\Admin\\eclipse-workspace\\Java_Programme\\src\\training_Java\\input.txt");
			if(myFile.createNewFile()) {
				System.out.println("File created : " + myFile.getName());
			} else {
				System.out.println("File already exists");
			}
			
//			FileWriter writer = new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\Java_Programme\\src\\training_Java\\input.txt");
//			writer.write("Rober Plunket   12000   67"
//					
//				    	+ "Stephen Edge  17000  43"
//				    	
//					    + "Julia Faller  9000  21");
//			writer.close();
			
			Scanner reader = new Scanner(myFile);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
