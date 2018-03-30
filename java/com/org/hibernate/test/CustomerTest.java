package com.org.hibernate.test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.hibernate.customer.model.Address;
import com.org.hibernate.customer.model.Customer;
import com.org.hibernate.utility.HibernateUtils;

public class CustomerTest {

	public static void main(String[] args) {
		
	Session session = HibernateUtils.createSession();
	
	Customer customer = new Customer();
	customer.setCustomerId(1);
	customer.setCustomerEmail("reddy.mara");
	customer.setCustomerName("NarsaReddy Mara");
	customer.setCustomerPhone(new BigDecimal("9886124852"));
	
	Address add = new Address();
	add.setAddressId(2);
	add.setHouseNo("#2-14, Madhapur");
	add.setState("Telangana");
	add.setPincode(504105);
	customer.setAddress(add);
	add.setCustomer(customer);
	
	
	Transaction tx = session.beginTransaction();
	session.update(customer);
	tx.commit();
	
	session.close();
	
	/*Session session1 = HibernateUtils.createSession();
	
	Object obj = session1.load(Customer.class, new Long(1));
	Customer cust = (Customer)obj;
	System.out.println(cust.getCustomerEmail());*/
	/*cust.setCustomerEmail("reddy.mara");
	
	Transaction tx1 = session.beginTransaction();
	session1.saveOrUpdate(cust);
	tx1.commit();*/
	
	
	//From customer
	/*System.err.println("From Customer.........");
	session.createQuery("from Customer");
	Object obj = session.load(Customer.class, new Long(1));
	Customer cust = (Customer)obj;
	System.out.println(cust.getCustomerId());
	System.out.println(cust.getCustomerName());
	System.out.println(cust.getCustomerPhone());
	System.out.println(cust.getCustomerEmail());
	
	Address a = cust.getAddress();
	
	System.out.println(a.getAddressId());
	
	//From Address
	System.err.println("From Address..........");
	session.createQuery("from Address");
	Object ob = session.load(Address.class, new Long(2));
	Address ad = (Address)ob;
	System.out.println(a.getAddressId());
	System.out.println(a.getHouseNo());
	System.out.println(a.getPincode());
	System.out.println(a.getState());
	
	Customer c = ad.getCustomer();
	
	System.out.println(c.getCustomerId());
	System.err.println("Iterator..........");
	@SuppressWarnings("unchecked")
	List<Customer> list = session.createQuery("from Customer").list();
	System.out.println(list.size());
	Iterator<Customer> it = list.iterator();
	while(it.hasNext()){
		Customer c1 = it.next();
		System.out.println(c1.getCustomerId());
		System.out.println(c1.getCustomerName());
	}*/
	
	
	}

}
