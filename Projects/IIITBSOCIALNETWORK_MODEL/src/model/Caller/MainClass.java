package model.Caller;


import java.sql.SQLException;

import model.Connection.ConnectionPool;
import model.dataaccess.AddFriendDao;
import model.dataaccess.LoginDao;
import model.dataaccess.PostContentDao;
import model.dataaccess.RegistrationDao;
import model.dataaccess.SearchDao;

public class MainClass {
	
	public static void main(String args[]) throws SQLException {
		
		ConnectionPool.createConnection();
		AddFriendDao addFriendDao = new AddFriendDao();
		LoginDao loginDao = new LoginDao();
		PostContentDao postContentDao = new PostContentDao();
		RegistrationDao registrationDao = new RegistrationDao();
		SearchDao searchDao = new SearchDao();
		
		/* Test Data */
		String ROLL_NO1 = "Anand";
		String EMAILID1 = "Test";
		String PASSWORD1 = "PASS";
		String NAME1 = "Anand";
		String GENDER1 = "M";
		String PHONE_NO1 = "9962547546";
		String POST_CONTENT1 = "Hello World";
		
		String ROLL_NO2 = "Anand1";
		String EMAILID2 = "Test1";
		String PASSWORD2 = "PASS1";
		String NAME2 = "Anand1";
		String GENDER2 = "M";
		String PHONE_NO2 = "9962547541";
		String POST_CONTENT2 = "Hello World 1";
		
		int USER_ID = 1;
		int FRND_ID = 2;
		
		int interestId = 1;
		int COURSE_ID = 1;
		
		registrationDao.insertUserIDMap(ROLL_NO1, EMAILID1);
		
		registrationDao.getUserId(ROLL_NO1, EMAILID1);
		
		registrationDao.insertUserLogin(USER_ID, PASSWORD1);
		
		registrationDao.insertUserProfDetails(USER_ID, NAME1, null, GENDER1, COURSE_ID, PHONE_NO1);
		
		registrationDao.insertUserInterest(USER_ID, interestId);
		
		loginDao.getUserLoginId(ROLL_NO1, EMAILID1, PASSWORD1);
		
		registrationDao.insertUserIDMap(ROLL_NO2, EMAILID2);
		
		registrationDao.getUserId(ROLL_NO2, EMAILID2);
		
		registrationDao.insertUserLogin(FRND_ID, PASSWORD2);
		
		registrationDao.insertUserProfDetails(USER_ID, NAME2, null, GENDER2, COURSE_ID, PHONE_NO2);
		
		registrationDao.insertUserInterest(FRND_ID, interestId);
		
		loginDao.getUserLoginId(ROLL_NO2, EMAILID2, PASSWORD2);
	
		
		addFriendDao.insertUserFriend(USER_ID, FRND_ID);
		
		addFriendDao.insertUserFriend(FRND_ID, USER_ID);
		
		postContentDao.insertUserPostContent(USER_ID, POST_CONTENT1);
		
		postContentDao.insertUserPostContent(FRND_ID, POST_CONTENT2);
		
		postContentDao.getUserPostContent( USER_ID);
		
		postContentDao.getUserPostContent( FRND_ID);
		
		searchDao.searchUserProfDetails(ROLL_NO2, EMAILID2, USER_ID);

		
		ConnectionPool.closeConnection();
		
		
		
	}
	

	
}