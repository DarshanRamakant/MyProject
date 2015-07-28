package view;

import java.util.ArrayList;
import java.util.List;

import model.Connection.ConnectionPool;
import model.dto.PostContentDto;
import model.dto.UserProfileDto;
import model.model.*;
import controller.*;

public class mainClass {

	public static void main(String args[]) {
		ConnectionPool.createConnection();
		
				
		//CourseList();
		//InterestList();
		register();
		//login();
		//searchFrnds();
		//postContent();
		//addFrnd();
		ConnectionPool.closeConnection();
		
	}
	
	public static void searchFrnds()
	{
		SearchController searchController = new SearchController();
		
		Course c = new Course();
		c.setCourseId(1);
		c.setCourseDesc("IT");
		List<Interest> userInterests = new ArrayList<Interest>();
		Interest i = new Interest();
		i.setInterestId(1);
		i.setInterstDesc("Coding");
		userInterests.add(i);
		
		User u1 = new User();
		u1.setUSER_ID(1);
		u1.setUSER_NAME("Anand");
		u1.setGENDER("M");
		u1.setPHONE_NO("9962547546");
		u1.setPROFILE_PIC(null);
		u1.setUserInterests(userInterests);
		u1.setCourse(c);
		
		Search s = searchController.search("MT2015011", u1);
		List<UserProfileDto> u = s.getUserProfileDto();
		
		for(UserProfileDto up :u)
		{
			System.out.println("User Id - " + up.getUserId()+" User Name - " + up.getUserName()+" Is Frnd -" + up.isFrnd());
		}
		
	}
	public static void addFrnd()
	{
		SearchController searchController = new SearchController();
		Course c = new Course();
		c.setCourseId(1);
		c.setCourseDesc("IT");
		List<Interest> userInterests = new ArrayList<Interest>();
		Interest i = new Interest();
		i.setInterestId(1);
		i.setInterstDesc("Coding");
		userInterests.add(i);
		
		User u1 = new User();
		u1.setUSER_ID(1);
		u1.setUSER_NAME("Anand");
		u1.setGENDER("M");
		u1.setPHONE_NO("9962547546");
		u1.setPROFILE_PIC(null);
		u1.setUserInterests(userInterests);
		u1.setCourse(c);
		

		Search s = searchController.addFriend("MT2015011", 2, u1);
		List<UserProfileDto> u = s.getUserProfileDto();
		for(UserProfileDto up :u)
		{
			System.out.println("User Name - " + up.getUserName()+" Is Frnd -" + up.isFrnd());
		}
		
	}

	public static void register()
	{
		UserController userController = new UserController();
		
		Course c = new Course();
		c.setCourseId(1);
		c.setCourseDesc("IT");
		
		List<Interest> userInterests = new ArrayList<Interest>();
		
		Interest i = new Interest();
		i.setInterestId(1);
		i.setInterstDesc("Coding");
		
		userInterests.add(i);
		
		User u1 = new User();
		u1.setUSER_NAME("Anand");
		u1.setGENDER("M");
		u1.setPHONE_NO("9962547546");
		u1.setPROFILE_PIC(null);
		u1.setUserInterests(userInterests);
		u1.setCourse(c);
		
		Login l1 = new Login();
		l1.setEMAILID("anandkk1989@gmail.com");
		l1.setROLL_NO("MT2015010");
		l1.setPASSWORD("Pass");
		
		userController.registration(l1, u1);
		
		User u2 = new User();
		u2.setUSER_NAME("N Anand");
		u2.setGENDER("M");
		u2.setPHONE_NO("9962547546");
		u2.setPROFILE_PIC(null);
		u2.setUserInterests(userInterests);
		u2.setCourse(c);
		
		Login l2 = new Login();
		l2.setEMAILID("nanduettimadai@yahoo.com");
		l2.setROLL_NO("MT2015011");
		l2.setPASSWORD("Pass");
		
		userController.registration(l2, u2);
		
	}
	
	public static void postContent()
	{
		UserController userController = new UserController();
		
		Course c = new Course();
		c.setCourseId(1);
		c.setCourseDesc("IT");
		List<Interest> userInterests = new ArrayList<Interest>();
		Interest i = new Interest();
		i.setInterestId(1);
		i.setInterstDesc("Coding");
		userInterests.add(i);
		
		User u1 = new User();
		u1.setUSER_ID(1);
		u1.setUSER_NAME("Anand");
		u1.setGENDER("M");
		u1.setPHONE_NO("9962547546");
		u1.setPROFILE_PIC(null);
		u1.setUserInterests(userInterests);
		u1.setCourse(c);
		
		u1 = userController.userPostContent(u1, "Hello World");
		
		List<PostContentDto> pc = u1.getPostContentDto();
		
		for(PostContentDto p :pc)
		{
			System.out.println("User Name - " + p.getUserName()+" Post Content - " + p.getPostContent() + " Timestamp - " + p.getPostTimeStamp());
		}
		
	}
	
	public static void login()
	{
		LoginController loginController = new LoginController();
		Login l = new Login();
		l.setEMAILID("anandkk1989@gmail.com");
		l.setROLL_NO("MT2015010");
		l.setPASSWORD("Pass");
		User u = loginController.login(l);
		System.out.println("User Id - " + u.getUSER_ID());
	}
	
	public static void CourseList()
	{
		CourseController courseController = new CourseController();	
		List<Course> l = courseController.listCourses();
		for(Course c :l)
		{
			System.out.println("Course Id - " + c.getCourseId()+" Course Name -" + c.getCourseDesc());
		}
	}
	
	public static void InterestList()
	{
		InterestController interestController = new InterestController();	
		List<Interest> l = interestController.listInterests();
		for(Interest c :l)
		{
			System.out.println("Interest Id - " + c.getInterestId()+" Interest Name -" + c.getInterstDesc());
		}
	}
}
