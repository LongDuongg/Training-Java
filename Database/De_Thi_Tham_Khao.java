package Database;
import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.util.*;

public class De_Thi_Tham_Khao {
	
	public static Date date;
	public static String MaHocVien = null;
	public static String TenHocVien = null;
	public static String NgaySinh = null;
	public static String GioiTinh = null;
	public static float DiemThi;
	
	
	public static void main(String[] args)  {
		try {
						
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Java_Programme\\src\\Database\\input.txt");
			Scanner reader = new Scanner(file);
			
			while(reader.hasNextLine()) {

				MaHocVien = reader.next();
				
				TenHocVien = reader.next() + " " + reader.next() + " " + reader.next();
				
				NgaySinh = reader.next();
				
				date = Date.valueOf(NgaySinh);
				
				GioiTinh = reader.next();
				
				DiemThi = reader.nextFloat();
				
//				System.out.println(MaHocVien + " " + TenHocVien + " " + date + " " + GioiTinh + " " + DiemThi);
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/final_test";
				String username = "root";
				String password = "123456";
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement("Insert into HocVien(MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) Values(?, ?, ?, ?, ?);");
				
				pst.setString(1, MaHocVien);
				pst.setString(2, TenHocVien);
				pst.setDate(3, date);
				pst.setString(4, GioiTinh);
				pst.setFloat(5, DiemThi);
					
				pst.executeUpdate();
			}
			
			reader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
