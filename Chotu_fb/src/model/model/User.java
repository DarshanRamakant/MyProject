package model.model;

import model.dto.*;

import java.sql.Blob;
import java.util.List;

public class User {
	
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getROLL_NO() {
		return ROLL_NO;
	}
	public void setROLL_NO(String rOLL_NO) {
		ROLL_NO = rOLL_NO;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public Blob getPROFILE_PIC() {
		return PROFILE_PIC;
	}
	public void setPROFILE_PIC(Blob pROFILE_PIC) {
		PROFILE_PIC = pROFILE_PIC;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getPHONE_NO() {
		return PHONE_NO;
	}
	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}
	public List<Interest> getUserInterests() {
		return userInterests;
	}
	public void setUserInterests(List<Interest> userInterests) {
		this.userInterests = userInterests;
	}
	public List<PostContentDto> getPostContentDto() {
		return postContentDto;
	}
	public void setPostContentDto(List<PostContentDto> postContentDto) {
		this.postContentDto = postContentDto;
	}
	int USER_ID;
	String ROLL_NO;
	String USER_NAME;
	Blob PROFILE_PIC;
    String GENDER;
    Course course;
    String PHONE_NO;
    String EMAIL;
    
    public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	List<Interest> userInterests;
    List<PostContentDto> postContentDto;

}
