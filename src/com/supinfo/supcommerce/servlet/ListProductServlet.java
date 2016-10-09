package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;


@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		List<SupProduct> list =  SupProductDao.getAllProducts();
		
		writer.println("<h2>Product list</h2>");
		writer.println("<ul>");
		for(SupProduct p : list)
		{
			writer.println("<li>" + p.getId() + " " + p.getName() + " => " + p.getPrice() + "</li>");			
		}
		writer.println("</ul>");
	}

}
