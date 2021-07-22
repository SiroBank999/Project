package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Model.News;
import Model.Product;
import Service.Category_service;
import Service.News_service;


/**
 * @Servlet implementation class New_controller
 */
@MultipartConfig
@WebServlet("/news")
public class New_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index =Integer.parseInt(indexPage);
		News_service nm =  new News_service();
		int count  = nm.CountNews();
		int endPage = count/12;
		if(endPage % 12 != 0) {
			endPage++;
			
		}
		List<News>  list = nm.Allnews(index);
		request.setAttribute("listnews", list);
		request.setAttribute("andPag",endPage);
		request.setAttribute("tag", index);

		request.setAttribute("page", "news");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
