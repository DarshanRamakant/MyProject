package model.dataaccess;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Connection.*;
import model.dto.PostContentDto;
import model.model.User;
public class PostContentDao {

	public void insertUserPostContent(User u,String POST_CONTENT) {

		PreparedStatement stmt = null;
	    try {

	    	stmt = ConnectionPool.getCon().prepareStatement(Queries.NEWS_INS_USER_POST_DETAILS);
		    stmt.setInt(1, u.getUSER_ID());
		    stmt.setString(2,POST_CONTENT);
			stmt.execute();
		    		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
		
	}
	
	public User getUserPostContent(User u) {
	

		List<PostContentDto> postContentDtoCollection = new ArrayList<PostContentDto>();
		ResultSet rs = null;
		
		PreparedStatement stmt = null;
	    try {
			stmt = ConnectionPool.getCon().prepareStatement(Queries.NEWS_SEL_USER_FRND_MAP_USER_POST_DETAILS_USER_PROF_DETAILS);

			
		    stmt.setInt(1,u.getUSER_ID());
		    stmt.setInt(2,u.getUSER_ID());
		
		    rs = stmt.executeQuery();		
		    
		    while(rs.next())
		    {
		    	PostContentDto postContentDto = new PostContentDto();
		    	postContentDto.setUserName(rs.getString(1));
		    	postContentDto.setProfilePic(rs.getBlob(2));
				postContentDto.setPostContent(rs.getString(3));
				postContentDto.setPostTimeStamp(rs.getTimestamp(4));
				postContentDtoCollection.add(postContentDto);
		    }
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    u.setPostContentDto(postContentDtoCollection);
	    return u;
		
	}
}
