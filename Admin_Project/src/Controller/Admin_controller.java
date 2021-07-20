package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Order_service;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class Admin_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totals,customers,order,user=0;
		Order_service od=new Order_service();
		totals=od.getTotalOrderAdmin();
		customers=od.getCustomer();
		order=od.getOrder();
		user=od.getUserNew();
		request.setAttribute("totals", totals);
		request.setAttribute("customers", customers);
		request.setAttribute("order", order);
		request.setAttribute("user", user);
		request.setAttribute("page", "dashboard");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}