package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Admin_service;
import Model.Admin;

@WebServlet("/login")
public class Login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	
	}  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		Admin_service am = new Admin_service();
		Admin admin = am.CheckAcc(username, password);
		if (admin == null) {
			request.setAttribute("alert", 1);
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			Cookie cusername = new Cookie("cusename", username);
			Cookie cpassword = new Cookie("cpassword", password);
			cusername.setMaxAge(600);
			cpassword.setMaxAge(600);
			response.addCookie(cusername);
			response.addCookie(cpassword);
			response.sendRedirect("admin");
		}
	}
	
}
