package model.Caller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dataaccess.*;

import model.Connection.ConnectionPool;
import model.Connection.Queries;

public class MainClass {
	
	public static void main(String args[]) throws SQLException {
		
		ConnectionPool.createConnection();
			    
		
		ConnectionPool.closeConnection();
		
		
		
	}
}