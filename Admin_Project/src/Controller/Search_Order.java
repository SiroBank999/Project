package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;
import Service.Order_service;

@WebServlet(urlPatterns = { "/donhang" })
public class Search_Order extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Search_Order() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String order = request.getParameter("donhang");
		Order_service od=new Order_service();
		List<Order> list = od.SearchOrder(order);
		request.setAttribute("search_order", list);
		request.setAttribute("page", "seach");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
		
	}

}
