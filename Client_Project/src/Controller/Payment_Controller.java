package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Item;
import Model.Order;
import Model.User;
import Service.Order_detail_service;
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String radioChecked = request.getParameter("payment");
		String fullname =request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		HttpSession  session =request.getSession();
		User user = (User) session.getAttribute("user");
		Order order = (Order) session.getAttribute("order");
		Order_service order_sv = new Order_service();
		Order_detail_service ordService = new Order_detail_service();
		List<Item> listitem =order.getItems();
		List<Order> listOrder =order_sv.getListOrder();
		String MADH ="";
		for(Order or: listOrder) {
				MADH ="DH-"+ RandomString();
				if(MADH.equals(or.getId())) {
					continue;
				}else{
					break;
				}
			}
		switch (radioChecked) {
		case "COD":
			if(order != null) {
				if(user == null) {
					order_sv.insertOrder(fullname, phone, email, address,1, order.getTotal(),MADH);
					
				}else {
					order_sv.insertOrder(fullname, phone, email, address, user.getId(), order.getTotal(),MADH);
					
				}
				for(Item item : listitem) {
					System.out.println(item.getQuantity()+MADH+item.getProduct().getId()+item.getSize().getId());
					ordService.insertOrderDetail(item.getQuantity(),MADH,item.getProduct().getId(),item.getSize().getId());
				}
			}
			session.removeAttribute("order");
			response.sendRedirect("index");
			break;
		case "VNPAY":
			request.getRequestDispatcher("vnpay_api/index.jsp").forward(request, response);
			break;
		case "MOMO":
			
			break;
		default:
			break;
		}
	
	}
	public String RandomString() {
		String CHAR_LIST ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int RANDOM_STRING_LENGTH = 10;
		Random rnd = new Random();
        StringBuilder sb = new StringBuilder(RANDOM_STRING_LENGTH);
        for (int i = 0; i <RANDOM_STRING_LENGTH; i++) {
            sb.append(CHAR_LIST.charAt(rnd.nextInt(CHAR_LIST.length())));
        }
        return sb.toString();
	}

}
