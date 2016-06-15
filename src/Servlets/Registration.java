package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		request.setAttribute("error", "NAME ZANIATO!");
		try {
			ClassConnector c = new ClassConnector();
				if (c.selectLoginCheck(login) != true){
					if(login.trim().length()==0){
						request.setAttribute("loginError", "Can't be blank");
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
						requestDispatcher.forward(request, response);
					}else if(password.trim().length()==0){
						request.setAttribute("prevLog", login);
						request.setAttribute("prevFirst", firstName);
						request.setAttribute("prevLast", lastName);
						request.setAttribute("pwdError", "Can't be blank");
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
						requestDispatcher.forward(request, response);
					}else if(password.trim().length()<6){
						request.setAttribute("prevLog", login);
						request.setAttribute("prevFirst", firstName);
						request.setAttribute("prevLast", lastName);
						request.setAttribute("pwdError", "Is too short (min is 6 characters)");
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
						requestDispatcher.forward(request, response);
					}else if(password.trim().length()>12){
						request.setAttribute("prevLog", login);
						request.setAttribute("prevFirst", firstName);
						request.setAttribute("prevLast", lastName);
						request.setAttribute("pwdError", "Is too long (max is 12 characters)");
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
						requestDispatcher.forward(request, response);
					}else if(firstName.trim().length()==0){
						request.setAttribute("prevLog", login);
						request.setAttribute("fError", "Can't be blank");
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
						requestDispatcher.forward(request, response);
					}else if(lastName.trim().length()==0){
						request.setAttribute("prevLog", login);
						request.setAttribute("prevFirst", firstName);
						request.setAttribute("lError", "Can't be blank");
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
						requestDispatcher.forward(request, response);	
					}else{
						c.insertNewUser(login, password, firstName, lastName);
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registrationSuccess.jsp");
						requestDispatcher.forward(request, response);
					}
				}else{
					request.setAttribute("loginError", "Is already taken");
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
					requestDispatcher.forward(request, response);
				}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

