package com.luv2code.springboot.springbootthymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.springbootthymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Database methods with datasource connection for CRUD automatically implemented
	// findAll()
	// findById()
	// save()
	// deleteById()
	
	public List<Employee> findAllByOrderByLastNameAsc();

}
