package com.org.hibernate.customer.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Column(name="CUSTOMER_ID",precision=15,scale=0,nullable=false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	@Column(name="CUSTOMER_NAME",length=25)
	private String customerName;
	@Column(name="CUSTOMER_PHONE",unique=true,precision=10,scale=0)
	private BigDecimal customerPhone;
	@Column(name="CUSTOMER_EMAIL",length=25,unique=true)
	private String customerEmail;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getCustomerId() {
		return customerId;
	}
	public BigDecimal getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(BigDecimal customerPhone) {
		this.customerPhone = customerPhone;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
}
