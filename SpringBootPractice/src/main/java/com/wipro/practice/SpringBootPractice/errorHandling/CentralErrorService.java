package com.wipro.practice.SpringBootPractice.errorHandling;

public class CentralErrorService {
	private int statusCode;
	private String errorMessage;

	public CentralErrorService(int statusCode, String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public CentralErrorService() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "AddEmployeeError [statusCode=" + statusCode + ", errorMessage=" + errorMessage + "]";
	}

}
