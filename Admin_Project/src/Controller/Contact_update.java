package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Contact_service;

/**
 * Servlet implementation class User_update
 */
@WebServlet("/contact_update")
public class Contact_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id =Integer.parseInt(request.getParameter("id"));
		request.setAttribute("page", "contact_update");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String status =request.getParameter("status_1");
		Contact_service um = new Contact_service();
		um.updatesContact(status, id);
		response.sendRedirect("contact_manager");
	}

}
