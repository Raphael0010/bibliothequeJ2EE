package servlets.admin.book;

import java.io.IOException;
import beans.Livre;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JPAUtil;

@WebServlet("/admin/book/create")
public class CreateBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/admin/book/create.jsp");
        RequetsDispatcherObj.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String prix = request.getParameter("prix");
        String annee = request.getParameter("annee");
        String img = request.getParameter("img");

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Livre l = new Livre(titre, Integer.parseInt(annee), auteur, Float.parseFloat(prix), img);
            entityManager.persist(l);
            entityManager.getTransaction().commit();
            entityManager.close();
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(request.getContextPath() + "/admin/index");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
