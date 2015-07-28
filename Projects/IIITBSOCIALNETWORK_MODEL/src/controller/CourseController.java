package controller;

import java.util.List;

import model.dataaccess.CourseDao;
import model.model.*;

public class CourseController {
	public CourseController()
	{
		this.courseDao = new CourseDao();
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	CourseDao courseDao;
	
	public List<Course> listCourses()
	{
		return this.getCourseDao().getCourseList();
	}
	
}
