package Controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Product_service;
import Model.Item;
import Model.Order;
import Model.Product;

/**
 * Servlet implementation class Cart_sub_controller
 */
@WebServlet("/cart_sub")
public class Cart_sub_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart_sub_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = 1;
		int id = Integer.parseInt(request.getParameter("id_product"));
		Product_service pm = new Product_service();
		Product pd = pm.getProductById(id);
		HttpSession  session =request.getSession();
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		for(Item item: listItems){
			if(item.getProduct().getId() == pd.getId()) {
				item.setQuantity(item.getQuantity()-quantity);
			}
		}
		session.setAttribute("order", order);
		response.sendRedirect("cart");
	}
}
