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
 * Servlet implementation class Blog_controller
 */
@WebServlet("/blog")
public class Blog_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Blog_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		News_service cm = new News_service();
		int count =cm.getTotalNews();
		int andPage =count/3;
		if(count % 3 != 0) {
			andPage++;
		}
		List<News> list = cm.pagingNews(index);
		News_service nm = new News_service();
		List<News> listnews = nm.getNews();
		request.setAttribute("listnews", listnews);
		request.setAttribute("listNews", list);
		request.setAttribute("andPag",andPage);
		request.setAttribute("tag", index);
		request.setAttribute("page", "blog");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
