package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 路徑測試:
 * http://localhost:8080/JavaWeb/servlet/bmi
 * http://localhost:8080/JavaWeb/servlet/bmi?height=170&weight=60
 * */
@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.確認編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 2.取得參數
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		// 3.確認是否有參數?
		if (height == null || weight == null) {
			resp.getWriter().print("無參數或參數不正確");
			return;
		}
		// 4.進行轉型 String -> double
		double h = 0, w = 0;
		try {
			h = Double.parseDouble(height);
			w = Double.parseDouble(weight);
		} catch (Exception e) {
			resp.getWriter().print("請輸入正確數值資料");
			return;
		}
		// 5. 資料檢查合理性
		if(h < 10 || h > 300 || w < 10 || w > 1000) {
			resp.getWriter().print("資料不正確, 超過合理範圍~~");
			return;
		}
		// 6.計算 BMI
		double bmi = w / Math.pow(h/100, 2);
		String output = String.format("身高:%.1f 體重:%.1f BMI:%.2f", h, w, bmi);
		resp.getWriter().print(output);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
	}
	
}
