package com.luv2code.springboot.springbootthymeleafdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.springbootthymeleafdemo.entity.Employee;
import com.luv2code.springboot.springbootthymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employees = employeeService.findAll();
		theModel.addAttribute("employees", employees);
		
		// Add a comment line
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormAdd")
	public String showAddForm(Model theModel) {
		
		theModel.addAttribute("employee", new Employee());
		return "/employees/new-employee";
	}
	
	@GetMapping("/showFormUpdate")
	public String showUpdateForm(Model theModel, @RequestParam("id") int id) {
		
		Employee employee = employeeService.findById(id);
		theModel.addAttribute("employee", employee);
		return "/employees/update-employee";
	}
	
	// pre-process each web request
	// trim all spaces, whitespace to null if no other characters.
	@InitBinder
	public void preProcess(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer); // trim any request parameter, can also take a property name "lastName" to trim
//		dataBinder.registerCustomEditor(String.class, "lastName", trimmer);
//		dataBinder.registerCustomEditor(String.class, "firstName", trimmer);
	}	
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			if (theEmployee.getId() == 0)
				return "/employees/new-employee"; // path in resources/templates
			return "/employees/update-employee";
		}
		//theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int key) {
		
		Employee emp = employeeService.findById(key);
		if (emp != null)
			employeeService.deleteById(key);
		
		return "redirect:/employees/list";
		
	}

}
