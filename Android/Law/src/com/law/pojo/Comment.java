package com.law.pojo;

public class Comment {

	private long id;
	
	private long topicId;
	
	private String commentContent;
	
	private String commentUserName;
	
	private String commentTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", topicId=" + topicId + ", commentContent=" + commentContent
				+ ", commentUserName=" + commentUserName + ", commentTime=" + commentTime + "]";
	}
		
}
