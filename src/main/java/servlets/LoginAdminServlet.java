package servlets;

import java.io.IOException;
import utils.JPAUtil;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/loginAdmin.jsp");
        RequetsDispatcherObj.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("userAdmin");
        String pass = request.getParameter("passAdmin");

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "select login from Admin where login = '" + user + "' and pass = '" + pass + "'";

            String result = (String) entityManager.createNativeQuery(sql).getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();
            // Si il existe
            if (result != null) {
                // on fait la session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("pass", pass);
                session.setAttribute("admin", true);
                // on le ramene sur la page index des user logged
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(request.getContextPath() + "/admin/index");

            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(request.getContextPath() + "/loginAdmin");
            }

        } catch (Exception e) {
            System.out.println(e);
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(request.getContextPath() + "/loginAdmin");
        }
    }
}
