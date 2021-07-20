package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;
import Model.Order_detail;
import Service.Item_order_service;
import Service.Order_service;

/**
 * Servlet implementation class Order_detail_controller
 */
@WebServlet("/order_detail")
public class Order_detail_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_detail_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		Order_service service = new Order_service();
		Order order = service.getOrderById(id);
		Item_order_service item_order_service = new Item_order_service();
		List<Order_detail> details =item_order_service.getListItemOrder(id);
		request.setAttribute("order", order);
		request.setAttribute("ListItem",details );
		request.setAttribute("page", "order_detail");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String adress = request.getParameter("address");
		String status = request.getParameter("status");
		Order_service service = new Order_service();
		service.UpdateOrder(id, fullname, phone, email, adress,status);
		response.sendRedirect("order_detail?id="+id+"");
		
	}

}
