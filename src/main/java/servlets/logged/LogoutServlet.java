package servlets.logged;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logged/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // logout
        // on get la session
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null && session.getAttribute("pass") != null) {
            session.setAttribute("user", null);
            session.setAttribute("pass", null);
        }
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
