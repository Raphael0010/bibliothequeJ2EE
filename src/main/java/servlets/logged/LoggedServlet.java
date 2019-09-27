package servlets.logged;

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

import java.util.List;
import utils.JPAUtil;

@WebServlet("/logged/index")
public class LoggedServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "from Livre";
            List<Livre> result = null;
            TypedQuery<Livre> q = entityManager.createQuery(sql, Livre.class);
            result = q.getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();

            System.out.println(result);

            request.setAttribute("livres", result);
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/logged/index.jsp");
            RequetsDispatcherObj.forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
