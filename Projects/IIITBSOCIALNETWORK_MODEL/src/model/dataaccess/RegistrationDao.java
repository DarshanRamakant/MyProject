package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Blob;

import model.Connection.*;
public class RegistrationDao {

	public static void registrationUser(String regNo,String email) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_ID_MAP);

		    stmt.setString(1,regNo);
		    stmt.setString(2,email);
			boolean rs = stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void InsertUserLogin(int userId,String pswrd) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_LOGIN);

		    stmt.setInt(1,userId);
		    stmt.setString(2,pswrd);
			boolean rs = stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void InsertProfile(int userId,String name,Blob pic,String gender,String course,int phoneNo) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_PROF_DETAILS);

		    stmt.setInt(1,userId);
		    stmt.setString(2,name);
		    stmt.setBlob(3,pic);
		    stmt.setString(4,gender);
		    stmt.setString(5,course);
		    stmt.setInt(6,phoneNo);
			boolean rs = stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void InsertInterests(int userId,int interestId) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_INTERESTS);

		    stmt.setInt(1,userId);
		    stmt.setInt(2,interestId);
			boolean rs = stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
	public static void getUserId(String regNo,String email) {
		
		ResultSet rs;
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_SEL_USER_ID_MAP);

		    stmt.setString(1,regNo);
		    stmt.setString(2,email);
			 rs = stmt.executeQuery();
			
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
