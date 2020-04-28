package com.infotech.service;

import com.infotech.entities.Employee;

public interface EmployeeService {

	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(int id);
	public abstract void updateEmployeeById(int id,Double newsal);
	public abstract void deleteById(int id);
}
