package Controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Contact;
import Service.Contact_service;

/**
 * Servlet implementation class Contact_controller
 */
@WebServlet("/contact")
public class Contact_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contact_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("page", "contact");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("subject");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String content = request.getParameter("content");

		if (name.length() == 0 || mail.length() == 0 || phone.length() == 0 || content.length() == 0 || name == null
				|| mail == null || phone == null || content == null) {
			request.setAttribute("fail", "Vui lòng điền các trường đầy đủ!");
		} else if (mail.indexOf("@") == -1 || mail.indexOf("gmail.com") == -1) {
			request.setAttribute("fail", "Email không hợp lệ!");
		} else if (phone.length() < 10 || phone.length() > 10) {
			request.setAttribute("fail", "Số điện thoại không hợp lệ!");
		} else {
			request.setAttribute("success", "Phản hồi của bạn thành công, cảm ơn!");
			Contact_service contact = new Contact_service();
			contact.insertContact(name, phone, mail, content);
		}
		request.setAttribute("page", "contact");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}
}
