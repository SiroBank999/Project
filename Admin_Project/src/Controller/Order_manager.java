package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;
import Service.Order_service;


@WebServlet("/order_manager")
public class Order_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		Order_service cm = new Order_service();
		int count =cm.getTotalOrderNew();
		int andPage =count/6;
		if(count % 6 != 0) {
			andPage++;
		}
		String donhang=(String) request.getParameter("donhang");
		List<Order> list=null;
		if(donhang==null||donhang.equals("tatca") ) {
			list = cm.pagingOrderNew(index);
		}
		else if(donhang.equals("donmoi")) {
			list=cm.OrderNew();
		}else if(donhang.equals("dangxuli")) {
			list=cm.OrderProcessing();
		}else if(donhang.equals("hoanthanh")) {
			list=cm.OrderFinish();
		}else if(donhang.equals("dahuy")) {
			list=cm.OrderDestroy();
		}
		//List<Order> list = cm.pagingOrderNew(index);
		request.setAttribute("listOrderNew", list);
		request.setAttribute("luachon", donhang);
		request.setAttribute("andPag",andPage);
		request.setAttribute("tag", index);
			request.setAttribute("page","order");
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
