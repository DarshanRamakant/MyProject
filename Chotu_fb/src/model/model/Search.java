package model.model;

import java.util.List;

import model.dto.UserProfileDto;

public class Search {

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<UserProfileDto> getUserProfileDto() {
		return userProfileDto;
	}
	public void setUserProfileDto(List<UserProfileDto> userProfileDto) {
		this.userProfileDto = userProfileDto;
	}
	int userId;
	List<UserProfileDto> userProfileDto;

}
