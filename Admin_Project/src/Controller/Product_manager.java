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
 * Servlet implementation class ProductManager
 */
@WebServlet("/product_manager")
public class Product_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Category_service categoryModel = new Category_service();
		List<Category> listcate = categoryModel.getListCategory();
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index =Integer.parseInt(indexPage);
		Product_service pm = new Product_service();
		int count  = pm.Countproduct();
		int endPage = count/12;
		if(endPage % 12 != 0) {
			endPage++;
			
		}
		List<Product>  list = pm.Allproduct(index);
		request.setAttribute("listproduct", list);
		request.setAttribute("andPag",endPage);
		request.setAttribute("tag", index);
		request.setAttribute("listcategory", listcate);
		request.setAttribute("page", "product");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
