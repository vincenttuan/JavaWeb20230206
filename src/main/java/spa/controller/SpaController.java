package spa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spa.dao.SpaDao;
import spa.entity.Master;
import spa.entity.Spa;

@WebServlet("/servlet/spa")
public class SpaController extends HttpServlet {
	private SpaDao spaDao = new SpaDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Spa> spaList = spaDao.queryAllSpas();
		List<Master> masterList = spaDao.queryAllMasters();
		
		// 分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/spa/spa.jsp");
		req.setAttribute("spaList", spaList);
		req.setAttribute("masterList", masterList);
		rd.forward(req, resp);
	}
	
}
