package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;
import Service.Statistic_service;

@WebServlet(urlPatterns = { "/search_statistic" })
public class Search_statistic extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Search_statistic() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Statistic_service revenue=new Statistic_service();
		String dayStartstr=request.getParameter("dayStart");
		String dayEndstr=request.getParameter("dayEnd");
		try {
			/*Date dayStart=new SimpleDateFormat("yyyy-mm-dd").parse(dayStartstr); 
			Date dayEnd=new SimpleDateFormat("yyyy-mm-dd").parse(dayEndstr);*/

			List<Order> list = revenue.querySearch(dayStartstr, dayEndstr);
			request.setAttribute("search_statistic", list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("page", "search_statistic");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);		
	}
}
