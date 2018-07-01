package com.law.pojo;

public class User {

	private long id;
	
	private String userName;
	private String userPhone;
	private String userGender;
	private String userBirth;
	private String userProfession;
	private String userHeadimg;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserProfession() {
		return userProfession;
	}
	public void setUserProfession(String userProfession) {
		this.userProfession = userProfession;
	}
	public String getUserHeadimg() {
		return userHeadimg;
	}
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPhone=" + userPhone + ", userGender=" + userGender
				+ ", userBirth=" + userBirth + ", userProfession=" + userProfession + ", userHeadimg=" + userHeadimg
				+ "]";
	}
	
}
