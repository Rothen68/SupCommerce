package com.supinfo.supcommerce.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supcommerce.dao.ProductDao;
import com.supinfo.supcommerce.entity.Product;

public class JpaProductDao extends BaseJpa implements ProductDao {

	public JpaProductDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public List<Product> getCheaperProducts(float priceUnder) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM Product as p WHERE p.price<:price");
		q.setParameter("price", priceUnder);
		List<Product> result = q.getResultList();
		em.close();
		return result;
	}

	@Override
	public List<Product> getAllProducts() {
		EntityManager em = emf.createEntityManager();		
		Query q = em.createQuery("SELECT p FROM Product as p");
		List<Product> result = q.getResultList();
		em.close();
		return result;
	}

	@Override
	public Product getProductById(long productId) {
		EntityManager em = emf.createEntityManager();		
		Product result = em.find(com.supinfo.supcommerce.entity.Product.class, productId);
		em.close();
		return result;
	}

	@Override
	public void deleteProduct(long productId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Query q = em.createQuery("DELETE FROM Product as p WHERE p.id=:id");
		q.setParameter("id", productId);
		
		try
		{
			t.begin();
			q.executeUpdate();
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

	@Override
	public void addProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try
		{
			t.begin();
			em.persist(p);
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
