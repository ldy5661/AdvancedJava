package net.antra.deptemp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.antra.deptemp.businessLogic.DepartmentService;

public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("deptName");
		String email = request.getParameter("deptEmail");
		DepartmentService ds = new DepartmentService();
		request.getSession().setAttribute("deptList", ds.addNewDepartment(name, email));
		request.getRequestDispatcher("/WEB-INF/views/addDepartment.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
