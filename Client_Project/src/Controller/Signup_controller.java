
package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Service.User_service;

/**
 * Servlet implementation class Signup_controller
 */
@WebServlet("/signup")
public class Signup_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "signup");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		User register = new User(fullname, username, password, phone, email, "ENABLE");
		User user = null;
		String errou = null;
		User_service user_service = new User_service();
		try {
			user = user_service.CheckUsername(username);
		} catch (Exception e) {

		}
		if (user != null) {
			errou = "Tên người dùng đã tồn tại!";
		}
		String regex_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (!email.matches(regex_email)) {
			errou = "Email không hợp lệ!";
		}
		String regexPhone = "0\\d{9}";
		if (!phone.matches(regexPhone)) {
			errou = "Vui lòng nhập lại số điện thoại hợp lệ";
		}
		if (errou == null) {
			user_service.insertAcc(register);
		}
		request.setAttribute("errou", errou);
		request.setAttribute("signup", register);

		if (errou != null) {
			request.setAttribute("page", "signup");
			request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/signin");
		}	

	}
	}


