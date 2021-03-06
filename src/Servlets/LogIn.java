package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		try {
			ClassConnector c = new ClassConnector();
			if (c.selectLoginPwdCheck(login, password) != false){
				HttpSession session = request.getSession();
				session.setAttribute("authorization", c.selectUserID(login));
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Authorize");
				requestDispatcher.forward(request, response);
			}else{
				request.setAttribute("authError", "Wrong login or passoword!");
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/RedirectToIndex");
				requestDispatcher.forward(request, response);
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
