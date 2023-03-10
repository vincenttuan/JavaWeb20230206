package secret.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/secret/*")
public class SecretFilter extends HttpFilter {
	String password = "5678";
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		Object code = session.getAttribute("code");
		if(code != null && code.toString().equals(password)) {
			// 放行
			chain.doFilter(req, res);
		} else if(req.getParameter("passCode") != null) { // 有傳參數訪問
			String passCode = req.getParameter("passCode");
			if(passCode.equals(password)) {
				// 寫入 session
				session.setAttribute("code", passCode);
				// 放行
				chain.doFilter(req, res);
			} else {
				session.invalidate();
				// 重導
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/secret/secret.jsp");
				rd.forward(req, res);
			}
		} else {
			session.invalidate();
			// 重導
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/secret/secret.jsp");
			rd.forward(req, res);
		}
		
		
	}
	
}
