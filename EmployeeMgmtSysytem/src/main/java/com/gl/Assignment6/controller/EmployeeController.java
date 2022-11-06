package com.gl.Assignment6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Assignment6.model.Employee;
import com.gl.Assignment6.model.Role;
import com.gl.Assignment6.model.User;
import com.gl.Assignment6.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		theEmployee.setId(0);
		employeeService.save(theEmployee);

		return theEmployee;
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return employeeService.saveUser(user);
	}

	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return employeeService.saveRole(role);
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployees() {
		return employeeService.fetchAllEmployees();
		
	}
	
	@GetMapping("/employees/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") int empId) {
		return this.employeeService.fetchEmployeeById(empId);
		
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee theEmployee, @PathVariable int id) {
		
		Employee updatedEmployee;
		
		if (id != 0) {
			updatedEmployee = employeeService.fetchEmployeeById(id);
			updatedEmployee.setEmail(theEmployee.getEmail());
			updatedEmployee.setFirstName(theEmployee.getFirstName());
			updatedEmployee.setLastName(theEmployee.getLastName());
			employeeService.save(updatedEmployee);
		} else {
			updatedEmployee = new Employee(theEmployee.getFirstName(), theEmployee.getLastName(),
					theEmployee.getEmail());
			employeeService.save(updatedEmployee);
		}
		

		return updatedEmployee;
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable("id") int empId) {
		this.employeeService.deleteEmployeeById(empId);
		
	}
	
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstName(firstName);
	}

	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName(@RequestParam Direction order) {
		return employeeService.sortByFirstName(order);
	}
	

}
