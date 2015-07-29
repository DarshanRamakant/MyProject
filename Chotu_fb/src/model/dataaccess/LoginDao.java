package model.dataaccess;
import model.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Connection.*;
import model.model.Course;
import model.model.Interest;
import model.model.Login;
import model.model.User;
public class LoginDao {

	
	public User getUserLoginId(Login login) {
		User user = new User();
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.LOGIN_SEL_USER_ID_MAP_USER_LOGIN);

		    stmt.setString(1,login.getROLL_NO());
		    stmt.setString(2,login.getEMAILID());
		    stmt.setString(3,login.getPASSWORD());
		    ResultSet rs = stmt.executeQuery();
		   
		    while(rs.next())
		    {
		    	user.setUSER_ID( rs.getInt(1));
		    	System.out.println(rs.getInt(1));
		    }
		    	user.setROLL_NO(login.getROLL_NO());
		   user.setEMAIL(login.getEMAILID());
		   
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return user;
	}
	
	public User getUserProfDetails(User u) {
		
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.LOGIN_SEL_USER_PROF_DETAILS);

		    stmt.setInt(1,u.getUSER_ID());
		   
		    ResultSet rs = stmt.executeQuery();
		   
		    while(rs.next()){
		    	Course c = new Course();
		    	c.setCourseId(rs.getInt(4));
		    	c.setCourseDesc(rs.getString(5));
		    	
		    	u.setUSER_NAME(rs.getString(1));
		    	u.setGENDER(rs.getString(3));
		    	u.setPHONE_NO(rs.getString(6));
		    	u.setCourse(c);
		    	u.setPROFILE_PIC(rs.getBlob(2));
		    }
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return u;
	}


public User getUserInterests(User u) {
	
	List<Interest> userInterests = new ArrayList<Interest>();
	PreparedStatement stmt = null;
    try {
		stmt = ConnectionPool.getCon().prepareStatement(Queries.LOGIN_SEL_USER_INTERESTS);

	    stmt.setInt(1,u.getUSER_ID());
	   
	    ResultSet rs = stmt.executeQuery();
	   
	    while(rs.next()){
	    	Interest ui = new Interest();
	    	ui.setInterestId(rs.getInt(1));
	    	ui.setInterstDesc(rs.getString(2));
	    	userInterests.add(ui);
	    }
    
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    u.setUserInterests(userInterests);
    return u;
}
}
