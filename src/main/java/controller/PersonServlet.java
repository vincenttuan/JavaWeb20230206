package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/person")
public class PersonServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 重導程序-建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/html/person_result.jsp");
		// 帶入給 jsp 的資料
		
		// 重導
		rd.forward(req, resp);
		
		
	}
	
	
}
