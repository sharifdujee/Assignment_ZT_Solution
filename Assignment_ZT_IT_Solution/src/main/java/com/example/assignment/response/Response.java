package com.example.assignment.response;

import java.util.List;

public class Response {
	private int statuscode;
	private String Status;
	private String alertMessage;
	private List<Object> data;


	public Response() {
		super();
	}
	
	

	public Response(String status, String alertMessage) {
		super();
		Status = status;
		this.alertMessage = alertMessage;
	}
	
	

	public Response(int statuscode, String status, String alertMessage, List<Object> data) {
		super();
		this.statuscode = statuscode;
		Status = status;
		this.alertMessage = alertMessage;
		this.data = data;
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



	public int getStatuscode() {
		return statuscode;
	}



	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}



	public List<Object> getData() {
		return data;
	}



	public void setData(List<Object> data) {
		this.data = data;
	}
	

}
