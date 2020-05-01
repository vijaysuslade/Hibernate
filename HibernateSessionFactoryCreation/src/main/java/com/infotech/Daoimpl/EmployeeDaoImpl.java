package com.infotech.Daoimpl;

import org.hibernate.Session;

import com.infotech.Dao.EmployeeDao;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public void createEmployee(Employee employee) {
		Session session;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Integer id = (Integer) session.save(employee);
			System.out.println("Employee Save with id--" + id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployeeById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, id);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee Not Found");
		}
		return employee;
	}

	public void updateEmployeeById(int id, Double newsal) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, id);
		if (employee != null) {
			employee.setSalary(newsal);
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
			System.out.println("Salary Updated.");
		} else {
			System.out.println("Employee Not Found");
		}
		
	}
	public void deleteById(int id) {
		Session session;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Employee employee = session.get(Employee.class, id);
			session.beginTransaction();
		    session.delete(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
