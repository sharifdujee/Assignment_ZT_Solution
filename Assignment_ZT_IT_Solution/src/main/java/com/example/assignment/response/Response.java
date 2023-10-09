package com.example.assignment.response;

public class Response {
	
	private String Status;
	private String alertMessage;
	
	
	
	public Response() {
		super();
	}



	public Response(String status, String alertMessage) {
		super();
		Status = status;
		this.alertMessage = alertMessage;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public String getAlertMessage() {
		return alertMessage;
	}



	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	
	
	

}
