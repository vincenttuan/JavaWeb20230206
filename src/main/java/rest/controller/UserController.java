package rest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rest.entity.User;
import rest.service.UserService;

@WebServlet("/rest/user/*")
public class UserController extends HttpServlet {
	
	private UserService userService = UserService.getUserServiceInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/rest/user_form.jsp");
		req.setAttribute("users", userService.queryAll());
		req.setAttribute("_method", "POST");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		int salary = Integer.parseInt(req.getParameter("salary"));
		User user = new User(name, salary);
		userService.add(user);
		// 重導
		resp.sendRedirect("/JavaWeb/rest/user/");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("doPut()");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("doDelete()");
	}

	
}
