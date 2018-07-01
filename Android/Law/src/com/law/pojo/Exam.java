package com.law.pojo;

public class Exam {

	private long id;
	
	private String examTitle;
	
	private String examDesc;
	
	private String examClassify;
	
	

	public String getExamClassify() {
		return examClassify;
	}

	public void setExamClassify(String examClassify) {
		this.examClassify = examClassify;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public String getExamDesc() {
		return examDesc;
	}

	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", examTitle=" + examTitle + ", examDesc=" + examDesc + "]";
	}

	

	
	
}
