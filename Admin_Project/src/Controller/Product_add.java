package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.Category;
import Service.Category_service;
import Service.Product_service;

@MultipartConfig
@WebServlet("/product_add")
public class Product_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_add() {
    }
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertProduct(request, response);
	}
	protected void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String productname =request.getParameter("productname_1");
			int price = Integer.parseInt(request.getParameter("price_1"));
			int sale = Integer.parseInt(request.getParameter("sale_1"));
			String status = request.getParameter("status_1");
			String describe = request.getParameter("describe_1");
			String category = request.getParameter("category_1");
			String fabric = request.getParameter("fabric_1");
			
			if(price == sale) {
				sale = 0;
			} 
			Category_service cm = new Category_service();
			List<Category> listCate = cm.getListCategory();
			String categoryname =null;
			int id_category = 0;
			int id =0;
			for(Category cate : listCate) {
				categoryname = cate.getCategoryname();
				id = cate.getId();
				if(categoryname.equals(category)) {
					categoryname = ""+id;
					id_category = Integer.valueOf(categoryname);
				}
			}
			Part part =request.getPart("photo1");
			Product_service pm = new  Product_service();
			
			String realPart ="E:\\Project\\Admin_Project\\WebContent\\uploads";
			String image =Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart+ "/"+image);
			pm.insertProduct(productname, price, sale, image,describe, id_category, fabric, status);
		} catch (Exception e) {
			
		}
		response.sendRedirect("product_manager");
	}

}
