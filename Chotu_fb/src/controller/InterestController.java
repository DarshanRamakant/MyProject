package controller;

import java.util.List;

import model.dataaccess.InterestDao;
import model.model.Interest;;

public class InterestController {

	public InterestController()
	{
		this.interestDao = new InterestDao();
	}
	public InterestDao getInterestDao() {
		return interestDao;
	}

	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}

	InterestDao interestDao;
	
	public List<Interest> listInterests()
	{
		return this.getInterestDao().getInterestList();
	}
	
}
