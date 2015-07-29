package controller;

import model.dataaccess.PostContentDao;
import model.dataaccess.RegistrationDao;
import model.model.Login;
import model.model.User;

public class UserController {

	public UserController()
	{
		this.postContentDao = new PostContentDao();
		this.registrationDao = new RegistrationDao();
	}
	RegistrationDao registrationDao;
	PostContentDao postContentDao;
	
	public PostContentDao getPostContentDao() {
		return postContentDao;
	}



	public void setPostContentDao(PostContentDao postContentDao) {
		this.postContentDao = postContentDao;
	}



	public void registration(Login l,User u) throws Exception
	{
		User _u = this.getRegistrationDao().getUserId(l);
		
		if(_u==null)
		{
			this.getRegistrationDao().insertUserIDMap(l);
			_u = this.getRegistrationDao().getUserId(l);
			u.setUSER_ID(_u.getUSER_ID());
			this.getRegistrationDao().insertUserLogin(u, l);
			this.getRegistrationDao().insertUserProfDetails(u);
			this.getRegistrationDao().insertUserInterests(u);
		}
		else
			throw new Exception();
	}
	
	public User userProfileView(User u)
	{
		u = this.getPostContentDao().getUserPostContent(u);
		return u;
	}
	
	public User userPostContent(User u,String POST_CONTENT)
	{
		this.getPostContentDao().insertUserPostContent(u, POST_CONTENT);
		u = this.getPostContentDao().getUserPostContent(u);
		return u;
		
	}

	public User getUserPostContent(User u)
	{
		return this.getPostContentDao().getUserPostContent(u);
	}
	
	public RegistrationDao getRegistrationDao() {
		return registrationDao;
	}

	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}
	
}
