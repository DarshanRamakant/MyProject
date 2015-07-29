package model.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.ConnectionPool;
import model.Connection.Queries;
import model.model.Course;
import model.model.Interest;

public class InterestDao {

	
	public List<Interest> getInterestList()
	{
		List<Interest> interestList = new ArrayList<Interest>();
		Statement stmt = null;
		
		try {
			
			stmt = ConnectionPool.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(Queries.MASTER_INTEREST);
			while(rs.next())
			{
				Interest s = new Interest();
				s.setInterestId(rs.getInt(1));
				s.setInterstDesc(rs.getString(2));
				interestList.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return interestList;
	}

}
