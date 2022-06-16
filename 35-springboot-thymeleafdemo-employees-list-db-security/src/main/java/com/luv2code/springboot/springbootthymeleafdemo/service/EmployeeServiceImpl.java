package com.luv2code.springboot.springbootthymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.springbootthymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.springbootthymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject the EmployeeRepository
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		//return employeeRepository.findAll();
		// return by sorted ASC last name
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int pkey) {
		Optional<Employee> option = employeeRepository.findById(pkey);
		Employee emp = null;
		
		// check if a value was found by the pkey
		// otherwise return a null (empty)
		if (option.isPresent())
			emp = option.get();
		return emp;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int pkey) {
		employeeRepository.deleteById(pkey);
		
	}

}
