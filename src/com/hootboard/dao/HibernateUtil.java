package com.hootboard.dao;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() 
	{
		if(sf == null) 
		{
			Configuration cfg = new Configuration();
			cfg.configure();
			sf = cfg.buildSessionFactory();
			
		}
		return sf;
	}
	public static void main(String[] args) {
		getSessionFactory();
	}

}
