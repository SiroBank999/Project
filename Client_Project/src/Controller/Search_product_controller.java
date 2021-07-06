package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Service.Search;
/**
 * Servlet implementation class Search_product_controller
 */
@WebServlet("/search")
public class Search_product_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_product_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		request.setAttribute("txtsearch", name_product);
		request.setAttribute("page", "search");
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
