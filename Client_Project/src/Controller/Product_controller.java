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
import Model.Size;
import Service.Category_service;
import Service.Product_service;
import Service.Size_service;

/**
 * Servlet implementation class Product_controller
 */
@WebServlet("/product")
public class Product_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexpage = request.getParameter("page");
		if (indexpage == null) {
			indexpage = "1";
		}
		int page = Integer.parseInt(indexpage);

		Product_service db = new Product_service();
		int count = db.Countproduct();
		int endpage = count / 12;
		if (count % 12 != 0) {
			endpage++;
		}
		Product_service product_service = new Product_service();
		Category_service cs = new Category_service();
		List<Category> category = cs.getListCategory();
		String luachon=(String) request.getParameter("order-by");
		List<Product> sale=null;
		if(luachon==null) {
			sale = product_service.product(page);
		}
			else if(luachon.equals("title-ascending")) {
				sale=product_service.product_new_nameAsc();
			}else if(luachon.equals("title-descending")) {
				sale=product_service.product_new_nameDesc();
			}else if (luachon.equals("1")) {
				sale = product_service.product_new_filter();
			} else if (luachon.equals("2")) {
				sale = product_service.product_new_filter1();
			} else if (luachon.equals("3")) {
				sale = product_service.product_new_filter2();
			} else if (luachon.equals("4")) {
				sale = product_service.product_new_filter3();
			}else if(luachon.equals("created-ascending")) {
				sale=product_service.product_new_old();
			}else if (luachon.equals("created-descending")) {
				sale = product_service.product_new();
			}
		
		request.setAttribute("endpage", endpage); // pagination
		request.setAttribute("tag", page); // active
		request.setAttribute("category", category); // category
		request.setAttribute("hot", sale); // product
		request.setAttribute("page", "product");
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
