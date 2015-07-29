package model.dataaccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Connection.ConnectionPool;
import model.Connection.Queries;
import model.dto.UserProfileDto;
import model.model.Search;
import model.model.User;
public class SearchDao {

	public Search getUserProfDetails(String searchField,User u) {
		
		
		
		List<UserProfileDto> userProfileDtoCollection= new ArrayList<UserProfileDto>();
		
		PreparedStatement stmt = null;
	    try {
				stmt = ConnectionPool.getCon().prepareStatement(Queries.SEARCH_SEL_USER_ID_MAP_USER_PROF_DETAILS_USER_FRND_MAP);
				stmt.setInt(1,u.getUSER_ID());
				stmt.setString(2,"%"+searchField+"%");
				stmt.setString(3,"%"+searchField+"%");
				stmt.setInt(4,u.getUSER_ID());
		    
				ResultSet rs = stmt.executeQuery();	
				while(rs.next())
				{
					UserProfileDto userProfileDto = new UserProfileDto();
					userProfileDto.setUserId(rs.getInt(1));
					userProfileDto.setUserName(rs.getString(2));
					userProfileDto.setProfilePic(rs.getBlob(3));
					if((rs.getString(4)).equals("Y"))
						userProfileDto.setFrnd(true);
					else
						userProfileDto.setFrnd(false);
					
					userProfileDtoCollection.add(userProfileDto);
				}
		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    Search search = new Search();
	    search.setUserId(u.getUSER_ID());
	    search.setUserProfileDto(userProfileDtoCollection);
	    
	    return search;
	}
}
