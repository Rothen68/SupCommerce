package com.supinfo.supcommerce.jpa;

import javax.persistence.EntityManagerFactory;

public class BaseJpa {
	protected EntityManagerFactory emf;
	
	public BaseJpa(EntityManagerFactory emf)
	{
		this.emf = emf;
	}
}
