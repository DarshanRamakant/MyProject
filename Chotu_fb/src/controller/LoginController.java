package controller;

import model.dataaccess.LoginDao;
import model.model.Login;
import model.model.User;

public class LoginController {
	
	public LoginController()
	{
		this.loginDao = new LoginDao();
	}
	private LoginDao loginDao;
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public User login (Login l) throws Exception{
		
		User u = this.getLoginDao().getUserLoginId(l);
		
		if(u==null)
		{
			throw new Exception();
		}
		u = this.getLoginDao().getUserProfDetails(u);
		
		u = this.getLoginDao().getUserInterests(u);
		
		return u;
	}
}
