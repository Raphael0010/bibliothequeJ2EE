package servlets.admin.book;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JPAUtil;

@WebServlet("/admin/book/delete")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "delete from Livre where id = " + id;

            entityManager.createNativeQuery(sql).executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();

            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(request.getContextPath() + "/admin/index");

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
