package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Service.Search;

@WebServlet(urlPatterns = { "/search" })
public class Search_product_controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Search_product_controller() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name_product = request.getParameter("timkiem");

		Search home = new Search();
		List<Product> list = null;
		int list1=0;
		try { 
		  list1=home.kqSearch(name_product); }
		  catch (SQLException e1) { 
			  e1.printStackTrace(); 
			  }
		 
		try {
			list = home.querySearch(name_product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("search", list);
		request.setAttribute("tong", list1);
		request.setAttribute("page", "search");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
		/*
		 * RequestDispatcher
		 * dispatcher=request.getServletContext().getRequestDispatcher(
		 * "/pages/search.jsp"); dispatcher.forward(request, response);
		 */
	}

}
