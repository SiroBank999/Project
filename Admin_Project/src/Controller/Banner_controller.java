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

import Model.BannerModel;

/**
 * Servlet implementation class Banner_controller
 */
@MultipartConfig
@WebServlet("/banner_manager")
public class Banner_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Banner_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "banner");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String title = request.getParameter("title");
			Part part =request.getPart("photo");
			String realPart ="F:\\JSP_Project\\JSP_Project\\WebContent\\Uploads";
			String filename =Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart+ "/"+filename);
			BannerModel bm = new BannerModel();
			bm.insertBanner(title, filename);
		} catch (Exception e) {
			
		}
		response.sendRedirect("banner_manager");
	}

}
