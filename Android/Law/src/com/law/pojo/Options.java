package com.law.pojo;

public class Options {

	private long id;
	
	private String optionContent;
	
	private long singlechoiceId;
	
	private long multiplechoiceId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public long getSinglechoiceId() {
		return singlechoiceId;
	}

	public void setSinglechoiceId(long singlechoiceId) {
		this.singlechoiceId = singlechoiceId;
	}

	public long getMultiplechoiceId() {
		return multiplechoiceId;
	}

	public void setMultiplechoiceId(long multiplechoiceId) {
		this.multiplechoiceId = multiplechoiceId;
	}

	@Override
	public String toString() {
		return "Options [id=" + id + ", optionContent=" + optionContent + ", singlechoiceId=" + singlechoiceId
				+ ", multiplechoiceId=" + multiplechoiceId + "]";
	}



		
}
