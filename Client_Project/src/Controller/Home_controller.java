package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Model.News;
import Model.Product;
import Service.Category_service;
import Service.News_service;
import Service.Product_service;

/**
 * Servlet implementation class Index_controller
 */
@WebServlet("/index")
public class Home_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product_service pro = new Product_service();
		News_service news = new News_service();
		List<News> listnews = news.getNews();
		List<Product> listpro = pro.getProductsale();
		List<Product> listnew = pro.getProductnew();
		request.setAttribute("productsale", listpro);
		request.setAttribute("productnew", listnew);
		request.setAttribute("listnews", listnews);
		Category_service cate = new Category_service();
		List<Category> listcate = cate.getListCategory();
		request.setAttribute("cate", listcate);
		request.setAttribute("page", "home");
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
