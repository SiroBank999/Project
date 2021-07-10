package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Item;
import Model.Order;
@WebServlet("/cart_remove")
public class Cart_remove_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Cart_remove_controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id_item"));
		HttpSession  session =request.getSession();
		Order order = (Order) session.getAttribute("order");
		if(order !=  null) {
			List<Item> listItems = order.getItems();
			listItems.remove(id);
		}
		session.setAttribute("order", order);
		response.sendRedirect("cart");
	}

}
