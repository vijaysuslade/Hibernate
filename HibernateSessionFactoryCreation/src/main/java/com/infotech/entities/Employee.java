package com.infotech.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="employee_table")
@DynamicUpdate
public class Employee {

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name="employee_name",nullable = false)
	private String employeeName;
	
	@Column(name="employee_email")
	private String employeeemail;
	
	@Column(name="employee_doj")
	private Date doj;
	
	/*
	 * @Embedded private Address address;
	 */	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "address_id") private Address address;
	 */
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="employee")
	//@JoinTable(name="employee_address_table",joinColumns = @JoinColumn(name="employee_id"),inverseJoinColumns =@JoinColumn(name="address_id"))
	private List<Address> address=new ArrayList<Address>();
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeemail() {
		return employeeemail;
	}

	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Column(name="employee_salary")
	private double salary;

	public Employee() {
	}
		
	/*
	 * public Address getAddress() { return address; }
	 */

	/*
	 * public void setAddress(Address address) { this.address = address; }
	 */
	/*
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */
	
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeemail="
				+ employeeemail + ", doj=" + doj + ", salary=" + salary + "]";
	}

	
	

}
