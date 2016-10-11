package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.entity.Category;

@WebServlet("/Auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
       

	public void init(ServletConfig config) throws ServletException {
		emf = Persistence.createEntityManagerFactory("persistenceUnit");
		
	}

	public void destroy() {
		emf.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/Auth/addCategory.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category cat = new Category();
		cat.setName(request.getParameter("name"));
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try
		{
			t.begin();
			em.persist(cat);
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
