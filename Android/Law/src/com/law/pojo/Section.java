package com.law.pojo;

public class Section {

	private long id;
	
	private String sectionTitle;
	
	private String sectionContent;
	
	private long studyId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}



	public long getStudyId() {
		return studyId;
	}

	public void setStudyId(long studyId) {
		this.studyId = studyId;
	}

	
	
	public String getSectionContent() {
		return sectionContent;
	}

	public void setSectionContent(String sectionContent) {
		this.sectionContent = sectionContent;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", sectionTitle=" + sectionTitle + ", content=" + sectionContent + ", studyId=" + studyId
				+ "]";
	}

	
	
}
