package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Connection.*;
public class PostContentDao {

	public void postContent(int USER_ID,String POST_CONTENT) {
		
	

		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.NEWS_INS_USER_POST_DETAILS);

		    stmt.setInt(1, USER_ID);
		    stmt.setString(2,POST_CONTENT);
			boolean rs = stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void displayContent(int FRND_ID,int USER_ID) {
	

		ResultSet rs = null;
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.NEWS_SEL_USER_FRND_MAP_USER_POST_DETAILS_USER_PROF_DETAILS);

		    stmt.setInt(1,FRND_ID);
		    stmt.setInt(2,USER_ID);
		
		    rs = stmt.executeQuery();		
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
