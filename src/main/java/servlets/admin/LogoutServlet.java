package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // logout
        // on get la session
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null && session.getAttribute("pass") != null
                && session.getAttribute("admin") != null) {
            session.setAttribute("user", null);
            session.setAttribute("pass", null);
            session.setAttribute("admin", null);
        }
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
