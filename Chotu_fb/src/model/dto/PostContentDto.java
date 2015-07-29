package model.dto;

import java.sql.Blob;
import java.sql.Timestamp;

public class PostContentDto {

	private String userName;
	private String postContent;
	private Timestamp postTimeStamp;
	private Blob profilePic;
	public Blob getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Timestamp getPostTimeStamp() {
		return postTimeStamp;
	}
	public void setPostTimeStamp(Timestamp postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}
}
