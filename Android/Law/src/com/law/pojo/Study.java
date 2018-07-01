package com.law.pojo;

public class Study {

	private long id;
	
	private String studyTitle;
	
	private String studyClassify;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudyTitle() {
		return studyTitle;
	}

	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}

	public String getStudyClassify() {
		return studyClassify;
	}

	public void setStudyClassify(String studyClassify) {
		this.studyClassify = studyClassify;
	}

	@Override
	public String toString() {
		return "Study [id=" + id + ", studyTitle=" + studyTitle + ", studyClassify=" + studyClassify + "]";
	}

		
}
