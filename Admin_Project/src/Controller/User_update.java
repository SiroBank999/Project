package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserModel;

/**
 * Servlet implementation class User_update
 */
@WebServlet("/user_update")
public class User_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id =Integer.parseInt(request.getParameter("id"));
		request.setAttribute("page", "user_update");
		request.getRequestDispatcher("decorators/admin.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status_1");
		UserModel um = new UserModel();
		um.updateUser_admin(status, id);
		response.sendRedirect("user_manager");
	}

}
