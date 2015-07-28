package controller;

import model.dataaccess.AddFriendDao;
import model.dataaccess.SearchDao;
import model.model.Search;
import model.model.User;

public class SearchController {
	public SearchController()
	{
		this.addFriendDao = new AddFriendDao();
		this.searchDao = new SearchDao();
	}
	private SearchDao searchDao;
	private AddFriendDao addFriendDao;
	public AddFriendDao getAddFriendDao() {
		return addFriendDao;
	}

	public void setAddFriendDao(AddFriendDao addFriendDao) {
		this.addFriendDao = addFriendDao;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
	public Search search(String searchField,User u)
	{
		return this.getSearchDao().getUserProfDetails(searchField, u);
		
	}
	
	public Search addFriend(String searchField,int frndId,User u)
	{
		this.getAddFriendDao().insertUserFriend(u, frndId);
		return this.getSearchDao().getUserProfDetails(searchField, u);
		
	}

}
