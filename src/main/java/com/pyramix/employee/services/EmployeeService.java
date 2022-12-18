package com.pyramix.employee.services;

import java.util.List;

import com.pyramix.employee.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public boolean deleteEmployee(long id);

	public Employee getEmployeeById(long id);

	public Employee updateEmployee(long id, Employee employee);

}
