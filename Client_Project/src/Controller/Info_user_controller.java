package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

import Service.User_service;

/**
 * Servlet implementation class Info_user_controller
 */
@WebServlet("/info")
public class Info_user_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info_user_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession  session =request.getSession();
		User user = (User)session.getAttribute("user");
			id = user.getId();
		
		request.setAttribute("page", "infouser");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fullname = request.getParameter("Fullname");
		String password = request.getParameter("Password");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		String repass = request.getParameter("RePassword");
		
			
			if(password.equals(repass)){
				User_service um = new User_service();
				um.updateUser(fullname, phone, email, password, id);
				response.sendRedirect("index");
			}else {
				response.sendRedirect("info");
			}
	}

}
