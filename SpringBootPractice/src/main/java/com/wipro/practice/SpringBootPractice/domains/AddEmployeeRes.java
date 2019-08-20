package com.wipro.practice.SpringBootPractice.domains;

public class AddEmployeeRes {

	private String msg;

	public AddEmployeeRes(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "AddEmployeeRes [msg=" + msg + "]";
	}
	
	
	
}
