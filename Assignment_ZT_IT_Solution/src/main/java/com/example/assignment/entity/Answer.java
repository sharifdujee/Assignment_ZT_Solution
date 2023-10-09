package com.example.assignment.entity;



public class Answer {

	private Integer questionId;
	private String answer;
	
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Answer(Integer questionId, String answer) {
		super();
		this.questionId = questionId;
		this.answer = answer;
	}


	public Integer getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}


