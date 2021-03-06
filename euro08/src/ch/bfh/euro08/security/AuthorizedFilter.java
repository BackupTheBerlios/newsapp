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

public class AuthorizedFilter implements Filter {
    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String AUTH_USER = "Authorized_User";
        String SUP_USER = "Super_User";
        String validuser = null;
        String superuser;
        
        HttpSession session = req.getSession(true);        
        
        //If authorization key not in session, redirect to login page.
        validuser = (String) session.getAttribute(AUTH_USER);
        superuser = (String) session.getAttribute(SUP_USER);
        
        if(superuser !=null)
        {
        	res.sendRedirect(req.getContextPath() +  "/faces/admin/index.jsp");
        	return;
        }else if(validuser != null)
        {
        	res.sendRedirect(req.getContextPath() +  "/faces/app/index.jsp");
        	return;
        } 
        else
        {
        	chain.doFilter(request, response);
        	return;
        }

    }
}
