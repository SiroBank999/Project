package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.News;
import Service.News_service;


/**
 * Servlet implementation class News_load_update
 */
@WebServlet("/news_load_update")
public class News_load_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id_nw;
    public News_load_update() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id_nw = Integer.parseInt(request.getParameter("id_nw"));
		News_service ns = new News_service();
		News nw = ns.getNewsById(id_nw);
		request.setAttribute("nw", nw);
		request.setAttribute("page","news_update");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);	
	
	}
	

}
