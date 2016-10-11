package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;


@WebServlet("/cheaperProducts")
public class CheaperProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheaperProductsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list =  DaoFactory.getProductDao().getCheaperProducts(100f);
		request.setAttribute("productsList", list);
		getServletContext().getRequestDispatcher("/listProduct.jsp").forward(request, response);
		
	}

}
