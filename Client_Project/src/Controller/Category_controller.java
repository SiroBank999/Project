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
 * Servlet implementation class Category_controller
 */
@WebServlet("/category")
public class Category_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		Product_service cs = new Product_service();
		List<Product> cate = null;
		Category_service sv = new Category_service();
		List<Category> category = sv.getListCategory();
		Category gr = sv.getnamebycategory(id);
		String luachon=(String) request.getParameter("order-by");
		if(luachon==null) {
			cate = cs.getproductbycategory(id);
		} else if(luachon.equals("1")) {
			cate=cs.getproductbycategoryFilter1(id);
		}else if(luachon.equals("2")) {
			cate=cs.getproductbycategoryFilter2(id);
		}else if(luachon.equals("3")) {
			cate=cs.getproductbycategoryFilter3(id);
		}else if(luachon.equals("4")) {
			cate=cs.getproductbycategoryFilter4(id);
		}
		
		request.setAttribute("cate", cate); // list
		request.setAttribute("namecate", gr); // láº¥y name á»Ÿ link
		request.setAttribute("category", category); // category
		
		request.setAttribute("page", "category");
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
