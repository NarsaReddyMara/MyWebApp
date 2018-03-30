package com.org.hibernate.employee.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Column(name="EMPLOYEE_ID",precision=15,scale=0)
	@Id
	private long employeeId;
	@Column(name="EMPLOYEE_NAME",length=15)
	private String employeeName;
	@Column(name="EMPLOYEE_DES",length=15)
	private String employeeDes;
	@Column(name="EMPLOYEE_SAL",precision=10,scale=2)
	private double employeeSal;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	//@JoinTable(name="EMPLOYEE_PHONE",joinColumns=@JoinColumn(name="EMPLOYEE_ID"),inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
	private Set<Phone> phones;
	
	public Set<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDes() {
		return employeeDes;
	}
	public void setEmployeeDes(String employeeDes) {
		this.employeeDes = employeeDes;
	}
	public double getEmployeeSal() {
		return employeeSal;
	}
	public void setEmployeeSal(double employeeSal) {
		this.employeeSal = employeeSal;
	}
}
