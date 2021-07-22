package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
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
 * Servlet implementation class News_add
 */
@MultipartConfig
@WebServlet("/news_add")
public class News_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public News_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String title =request.getParameter("Title");
			String describe = request.getParameter("Describe");
			String content = request.getParameter("Content");
			Part part =request.getPart("photo_news");
			News_service nm = new News_service();
			String realPart ="E:\\Project\\Admin_Project\\WebContent\\uploads";
			String image =Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPart))) {
				Files.createDirectory(Path.of(realPart));
			}
			part.write(realPart+ "/"+image);
			
			nm.insertNews(title, describe, image, content);
		} catch (Exception e) {
			
		}
		response.sendRedirect("news");
	}
	}
	

