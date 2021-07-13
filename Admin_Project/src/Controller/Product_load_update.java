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


@WebServlet("/product_load_update")
public class Product_load_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id_pd;
    public Product_load_update() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id_pd = Integer.parseInt(request.getParameter("id_pd"));
		Category_service categoryModel = new Category_service();
		List<Category> listcate = categoryModel.getListCategory();
		request.setAttribute("listcategory", listcate);
		Product_service pm = new Product_service();
		Product pd =pm.getProductById(id_pd);
		request.setAttribute("pd", pd);
		request.setAttribute("page","product_update");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);	
	
	}
	

	
	

}
