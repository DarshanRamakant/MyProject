package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Connection.*;
public class AddFriendDao {
	
	
	public void addFriendById(int x,int y)
	{
		this.addFriend(x, y);
		this.addFriend(y, x);
	}
	
	private boolean addFriend(int x,int y)
	{
		boolean rs=false;

		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.FRND_INS_USER_FRND_MAP);

		    stmt.setInt(1, x);
		    stmt.setInt(2,y);
		    
		    rs = stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return rs;
	}


}
