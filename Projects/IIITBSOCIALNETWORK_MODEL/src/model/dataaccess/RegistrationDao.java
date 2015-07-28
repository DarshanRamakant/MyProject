package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Connection.ConnectionPool;
import model.Connection.Queries;
import model.model.Interest;
import model.model.Login;
import model.model.User;

import com.mysql.jdbc.Blob;

public class RegistrationDao {

	public void insertUserIDMap(Login l) {
		
		PreparedStatement stmt = null;
	    
		try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_ID_MAP);

		    stmt.setString(1,l.getROLL_NO());
		    stmt.setString(2,l.getEMAILID());
			stmt.execute();
		    		    
	    } catch (SQLException e) {
		
			e.printStackTrace();
		}

	}
	
	public void insertUserLogin(User u,Login l) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_LOGIN);

		    stmt.setInt(1,u.getUSER_ID());
		    stmt.setString(2,l.getPASSWORD());
			stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void insertUserProfDetails(User u) {
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_PROF_DETAILS);

		    stmt.setInt(1,u.getUSER_ID());
		    stmt.setString(2,u.getUSER_NAME());
		    stmt.setBlob(3,u.getPROFILE_PIC());
		    stmt.setString(4,u.getGENDER());
		    stmt.setInt(5,u.getCourse().getCourseId());
		    stmt.setString(6,u.getPHONE_NO());
			stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void insertUserInterests(User u) {
		PreparedStatement stmt = null;
	    try {
	    	
	    	for(Interest s:u.getUserInterests()){
				stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_INS_USER_INTERESTS);
	
			    stmt.setInt(1,u.getUSER_ID());
			    stmt.setInt(2,s.getInterestId());
				stmt.execute();
			
	    	}
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
	public User getUserId(Login l) {
		
		
		User u = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.REG_SEL_USER_ID_MAP);

		    stmt.setString(1,l.getROLL_NO());
		    stmt.setString(2,l.getEMAILID());
		     rs = stmt.executeQuery();
		   if(rs.next())
		   {
			   u = new User();
			   u.setROLL_NO(l.getROLL_NO());
			   u.setEMAIL(l.getEMAILID());
			   u.setUSER_ID( rs.getInt(1));
		   }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return u;

	}


}
