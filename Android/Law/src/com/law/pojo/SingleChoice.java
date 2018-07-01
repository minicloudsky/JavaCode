package com.law.pojo;

import java.util.List;

public class SingleChoice {

	private long id;
	
	private String topic;
	
	private long examId;
	
	private List<Options> options;
	
	private Answer answer;
	
	
	

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	@Override
	public String toString() {
		return "SingleChoice [id=" + id + ", topic=" + topic + ", examId=" + examId + "]";
	}

		
}
