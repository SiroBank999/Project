package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.Category;
import Model.Product;
import Service.Category_service;
import Service.Product_service;

/**
 * Servlet implementation class Searchproduct
 */
@WebServlet("/Searchproduct")
public class Searchproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Searchproduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String product = request.getParameter("tensanpham");
		Product_service pr = new Product_service();
		List<Product> list = pr.Searchproduct(product);
		request.setAttribute("search_product", list);
		request.setAttribute("page", "seach_product");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}

	protected void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String productname = request.getParameter("productname_1");
			int price = Integer.parseInt(request.getParameter("price_1"));
			int sale = Integer.parseInt(request.getParameter("sale_1"));
			String status = request.getParameter("status_1");
			String describe = request.getParameter("describe_1");
			String category = request.getParameter("category_1");
			String fabric = request.getParameter("fabric_1");

			if (price == sale) {
				sale = 0;
			}
			Category_service cm = new Category_service();
			List<Category> listCate = cm.getListCategory();
			String categoryname = null;
			int id_category = 0;
			int id = 0;
			for (Category cate : listCate) {
				categoryname = cate.getCategoryname();
				id = cate.getId();
				if (categoryname.equals(category)) {
					categoryname = "" + id;
					id_category = Integer.valueOf(categoryname);
				}
			}
			Part part = request.getPart("photo1");
			Product_service pm = new Product_service();

			String realPart = "C:\\Users\\Nhat Thinh\\Documents\\NEW\\Project\\Admin_Project\\WebContent\\uploads";
			String image = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart + "/" + image);
			pm.insertProduct(productname, price, sale, image, describe, id_category, fabric, status);
		} catch (Exception e) {

		}
		response.sendRedirect("product_manager");
	}
}
