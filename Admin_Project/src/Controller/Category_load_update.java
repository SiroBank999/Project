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
 * Servlet implementation class Category_load_update
 */
@WebServlet("/category_load_update")
public class Category_load_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id_pd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category_load_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id_pd = Integer.parseInt(request.getParameter("id_pd"));
		Category_service pm = new Category_service();
		Category pd =pm.getCateById(id_pd);
		request.setAttribute("pd", pd);
		request.setAttribute("page","category_update");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
