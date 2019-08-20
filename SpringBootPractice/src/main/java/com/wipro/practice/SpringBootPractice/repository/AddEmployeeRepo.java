package com.wipro.practice.SpringBootPractice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.practice.SpringBootPractice.entity.Employee;
@Repository
public interface AddEmployeeRepo extends CrudRepository<Employee, Integer>{
	
	List<Employee> findByName(String name);

}
