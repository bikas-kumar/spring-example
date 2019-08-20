package com.wipro.practice.SpringBootPractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.practice.SpringBootPractice.domains.AddEmployeeReq;
import com.wipro.practice.SpringBootPractice.entity.Employee;
import com.wipro.practice.SpringBootPractice.errorHandling.InternalServerError;
import com.wipro.practice.SpringBootPractice.errorHandling.BadRequestError;
import com.wipro.practice.SpringBootPractice.repository.AddEmployeeRepo;

@Service
public class EmployeeServiceImp implements EmplyeeInterface {
	@Autowired
	AddEmployeeRepo addEmployeeRepo;

	@Override
	public String addEmployee(AddEmployeeReq addEmployeeReq) throws BadRequestError, InternalServerError {
		Employee employee = new Employee();

		if (addEmployeeReq.getName() != null && addEmployeeReq.getName() != "") {
			employee.setName(addEmployeeReq.getName());
		} else {
			throw new BadRequestError("Invalid name");
		}
		if (addEmployeeReq.getAddress() != null && addEmployeeReq.getAddress() != "") {

			employee.setAddress(addEmployeeReq.getAddress());
		} else {
			throw new BadRequestError("Invalid address");
		}
		if (addEmployeeReq.getDepartment() != null && addEmployeeReq.getDepartment() != "") {
			employee.setDepartment(addEmployeeReq.getDepartment());
		} else {
			throw new BadRequestError("Invalid department");
		}
		Integer salary = addEmployeeReq.getSalary();
		if (salary instanceof Integer) {
			employee.setSalary(addEmployeeReq.getSalary());
		} else {
			throw new BadRequestError("Invalid salary");
		}

		try {
			addEmployeeRepo.save(employee);
			return "Successfully added";
		} catch (Exception e) {

			throw new InternalServerError("Database service not running..");

		}

	}

	@Override
	public List<Employee> getAllEmployee() throws InternalServerError {
	try {
		return (List<Employee>) addEmployeeRepo.findAll();
	} catch (Exception e) {
		throw new InternalServerError("Database service not running..");
	}

	}

}
