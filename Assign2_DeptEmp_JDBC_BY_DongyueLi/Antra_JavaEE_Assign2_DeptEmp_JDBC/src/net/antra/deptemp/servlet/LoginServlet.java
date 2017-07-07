package net.antra.deptemp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.deptemp.businessLogic.DepartmentService;
import net.antra.deptemp.businessLogic.EmployeeService;
import net.antra.deptemp.utility.UserUtility;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean isValidUser = UserUtility.validateUser(userName, password, request);
		if(isValidUser) {
			request.getSession().setAttribute("invalidUser", false);
			request.getSession().setAttribute("userName", userName.toUpperCase());
			//load existing employee list
			EmployeeService empService = new EmployeeService();
			//load existing department list
			DepartmentService deptService = new DepartmentService();
			try {
				request.getSession().setAttribute("empList", empService.getEmpList());
				request.getSession().setAttribute("deptList", deptService.getDeptList());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("invalidUser", true);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
