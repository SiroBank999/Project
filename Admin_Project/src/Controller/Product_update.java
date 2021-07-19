package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/product_update")
public class Product_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try {
			int idpm = Integer.parseInt(request.getParameter("id"));
			String productname = request.getParameter("productname");
			int price = Integer.parseInt(request.getParameter("price"));
			int sale = Integer.parseInt(request.getParameter("sale"));
			String status = request.getParameter("status");
			String describe = request.getParameter("describe");
			String category = request.getParameter("category");
			String datesub = request.getParameter("date");
			String fabric = request.getParameter("fabric");
			String image1 = request.getParameter("img1"); // ảnh cũ

			if (price == sale) {
				sale = 0;
			} 
			if (image1.length() != 0) {
				Category_service cm = new Category_service();
				Product_service pm = new Product_service();
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
				pm.updateProduct(productname, price, sale, image1, datesub, describe, id_category, fabric, status,
						idpm);
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
			Part part = request.getPart("photo");
			Product_service pm = new Product_service();

			String realPart = "C:\\Users\\Nhat Thinh\\Documents\\NEW\\Project\\Admin_Project\\WebContent\\uploads";
			String image = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart + "/" + image);
			pm.updateProduct(productname, price, sale, image, datesub, describe, id_category, fabric, status, idpm);
		} catch (Exception e) {

		}

		response.sendRedirect("product_manager");
	}

}
