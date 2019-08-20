package com.wipro.practice.SpringBootPractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.practice.SpringBootPractice.customAnnotation.TrackTime;
import com.wipro.practice.SpringBootPractice.domains.AddEmployeeReq;
import com.wipro.practice.SpringBootPractice.domains.AddEmployeeRes;
import com.wipro.practice.SpringBootPractice.entity.Employee;
import com.wipro.practice.SpringBootPractice.errorHandling.InternalServerError;
import com.wipro.practice.SpringBootPractice.errorHandling.BadRequestError;
import com.wipro.practice.SpringBootPractice.services.EmplyeeInterface;

@RestController
@RequestMapping("employeeService")
public class EmployeeController {

	
	@Autowired
	EmplyeeInterface addEmplyee;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<AddEmployeeRes> addEmploye(@RequestBody AddEmployeeReq addEmployeeReq) throws BadRequestError, InternalServerError {
	String addEmpRes =	addEmplyee.addEmployee(addEmployeeReq);
	AddEmployeeRes addEmployeeRes =new	AddEmployeeRes(addEmpRes);
	return new ResponseEntity<AddEmployeeRes>(addEmployeeRes ,HttpStatus.OK);
	}
	
	@TrackTime
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestHeader("Authorization") String header) throws InternalServerError{
		if (header.equals("allow")) {
			List<Employee> list = addEmplyee.getAllEmployee();
			return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		}
	
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
