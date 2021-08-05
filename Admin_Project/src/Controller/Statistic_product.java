package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Statistic;
import Service.Statistic_service;

@WebServlet ("/doanhthusanpham")
public class Statistic_product extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Statistic_product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");		
		Statistic_service cm = new Statistic_service();
		List<Statistic> list = cm.getRevenueProduct();
		request.setAttribute("listRevPr", list);
	
		request.setAttribute("page", "statistic_product");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
