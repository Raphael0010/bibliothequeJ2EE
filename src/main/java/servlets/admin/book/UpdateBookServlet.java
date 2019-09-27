package servlets.admin.book;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Livre;
import utils.JPAUtil;

@WebServlet("/admin/book/update")
public class UpdateBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "from Livre where id = " + id;
            Livre result = null;
            TypedQuery<Livre> q = entityManager.createQuery(sql, Livre.class);
            result = q.getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();

            System.out.println(result);

            request.setAttribute("livre", result);
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/admin/book/update.jsp");
            RequetsDispatcherObj.forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String prix = request.getParameter("prix");
        String annee = request.getParameter("annee");
        String img = request.getParameter("img");
        String id = request.getParameter("id");

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "UPDATE Livre set titre = '" + titre + "', auteur = '" + auteur + "', prix = '" + prix
                    + "', annee = '" + annee + "', img = '" + img + "' WHERE id = " + id;

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
