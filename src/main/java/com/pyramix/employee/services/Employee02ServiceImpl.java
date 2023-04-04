package com.pyramix.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pyramix.employee.entity.Employee02Entity;
import com.pyramix.employee.model.Employee02;
import com.pyramix.employee.repository.Employee02Repository;

@Service
public class Employee02ServiceImpl implements Employee02Service {

	private Employee02Repository employee02Repository;
	
	public Employee02ServiceImpl(Employee02Repository employee02Repository) {
		this.employee02Repository = employee02Repository;
	}

	@Override
	public List<Employee02> getAllEmployees02() {
		List<Employee02Entity> employee02Entities = getEmployee02Repository().findAll();
		
		List<Employee02> employees02 = employee02Entities
				.stream()
				.map(emp02 -> new Employee02(emp02.getId(),
						emp02.getName(),
						emp02.getEmail(),
						emp02.getTitle(),
						emp02.getDepartment(),
						emp02.getStatus(),
						emp02.getRole(),
						emp02.getImgUrl()))
				.collect(Collectors.toList());
		
		return employees02;
	}

	public Employee02Repository getEmployee02Repository() {
		return employee02Repository;
	}

	public void setEmployee02Repository(Employee02Repository employee02Repository) {
		this.employee02Repository = employee02Repository;
	}

}
