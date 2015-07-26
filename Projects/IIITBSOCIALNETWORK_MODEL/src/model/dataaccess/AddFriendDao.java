package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Connection.*;
public class AddFriendDao {

	
	public void insertUserFriend(int x,int y)
	{
		

		PreparedStatement stmt = null;
	    try {
			
	    	stmt = ConnectionPool.getCon().prepareStatement(Queries.FRND_INS_USER_FRND_MAP);

		    stmt.setInt(1, x);
		    stmt.setInt(2,y);
		    stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    return;
	}


}
