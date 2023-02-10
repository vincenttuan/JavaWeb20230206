package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet/demo")
public class DemoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("執行 doGet() 方法<br>");
		resp.getWriter().print("URL 分析<br>");
		resp.getWriter().print("ContextPath: " + req.getServletContext().getContextPath() + "<br>");
		resp.getWriter().print("ServletPath:" + req.getServletPath() + "<br>");
		resp.getWriter().print("PathInfo:" + req.getPathInfo() + "<br>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("執行 doPost() 方法");
		resp.getWriter().print("URL 分析<br>");
		resp.getWriter().print("ContextPath: " + req.getServletContext().getContextPath() + "<br>");
		resp.getWriter().print("ServletPath:" + req.getServletPath() + "<br>");
		resp.getWriter().print("PathInfo:" + req.getPathInfo() + "<br>");
		
	}
	
}
