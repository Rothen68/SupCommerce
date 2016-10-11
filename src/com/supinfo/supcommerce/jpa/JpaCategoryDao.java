package com.supinfo.supcommerce.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.supinfo.supcommerce.dao.CategoryDao;
import com.supinfo.supcommerce.entity.Category;

public class JpaCategoryDao extends BaseJpa implements CategoryDao {

	public JpaCategoryDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void addCategory(Category c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try
		{
			t.begin();
			em.persist(c);
			t.commit();
		}
		finally
		{
			if(t.isActive())
			{
				t.rollback();
			}
			em.close();
		}
		
	}

}
