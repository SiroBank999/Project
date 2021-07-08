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

/**
 * Servlet implementation class Product_sale_controller
 */
@WebServlet("/Product_sale_controller")
public class Product_sale_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_sale_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String indexpage = request.getParameter("page");
		if (indexpage == null) {
			indexpage = "1";
		}

		int page = Integer.parseInt(indexpage);

		Product_service db = new Product_service();
		int count = db.Countproduct_sale();
		int endpage = count / 12;
		if (count % 12 != 0) {
			endpage++;
		}
		Product_service product_service = new Product_service();
		Category_service cs = new Category_service();
		List<Category> category = cs.getListCategory();
		List<Product> sale = product_service.product_sale(page);
		
		request.setAttribute("endpage", endpage); // pagination
		request.setAttribute("tag", page); // active
		request.setAttribute("category", category);
		request.setAttribute("hot", sale);
		request.setAttribute("page", "sale_product");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
