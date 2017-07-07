package net.antra.deptemp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.deptemp.businessLogic.DepartmentService;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("deptName");
		String email = request.getParameter("deptEmail");
		String[] empIDArray = request.getParameterValues("empID");
		DepartmentService ds = new DepartmentService();
		request.getSession().setAttribute("deptList", ds.addNewDepartment(name, email, empIDArray, (ArrayList<Employee>)request.getSession().getAttribute("empList"), (ArrayList<Department>) request.getSession().getAttribute("deptList")));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/addDepartment.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
