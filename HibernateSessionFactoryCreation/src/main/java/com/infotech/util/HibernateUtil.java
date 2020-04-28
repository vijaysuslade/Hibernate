package com.infotech.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	static {
		try {
			if (sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources metaDataSources = new MetadataSources(standardServiceRegistry);
				Metadata metadata = metaDataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}

	}

	/*
	 * static {
	 * 
	 * // Creating StandardServiceRegistryBuilder StandardServiceRegistryBuilder
	 * registryBuilder = new StandardServiceRegistryBuilder();
	 * 
	 * Map<String, String> dbSettings = new HashMap<String,String>();
	 * dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/employee");
	 * dbSettings.put(Environment.USER, "root"); dbSettings.put(Environment.PASS,
	 * "vijay123"); dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	 * dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
	 * dbSettings.put(Environment.HBM2DDL_AUTO,"create");
	 * 
	 * registryBuilder.applySettings(dbSettings); standardServiceRegistry =
	 * registryBuilder.build(); MetadataSources sources = new
	 * MetadataSources(standardServiceRegistry); // Creating Metadata Metadata
	 * metadata = sources.getMetadataBuilder().build(); // Creating SessionFactory
	 * sessionFactory = metadata.getSessionFactoryBuilder().build();
	 * 
	 * }
	 */

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}

}
