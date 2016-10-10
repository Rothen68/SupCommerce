package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;


@WebServlet("/Auth/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Auth/addProduct.jsp").forward(req, resp);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		float price = Float.parseFloat(request.getParameter("price"));
		
		SupProduct p = new SupProduct();
		p.setName(name);
		p.setContent(content);
		p.setPrice(price);
		SupProductDao.addProduct(p);
		long id = p.getId();
		
		response.sendRedirect(request.getServletContext().getContextPath() +  "/showProduct?id=" + id);
	}

}
