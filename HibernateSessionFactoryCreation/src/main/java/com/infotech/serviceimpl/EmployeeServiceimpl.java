package com.infotech.serviceimpl;

import com.infotech.Daoimpl.EmployeeDaoImpl;
import com.infotech.entities.Employee;
import com.infotech.service.EmployeeService;

public class EmployeeServiceimpl  implements EmployeeService{

	
	public void createEmployee(Employee employee) {
	 new EmployeeDaoImpl().createEmployee(employee);
	}

	public Employee getEmployeeById(int id) {
		return new EmployeeDaoImpl().getEmployeeById(id);
	}

	public void updateEmployeeById(int id, Double newsal) {
		new EmployeeDaoImpl().updateEmployeeById(id, newsal);
	}

	public void deleteById(int id) {
		new EmployeeDaoImpl().deleteById(id);
	}

	
}
