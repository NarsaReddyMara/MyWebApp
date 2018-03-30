package com.org.hibernate.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Column(name="ADDRESS_ID",precision=15,scale=0)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long addressId;
	@Column(name="HOUSE_NO",length=30)
	private String houseNo;
	@Column(name="STATE",length=20)
	private String state;
	@Column(name="PINCODE",precision=6,scale=0)
	private int pincode;
	@OneToOne(mappedBy="address")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
