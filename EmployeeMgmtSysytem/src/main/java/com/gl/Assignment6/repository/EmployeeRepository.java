package com.gl.Assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.Assignment6.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);

//	List<Employee> findAllByOrderByFirstNameAsc();

}
