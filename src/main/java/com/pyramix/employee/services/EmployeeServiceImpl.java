package com.pyramix.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.pyramix.employee.entity.EmployeeEntity;
import com.pyramix.employee.model.Employee;
import com.pyramix.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.setEmployeeRepository(employeeRepository);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		getEmployeeRepository().save(employeeEntity);
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntities = getEmployeeRepository().findAll();
		
		List<Employee> employees = employeeEntities
				.stream()
				.map(emp -> new Employee(emp.getId(), 
						emp.getFirstName(), 
						emp.getLastName(), 
						emp.getEmailId()))
				.collect(Collectors.toList());
		
		return employees;
	}
	
	@Override
	public boolean deleteEmployee(long id) {
		EmployeeEntity employeeEntity = getEmployeeRepository().findById(id).get();
		
		getEmployeeRepository().delete(employeeEntity);
		
		return true;
	}

	@Override
	public Employee getEmployeeById(long id) {
		EmployeeEntity employeeEntity = getEmployeeRepository().findById(id).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		
		return employee;
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		EmployeeEntity employeeEntity = getEmployeeRepository().findById(id).get();
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setEmailId(employee.getEmailId());
		
		getEmployeeRepository().save(employeeEntity);
		
		return employee;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
