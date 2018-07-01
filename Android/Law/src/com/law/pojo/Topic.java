package com.law.pojo;

public class Topic {

	private long id;
	
	private String topicTitle;
	
	private String topicContent;
	
	private String topicTime;
	
	private String topicUserName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public String getTopicTime() {
		return topicTime;
	}

	public void setTopicTime(String topicTime) {
		this.topicTime = topicTime;
	}

	public String getTopicUserName() {
		return topicUserName;
	}

	public void setTopicUserName(String topicUserName) {
		this.topicUserName = topicUserName;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicTitle=" + topicTitle + ", topicContent=" + topicContent + ", topicTime="
				+ topicTime + ", topicUserName=" + topicUserName + "]";
	}

}
