package com.org.hibernate.employee.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHONE")
public class Phone {
	
	@Column(name="PHONE_ID",precision=15,scale=0)
	@Id
	private long phoneId;
	@Column(name="PHONE_TYPE",length=15)
	private String phoneType;
	@Column(name="PHONE_NUMBER",precision=12,scale=0)
	private BigDecimal phoneNumber;
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public long getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public BigDecimal getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(BigDecimal phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
