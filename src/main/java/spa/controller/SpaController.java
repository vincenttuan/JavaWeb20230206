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
import spa.entity.Order;
import spa.entity.Spa;

@WebServlet("/servlet/spa")
public class SpaController extends HttpServlet {
	private SpaDao spaDao = new SpaDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Spa> spaList = spaDao.queryAllSpas();
		List<Master> masterList = spaDao.queryAllMasters();
		List<Order> orderList = spaDao.queryOrders();
		// 分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/spa/spa.jsp");
		req.setAttribute("spaList", spaList);
		req.setAttribute("masterList", masterList);
		req.setAttribute("orderList", orderList);
		rd.forward(req, resp);
	}
	
	// 新增預約按摩
	// spa.jsp 按下表單的預約按鈕後會執行到的方法
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		Integer spaId = Integer.parseInt(req.getParameter("spaId"));
		Integer masterId = Integer.parseInt(req.getParameter("masterId"));
		String reserve = req.getParameter("reserve");
		
		Spa spa = spaDao.queryAllSpas().stream()
					.filter(sp -> sp.getId().intValue() == spaId.intValue())
					.findFirst()
					.get();
		Order order = new Order();
		order.setId(1);
		order.setUserName(userName);
		order.setSpaId(spaId);
		order.setSpaPrice(spa.getPrice());
		order.setSpaTime(spa.getTime());
		order.setMasterId(masterId);
		order.setReserve(reserve);
		
		resp.getWriter().print("reserve: " + order);
		
	}
	
	
	
}
