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

import Service.News_service;

/**
 * Servlet implementation class News_update
 */
@MultipartConfig
@WebServlet("/news_update")
public class News_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try {
			News_service ns = new News_service();
			int idnw = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String describe = request.getParameter("describe");
			String content = request.getParameter("content");
			String images = request.getParameter("images");
			ns.updateNews(title, images, describe, content, 0, idnw);
			Part part = request.getPart("photo");
			String realPart = "C:\\Users\\Nhat Thinh\\Documents\\NEW\\Project\\Admin_Project\\WebContent\\uploads";
			String image = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPart))) {

				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart + "/" + image);
			ns.updateNews(title, image, describe, content, 0, idnw);
			
		} catch (Exception e) {

		}

		response.sendRedirect("news");
	}
}
