package model.dto;

import java.sql.Blob;

public class UserProfileDto {
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Blob getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}
	public boolean isFrnd() {
		return isFrnd;
	}
	public void setFrnd(boolean isFrnd) {
		this.isFrnd = isFrnd;
	}
	int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	String userName;
	Blob profilePic;
	boolean isFrnd;
	

}
