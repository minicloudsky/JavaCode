package com.law.dto;

import java.util.List;

import com.law.pojo.Exam;
import com.law.pojo.MultipleChoice;
import com.law.pojo.SingleChoice;

public class ExamResult {

	private long examId;
	
	private Exam exam;
	
	private List<SingleChoice> singleChoices;
	
	private List<MultipleChoice> multipleChoices;

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}


	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<SingleChoice> getSingleChoices() {
		return singleChoices;
	}

	public void setSingleChoices(List<SingleChoice> singleChoices) {
		this.singleChoices = singleChoices;
	}

	public List<MultipleChoice> getMultipleChoices() {
		return multipleChoices;
	}

	public void setMultipleChoices(List<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}

	@Override
	public String toString() {
		return "ExamResult [examId=" + examId + ", exam=" + exam + ", singleChoices=" + singleChoices
				+ ", multipleChoices=" + multipleChoices + "]";
	}

	
}
