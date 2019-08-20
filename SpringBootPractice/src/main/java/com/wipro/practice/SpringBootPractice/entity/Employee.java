package com.wipro.practice.SpringBootPractice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	
	@Id
	@SequenceGenerator(name="emp_seq" , sequenceName="EMP_SEQ",allocationSize=1)
	@GeneratedValue(generator="emp_seq",strategy=GenerationType.SEQUENCE)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String department;
	@NotNull
	private int salary;
	@NotNull
	private String address;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, @NotNull String name, @NotNull String department, @NotNull int salary,
			@NotNull String address) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", address=" + address + "]";
	}
	
}
