package servlets;

import java.io.IOException;
import utils.JPAUtil;
import beans.Utilisateur;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/register.jsp");
        RequetsDispatcherObj.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Tchek if champs sont pas vide

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        // on fait notre objet
        Utilisateur use = new Utilisateur(user, pass);

        // on le fait persisté en base de données
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(use);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // on fait la session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("pass", pass);

        // on le ramene sur la page index des user logged
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(request.getContextPath() + "/logged/index");
    }
}
