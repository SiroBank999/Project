package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Service.Category_service;

@MultipartConfig
@WebServlet("/category_update")
public class Category_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Category_update() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			int idpm = Integer.parseInt(request.getParameter("id_c"));
			String categoryname = request.getParameter("categoryname_c");
			String image1 = request.getParameter("img1");
			
			if (image1.length() != 0) {
				Category_service pm = new Category_service();		
				pm.updateCategory(categoryname, image1, idpm);
			}

			System.out.print(idpm);
			System.out.println(categoryname);
			Part part = request.getPart("photo1");
			Category_service pm = new Category_service();

			String realPart = "C:\\Users\\Nhat Thinh\\Documents\\NEW\\Project\\Admin_Project\\WebContent\\uploads";
			String image = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart + "\\" + image);
			System.out.println(categoryname + image);
			pm.updateCategory(categoryname, image, idpm);
		} catch (Exception e) {

		}
		response.sendRedirect("category_manager");
	}
}
