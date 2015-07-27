package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Connection.*;
public class SearchDao {

	public void getUserProfDetails(String ROLL_NO,String EMAILID,int USER_ID) {
		
		ResultSet rs = null;
		
		PreparedStatement stmt = null;
	    try {
				stmt = ConnectionPool.getCon().prepareStatement(Queries.SEARCH_SEL_USER_ID_MAP_USER_PROF_DETAILS_USER_FRND_MAP);
				stmt.setInt(1,USER_ID);
				stmt.setString(2,ROLL_NO);
				stmt.setString(3,EMAILID);
		    
				rs = stmt.executeQuery();		
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
