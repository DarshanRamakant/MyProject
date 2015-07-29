package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Connection.*;
import model.model.User;
public class AddFriendDao {

	
	public void insertUserFriend(User user,int frndId)
	{
		

		PreparedStatement stmt = null;
	    try {
			
	    	stmt = ConnectionPool.getCon().prepareStatement(Queries.FRND_INS_USER_FRND_MAP);

		    stmt.setInt(1, user.getUSER_ID());
		    stmt.setInt(2,frndId);
		    stmt.execute();
		    
		    stmt = ConnectionPool.getCon().prepareStatement(Queries.FRND_INS_USER_FRND_MAP);

		
		    stmt.setInt(1,frndId);
		    stmt.setInt(2, user.getUSER_ID());
		    stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    return;
	}


}
