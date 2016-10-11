package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.jpa.JpaProductDao;
import com.supinfo.supcommerce.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory(){}
	
	public static CategoryDao getCategoryDao()
	{
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static ProductDao getProductDao()
	{
		return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
	}
}
