package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Model.Product;
import Service.Category_service;
import Service.Product_service;


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
		Product_service home = new Product_service();
		List<Product> list = home.querySearch(name_product);
		Category_service cs = new Category_service();
		List<Category> category = cs.getListCategory();
		int list1=0;
		list1=home.kqSearch(name_product); 
		request.setAttribute("category", category);
		request.setAttribute("list_search", list);
		request.setAttribute("tong", list1);
		request.setAttribute("page", "search");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
		
	}

}
