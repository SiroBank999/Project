
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Service.User_service;

/**
 * Servlet implementation class Signin_controller
 */
@WebServlet("/signin")
public class Signin_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signin_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("page", "signin");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		User_service um = new User_service();
		User user = um.CheckUser(username, password);
		boolean err = false;
		String errou = null;
		if (user == null) {
			err = true;
			errou = "Tên đăng nhập hoặc mật khẩu không chính xác!";
		}
		if (err) {
			request.setAttribute("errou", errou);
			request.setAttribute("page", "signin");
			request.getRequestDispatcher("decorators/web.jsp").forward(request, response);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			Cookie cusername = new Cookie("cusename", username);
			Cookie cpassword = new Cookie("cpassword", password);
			cusername.setMaxAge(100);
			cpassword.setMaxAge(100);
			response.addCookie(cusername);
			response.addCookie(cpassword);
			response.sendRedirect("index");
		}
	}

}
