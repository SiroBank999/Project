package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;
import Model.Statistic;
import Service.Statistic_service;

@WebServlet ("/doanhthu")
public class Statistic_month extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		Statistic_service cm = new Statistic_service();
		int count =cm.getTotalOrder();
		int andPage =count/8;
		if(count % 8 != 0) {
			andPage++;
		}
		List<Order> list = cm.pagingOrder(index);
		request.setAttribute("listOrder", list);
		request.setAttribute("andPag",andPage);
		request.setAttribute("tag", index);
		request.setAttribute("page", "statistic");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
