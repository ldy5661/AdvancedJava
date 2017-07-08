package net.antra.deptemp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.deptemp.businessLogic.DepartmentService;
import net.antra.deptemp.businessLogic.EmployeeService;

public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String deptIdStr = request.getParameter("department");
		EmployeeService es = new EmployeeService();
		try {
			request.getSession().setAttribute("empList", es.addNewEmployee(firstName, lastName, age, deptIdStr));
			// you need to reset deptList when you add a new emp
			request.getSession().setAttribute("deptList", new DepartmentService().getDeptList());
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
