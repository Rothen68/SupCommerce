package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.sun.supcommerce.exception.UnknownProductException;

@WebServlet("/Auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		try
		{
			SupProductDao.removeProduct(id);
		}
		catch(UnknownProductException e)
		{
			System.out.println("<h1>The product id is not found</h1>");
		}
		response.sendRedirect(request.getServletContext().getContextPath() +  "/listProduct");
	}

}
