package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Order;
import Model.User;
import Service.Order_service;

/**
 * Servlet implementation class Payment_Controller
 */
@WebServlet("/payment")
public class Payment_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String radioChecked = request.getParameter("payment");
		String fullname =request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		HttpSession  session =request.getSession();
		User user = (User) session.getAttribute("user");
		Order order = (Order) session.getAttribute("order");
		Order_service order_sv = new Order_service();
		switch (radioChecked) {
		case "COD":
			if(user == null) {
				order_sv.insertOrder(fullname, phone, email, address,1, order.getTotal());
			}else {
				order_sv.insertOrder(fullname, phone, email, address, user.getId(), order.getTotal());
			}
			session.removeAttribute("order");
			break;
		case "MOMO":
			
			break;
		case "VNPAY":
			
			break;
		default:
			break;
		}
		System.out.print(radioChecked);
		response.sendRedirect("index");
	}

}
