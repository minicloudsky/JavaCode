package com.law.pojo;

public class Lawyer {

	private long id;
	
	private String lawyerMajor;
	
	private String lawyerDesc;
	
	private String cardId;
	
	private long userId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLawyerMajor() {
		return lawyerMajor;
	}

	public void setLawyerMajor(String lawyerMajor) {
		this.lawyerMajor = lawyerMajor;
	}

	public String getLawyerDesc() {
		return lawyerDesc;
	}

	public void setLawyerDesc(String lawyerDesc) {
		this.lawyerDesc = lawyerDesc;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Lawyer [id=" + id + ", lawyerMajor=" + lawyerMajor + ", lawyerDesc=" + lawyerDesc + ", cardId=" + cardId
				+ ", userId=" + userId + "]";
	}
	
	
}
