package Database;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.io.*;

public class De_Thi_Tham_Khao_2 {
	
	public static Date date;
	public static String MaHocVien = null;
	public static String TenHocVien = null;
	public static String NgaySinh = null;
	public static String GioiTinh = null;
	public static float DiemThi;
	
	public static void main(String[] arg) {
		
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
				
//				System.out.println(MaHocVien + " " + TenHocVien + " " + NgaySinh + " " + GioiTinh + " " + DiemThi);
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/de_thi";
				String username = "root";
				String password = "123456";
				
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement stm = con.prepareStatement("Insert into hocvien(MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) Values(?, ?, ?, ?, ?)");
				
				stm.setString(1, MaHocVien);
				stm.setString(2, TenHocVien);
				stm.setDate(3, date);
				stm.setString(4, GioiTinh);
				stm.setFloat(5, DiemThi);
				
				stm.executeUpdate();
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
