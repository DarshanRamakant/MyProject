package model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
		final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final static String DB_URL = "jdbc:mysql://localhost/IIITBSOCIALNETWORK";
		final static String USER = "root";
		final static String PASS = "";
		private static Connection con;
		public static void createConnection()
		{
			if(getCon()==null)
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					setCon(DriverManager.getConnection(DB_URL, USER, PASS));
					System.out.println("Connection DOne !!");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return;
		}
		
		public static void closeConnection()
		{
			try {
				if(getCon()!=null)
					getCon().close();
				System.out.println("Connection Closed Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static Connection getCon() {
			return con;
		}

		public static void setCon(Connection con) {
			ConnectionPool.con = con;
		}
	}

