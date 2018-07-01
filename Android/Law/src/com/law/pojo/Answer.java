package com.law.pojo;

public class Answer {

	private long id;
	
	private long multiplechoiceId;
	
	private long singlechoiceId;
	
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMultiplechoiceId() {
		return multiplechoiceId;
	}

	public void setMultiplechoiceId(long multiplechoiceId) {
		this.multiplechoiceId = multiplechoiceId;
	}

	public long getSinglechoiceId() {
		return singlechoiceId;
	}

	public void setSinglechoiceId(long singlechoiceId) {
		this.singlechoiceId = singlechoiceId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", multiplechoiceId=" + multiplechoiceId + ", singlechoiceId=" + singlechoiceId
				+ ", content=" + content + "]";
	}


	
}
