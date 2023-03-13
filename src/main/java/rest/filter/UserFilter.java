package rest.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/rest/user/*")
public class UserFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 過濾 _method
		String _method = req.getParameter("_method");
		HttpServletRequestWrapper wrapperRequest = null;
		switch (_method) {
			case "POST":
				wrapperRequest = new HttpServletRequestWrapper(req) {
					@Override
					public String getMethod() {
						return "POST";
					}
				};
				chain.doFilter(wrapperRequest, res);
				break;
			case "PUT":
				wrapperRequest = new HttpServletRequestWrapper(req) {
					@Override
					public String getMethod() {
						return "PUT";
					}
				};
				chain.doFilter(wrapperRequest, res);
				break;
			case "DELETE":
				wrapperRequest = new HttpServletRequestWrapper(req) {
					@Override
					public String getMethod() {
						return "DELETE";
					}
				};
				chain.doFilter(wrapperRequest, res);
				break;	

			default: // 其他, 例如: GET
				chain.doFilter(req, res);
				break;
		}
	}
	
	
	
}
