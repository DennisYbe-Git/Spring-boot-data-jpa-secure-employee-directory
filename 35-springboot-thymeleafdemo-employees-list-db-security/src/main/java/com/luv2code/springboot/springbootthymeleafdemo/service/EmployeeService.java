package com.luv2code.springboot.springbootthymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.springbootthymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int pkey);
	
	public Employee save(Employee employee);
	
	public void deleteById(int pkey);

}
