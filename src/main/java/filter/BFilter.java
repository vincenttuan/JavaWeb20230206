package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/servlet/*")
public class BFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1.請求過濾
		System.out.println("BFilter request");
		// 2.放行
		chain.doFilter(request, response);
		// 3.回應過濾
		System.out.println("BFilter response");
	}

}
