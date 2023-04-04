package com.pyramix.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyramix.employee.model.Employee;
import com.pyramix.employee.model.Employee02;
import com.pyramix.employee.services.Employee02Service;
import com.pyramix.employee.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private EmployeeService employeeService;
	private Employee02Service employee02Service;
	
	public EmployeeController(EmployeeService employeeService, Employee02Service employee02Service) {
		this.setEmployeeService(employeeService);
		this.setEmployee02Service(employee02Service);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {

		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees02")
	public List<Employee02> getAllEmployees02() {
		
		return getEmployee02Service().getAllEmployees02();
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id) {
		boolean deleted = false;
		
		deleted = employeeService.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", deleted);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee employee = null;
		employee = getEmployeeService().getEmployeeById(id);
		
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee = getEmployeeService().updateEmployee(id, employee);
		
		return ResponseEntity.ok(employee);
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee02Service getEmployee02Service() {
		return employee02Service;
	}

	public void setEmployee02Service(Employee02Service employee02Service) {
		this.employee02Service = employee02Service;
	}
	
}
