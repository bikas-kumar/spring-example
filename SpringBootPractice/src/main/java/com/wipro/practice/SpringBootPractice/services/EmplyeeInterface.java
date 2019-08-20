package com.wipro.practice.SpringBootPractice.services;


import java.util.List;

import com.wipro.practice.SpringBootPractice.domains.AddEmployeeReq;
import com.wipro.practice.SpringBootPractice.entity.Employee;
import com.wipro.practice.SpringBootPractice.errorHandling.InternalServerError;
import com.wipro.practice.SpringBootPractice.errorHandling.BadRequestError;


public interface EmplyeeInterface {
	String	addEmployee(AddEmployeeReq addEmployeeReq) throws BadRequestError, InternalServerError;
	List<Employee> getAllEmployee() throws InternalServerError;
	
}
