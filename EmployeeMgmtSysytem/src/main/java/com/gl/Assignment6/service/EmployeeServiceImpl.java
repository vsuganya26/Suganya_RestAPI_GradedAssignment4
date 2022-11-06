package com.gl.Assignment6.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.Assignment6.model.Employee;
import com.gl.Assignment6.model.Role;
import com.gl.Assignment6.model.User;
import com.gl.Assignment6.repository.EmployeeRepository;
import com.gl.Assignment6.repository.RoleRepository;
import com.gl.Assignment6.repository.UserRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;
	
	
	@Override
	public void save(Employee theEmployee) {
		employeerepository.save(theEmployee);
	}
	
	@Override
	public List<Employee> fetchAllEmployees(){	
		return this.employeerepository.findAll();
		
	}
	
	@Override
	public Employee fetchEmployeeById(int empId) {
		return this.employeerepository.findById(empId).orElseThrow();
	}
	
	@Override
	public void deleteEmployeeById(int empId) {
		this.employeerepository.deleteById(empId);
	}
	
	@Override
	public List<Employee> searchByFirstName(String firstName) {
		return employeerepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}
	
	@Override
	public List<Employee> sortByFirstName(Direction order) {
		//return employeerepository.findAllByOrderByFirstNameAsc();
		
		switch (order) {
		case ASC:
			return employeerepository.findAll(Sort.by(Sort.Order.asc("firstName").ignoreCase()));
		case DESC:
			return employeerepository.findAll(Sort.by(Sort.Order.desc("firstName").ignoreCase()));
		default:
			return new ArrayList<Employee>();
		}
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	}
