package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.sun.supcommerce.exception.UnknownProductException;


@WebServlet("/showProduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try
		{
			long id = Long.parseLong(request.getParameter("id"));
			SupProduct product = SupProductDao.findProductById(id);
			writer.println("<h2>Product detail</h2>");
			writer.println("<p>" + product.getId() + " " + product.getName() + " : " + product.getContent() + " => " + product.getPrice() + "<p>");
		}
		catch(NumberFormatException e)
		{
			writer.println("<h1>The product id format is incorrect</h1>");
		}
		catch(UnknownProductException e)
		{
			writer.println("<h1>The product id is not found</h1>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
