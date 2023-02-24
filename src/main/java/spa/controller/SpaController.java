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

@WebServlet("/servlet/spa/*")
public class SpaController extends HttpServlet {
	private SpaDao spaDao = new SpaDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("path info = " + req.getPathInfo());
		
		List<Spa> spaList = spaDao.queryAllSpas();
		List<Master> masterList = spaDao.queryAllMasters();
		List<Order> orderList = spaDao.queryOrders(); // 所有的預約單
		String dispatcherPath = null;
		switch (req.getPathInfo()) {
			case "/": // Spa 預約網頁 (http://localhost:8080/JavaWeb/servlet/spa/)
				dispatcherPath = "/WEB-INF/view/spa/spa.jsp";
				break;
			case "/list": // Spa 預約結果網頁 (http://localhost:8080/JavaWeb/servlet/spa/list)
				dispatcherPath = "/WEB-INF/view/spa/spa_reserve_result.jsp";
				break;	
			case "/login": // 登入網頁 (http://localhost:8080/JavaWeb/servlet/spa/login)
				dispatcherPath = "/WEB-INF/view/spa/spa_login.jsp";
				break;
			default:
				resp.sendRedirect("http://localhost:8080/JavaWeb/servlet/spa/"); // 重導至首頁
				return;
		}
		// 分派器
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherPath);
		req.setAttribute("spaList", spaList);
		req.setAttribute("masterList", masterList);
		req.setAttribute("orderList", orderList);
		rd.forward(req, resp);
		
	}
	
	// 新增預約按摩
	// spa.jsp 按下表單的預約按鈕後會執行到的方法
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getPathInfo()) {
			case "/": // 新增預約 (http://localhost:8080/JavaWeb/servlet/spa/) 
				doOrder(req, resp);
				break;
			case "/login": // 登入驗證 (http://localhost:8080/JavaWeb/servlet/spa/login) 
				doLogin(req, resp);
				break;
		}
	}
	
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 中文編碼配置
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print("login check...");
	}
	
	private void doOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 中文編碼配置
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 抓取表單參數
		String userName = req.getParameter("userName");
		Integer spaId = Integer.parseInt(req.getParameter("spaId"));
		Integer masterId = Integer.parseInt(req.getParameter("masterId"));
		String reserve = req.getParameter("reserve");
		// 根據 spaId 取得 Spa 物件
		Spa spa = spaDao.queryAllSpas().stream()
					.filter(sp -> sp.getId().intValue() == spaId.intValue())
					.findFirst()
					.get();
		// 建立預約訂單物件
		Order order = new Order();
		order.setId(1);
		order.setUserName(userName);
		order.setSpaId(spaId);
		order.setSpaPrice(spa.getPrice());
		order.setSpaTime(spa.getTime());
		order.setMasterId(masterId);
		order.setReserve(reserve);
		
		// 將此預約單放入到orderList中
		List<Order> orderList = spaDao.queryOrders(); // 所有的預約單
		orderList.add(order);
		
		// 分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/spa/spa_reserve_result.jsp");
		req.setAttribute("order", order); // 本次預約訂單
		req.setAttribute("orderList", orderList); // 所有的預約單(歷史預約單紀錄)
		rd.forward(req, resp);
	} 
	
}
