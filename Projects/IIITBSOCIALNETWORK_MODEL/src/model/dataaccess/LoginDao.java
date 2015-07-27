package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Connection.*;
public class LoginDao {

	
	public Integer getUserLoginId(String ROLL_NO,String EMAILID,String PASSWORD) {

		Integer USER_ID = null;
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.LOGIN_SEL_USER_ID_MAP_USER_LOGIN);

		    stmt.setString(1,ROLL_NO);
		    stmt.setString(2,EMAILID);
		    stmt.setString(3,PASSWORD);
		    
		    
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
