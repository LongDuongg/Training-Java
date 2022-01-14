package Database;
import java.sql.*;
import javax.sql.*;
import java.sql.Statement;


public class JDBCDemo {

	public static void main(String[] args) {
		System.out.println("Start to connect");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demojdbc";
			String username = "root";
			String password = "123456";
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			
			String query = "Select * From Student";
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int socot = rsmd.getColumnCount();
			
			for(int i = 1; i <= socot; i++) {
				System.out.print(rsmd.getColumnLabel(i) + " ");
			}
			System.out.println("\n");
			
			while(rs.next()) {
				for(int i = 1; i <= socot; i++) {
					System.out.print(rs.getObject(i) + " ");
				}
				System.out.println("\n");
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println("Error : " + e);
		}
	}

}
