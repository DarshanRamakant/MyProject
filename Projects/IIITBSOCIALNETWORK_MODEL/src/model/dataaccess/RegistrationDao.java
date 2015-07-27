package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Connection.ConnectionPool;
import model.Connection.Queries;

import com.mysql.jdbc.Blob;

public class RegistrationDao {

	public void insertUserIDMap(String ROLL_NO,String EMAILID) {
		
		PreparedStatement stmt = null;
	    
		try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_ID_MAP);

		    stmt.setString(1,ROLL_NO);
		    stmt.setString(2,EMAILID);
			stmt.execute();
		    		    
	    } catch (SQLException e) {
		
			e.printStackTrace();
		}

	}
	
	public void insertUserLogin(int USER_ID,String PASSWORD) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_LOGIN);

		    stmt.setInt(1,USER_ID);
		    stmt.setString(2,PASSWORD);
			stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void insertUserProfDetails(int USER_ID,String USER_NAME,Blob PROFILE_PIC,String GENDER,int COURSE_ID,String PHONE_NO) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_PROF_DETAILS);

		    stmt.setInt(1,USER_ID);
		    stmt.setString(2,USER_NAME);
		    stmt.setBlob(3,PROFILE_PIC);
		    stmt.setString(4,GENDER);
		    stmt.setInt(5,COURSE_ID);
		    stmt.setString(6,PHONE_NO);
			stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void insertUserInterest(int userId,int interestId) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_INTERESTS);

		    stmt.setInt(1,userId);
		    stmt.setInt(2,interestId);
			stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
	public Integer getUserId(String ROLL_NO,String EMAILID) {
		
		
		Integer USER_ID = null;
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_SEL_USER_ID_MAP);

		    stmt.setString(1,ROLL_NO);
		    stmt.setString(2,EMAILID);
		    ResultSet rs = stmt.executeQuery();
		    
		    if(rs.getFetchSize()>1)
		    		throw new SQLException();
		    
		    if(rs.getFetchSize()==1)
		    	USER_ID = new Integer(rs.getInt(1));
			
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return USER_ID;

	}


}
