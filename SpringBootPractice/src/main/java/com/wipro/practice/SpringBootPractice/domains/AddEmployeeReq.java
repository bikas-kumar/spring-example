package com.wipro.practice.SpringBootPractice.domains;

public class AddEmployeeReq {

	private String name;
	private String department;
	private int salary;
	private String address;
	public AddEmployeeReq(String name, String department, int salary, String address) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.address = address;
	}
	public AddEmployeeReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AddEmployeeReq [name=" + name + ", department=" + department + ", salary=" + salary + ", address="
				+ address + "]";
	}
	
	
	
}
