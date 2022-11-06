package com.gl.Assignment6.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.Assignment6.model.Employee;
import com.gl.Assignment6.model.Role;
import com.gl.Assignment6.model.User;

public interface EmployeeService {
	
	public List<Employee> fetchAllEmployees();
	
	public Employee fetchEmployeeById(int empId);
	
	public void save(Employee theEmployee);
	
	public void deleteEmployeeById(int theId);
	
	public List<Employee> searchByFirstName(String firstName);
	
	public List<Employee> sortByFirstName(Direction order);
	
	public User saveUser(User user);
	
	public Role saveRole(Role role);


}
