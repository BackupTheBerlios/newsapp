package ch.bfh.euro08.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {
	private FilterConfig _filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		_filterConfig = filterConfig;
	}

	public void destroy() {
		_filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String SUP_USER = "Super_User";
		String superuser = null;

		HttpSession session = req.getSession(true);

		// If authorization key not in session, redirect to login page.
		superuser = (String) session.getAttribute(SUP_USER);

		if (superuser != null) {
			chain.doFilter(request, response);
			return;
		} else {
			// User not allowed access - redirect to login page
			res.sendRedirect(req.getContextPath() + "/faces/login.jsp");
			return;
		}

	}
}
