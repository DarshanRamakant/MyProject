package model.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.model.*;

import model.Connection.*;

public class CourseDao {
	
	public List<Course> getCourseList()
	{
		List<Course> courseList = new ArrayList<Course>();
		
		
		try {
			
			Statement stmt = ConnectionPool.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(Queries.MASTER_COURSE);
			while(rs.next())
			{
				Course c = new Course();
				c.setCourseId(rs.getInt(1));
				c.setCourseDesc(rs.getString(2));
				courseList.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return courseList;
	}

}
