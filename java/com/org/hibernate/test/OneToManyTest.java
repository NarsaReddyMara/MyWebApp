package com.org.hibernate.test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.hibernate.employee.model.Employee;
import com.org.hibernate.employee.model.Phone;
import com.org.hibernate.utility.HibernateUtils;

public class OneToManyTest {

	public static void main(String[] args) {
		Session session = HibernateUtils.createSession();
		
		Employee emp = new Employee();
		emp.setEmployeeId(100);
		emp.setEmployeeName("Narsa");
		emp.setEmployeeDes("AC");
		emp.setEmployeeSal(10000);
		
		Phone p1 = new Phone();
		p1.setPhoneId(1);
		p1.setPhoneType("Mobile");
		p1.setPhoneNumber(new BigDecimal("9886124852"));
		
		
		Phone p2 = new Phone();
		p2.setPhoneId(2);
		p2.setPhoneType("Land Line");
		p2.setPhoneNumber(new BigDecimal("080123456"));
		
		Phone p3 = new Phone();
		p3.setPhoneId(3);
		p3.setPhoneType("Alternate");
		p3.setPhoneNumber(new BigDecimal("9848698150"));
		
		Set<Phone> phones = new HashSet<>();
		phones.add(p1);
		phones.add(p2);
		phones.add(p3);
		
		emp.setPhones(phones);
		
		p1.setEmployee(emp);
		p2.setEmployee(emp);
		p3.setEmployee(emp);
		
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		
		//Retrieving data from database tables
		session.createQuery("from Employee");
		
		System.err.println("from employee");
		Object obj = session.get(Employee.class, new Long(100));
		Employee e = (Employee)obj;
		
		System.out.println(e.getEmployeeId());
		System.out.println(e.getEmployeeName());
		System.out.println(e.getEmployeeDes());
		System.out.println(e.getEmployeeSal());
		
		Set<Phone> phoneList = e.getPhones();
		for(Phone p : phoneList) {
			System.out.println(p.getPhoneId());
			System.out.println(p.getPhoneType());
			System.out.println(p.getPhoneNumber());
		}
		
		System.err.println("from phone");
		
		Object o1 = session.get(Phone.class, new Long(1));
		Phone pp1 = (Phone)o1;
		System.out.println(pp1.getPhoneId());
		System.out.println(pp1.getPhoneType());
		System.out.println(pp1.getPhoneNumber());
		System.out.println(pp1.getEmployee().getEmployeeId());
		
	}

}
