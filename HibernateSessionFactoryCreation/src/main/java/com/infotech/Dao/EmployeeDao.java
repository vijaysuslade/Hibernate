package com.infotech.Dao;

import com.infotech.entities.Employee;

public interface EmployeeDao {

	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(int id);
	public abstract void updateEmployeeById(int id,Double newsal);
	public abstract void deleteById(int id);
}
