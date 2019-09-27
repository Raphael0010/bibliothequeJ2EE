package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/logged/*")
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void destroy() {
        // method
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        System.out.println("doFilter" + " - user " + req.getSession().getAttribute("user") + " - pass "
                + req.getSession().getAttribute("pass"));

        if (session.getAttribute("user") != null && session.getAttribute("pass") != null) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init Filter");
    }
}