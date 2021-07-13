package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Service.Category_service;

/**
 * Servlet implementation class Category
 */
@WebServlet("/category_manager")
public class Category_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		Category_service cm = new Category_service();
		int count =cm.getTotalCategory();
		int andPage =count/7;
		if(count % 7 != 0) {
			andPage++;
		}
		List<Category> list = cm.pagingCategory(index);
		request.setAttribute("listCate", list);
		request.setAttribute("andPag",andPage);
		request.setAttribute("tag", index);
		request.setAttribute("page", "category");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);

	}

	

}
