package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Product;
import Model.Size;
import Model.Item;
import Model.Order;
import Service.Product_service;
import Service.Size_service;
@WebServlet("/cart_add")
public class Cart_add_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int quantity = 1;
	int id_tmp;
    public Cart_add_controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id;
		Product_service ps = new Product_service();
		Size_service ss = new Size_service();
		if (request.getParameter("id_product") != null) {
			id = Integer.parseInt(request.getParameter("id_product"));
			Product pd = ps.getProductById(id);
			Size s = ss.getSizeById(id_tmp);
			if (pd != null) {

				HttpSession session = request.getSession();
				if (session.getAttribute("order") == null) {
					Order order = new Order();
					List<Item> listItems = new ArrayList<>();
					Item item = new Item();
					item.setQuantity(quantity);
					item.setProduct(pd);
					item.setSize(s);
					if(pd.getSale() > 0) {
						item.setPrice(pd.getSale());
					}else {
						item.setPrice(pd.getPrice());
					}
					listItems.add(item);
					order.setItems(listItems);
					session.setAttribute("order", order);
				} else {
					Order order = (Order) session.getAttribute("order");
					List<Item> listItems = order.getItems();
					boolean check = false;
					for (Item item : listItems) {
						if (item.getProduct().getId() == pd.getId() && item.getSize().getId() == s.getId()) {
							item.setQuantity(item.getQuantity() + quantity);
							check = true;
						}
					}
					if (check == false) {
						Item item = new Item();
						item.setQuantity(quantity);
						item.setProduct(pd);
						item.setSize(s);
						item.setPrice(pd.getPrice());
						listItems.add(item);

					}

					session.setAttribute("order", order);

					// session.setMaxInactiveInterval(6000);

				}
			}
			response.sendRedirect("index");
		} else {
			response.sendRedirect("index");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Size_service ss = new Size_service();
		List<Size> list =ss.Size();
		String size =request.getParameter("size");
		String tmp =null;
		int id = 0;
		for (Size s : list) {
			tmp = s.getName();
			id = s.getId();
			if (tmp.equals(size)) {
				id_tmp = id;
			}
		}
		if (request.getParameter("quantity") != null) {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		doGet(request, response);
	}

}