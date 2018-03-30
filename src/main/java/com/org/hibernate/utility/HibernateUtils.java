package com.org.hibernate.utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

	private static Session session ;

	public static Session createSession(){
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
		
		return session;
	}
	
}
