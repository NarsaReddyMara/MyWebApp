package com.org.hibernate.test;

import org.hibernate.Session;

import com.org.hibernate.utility.HibernateUtils;

public class HibernateConnectionTest {

	public static void main(String[] args) {
		Session session = HibernateUtils.createSession();
		System.out.println(session.hashCode());
		session.createQuery("create table tpm(name varchar2(20");
		System.out.println("table created");
	}

}
