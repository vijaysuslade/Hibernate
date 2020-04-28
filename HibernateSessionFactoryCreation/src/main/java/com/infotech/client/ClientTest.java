package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.service.EmployeeService;
import com.infotech.serviceimpl.EmployeeServiceimpl;

public class ClientTest {
	static EmployeeService employeeService=new EmployeeServiceimpl();
	public static void main(String[] args) {
     // createEmployee(employeeService);
	 //	getEmployeeById(employeeService);
	//	deleteById(employeeService);
		updateById(employeeService,25000000.0000);
	}

	private static void updateById(EmployeeService employeeService,Double sal) {
		employeeService.updateEmployeeById(3, sal);	
	}

	private static void deleteById(EmployeeService employeeService) {
		employeeService.deleteById(2);
	}

	private static void getEmployeeById(EmployeeService employeeService) {
		employeeService.getEmployeeById(3); 	
	}

	public static void createEmployee(EmployeeService createEmployee) {
		createEmployee.createEmployee(getEmployee());
	}
	
	
	private static Employee getEmployee() {
		Employee employee=new Employee();
        employee.setEmployeeName("vijay");
        employee.setEmployeeemail("vjsuslade@gmail.com");
        employee.setDoj(new Date());
        employee.setSalary(10000.00);
		return employee;
	}
}

/*
 * String sql="select version()"; String
 * result=(String)session.createNativeQuery(sql).getSingleResult();
 * System.out.println(result);
 */