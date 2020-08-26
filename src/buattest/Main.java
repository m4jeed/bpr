package buattest;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.Properties;


	
public class Main {
	public static void main(String[] args) { 
		Connection dbConnection = null; try { 
			
			String url = "jdbc:mysql://192.168.1.2:3306/numbers";
			Properties info = new Properties(); 
			info.put("user", "root"); 
			info.put("password", "bprcfit"); 
			dbConnection = DriverManager.getConnection(url, info); if (dbConnection != null) 
			{ 
				System.out.println("Successfully connected to MySQL database test"); 
			} 
			} catch (SQLException ex) { 
				System.out.println("An error occurred while connecting MySQL databse"); ex.printStackTrace(); 
				} 
		}

	
}
