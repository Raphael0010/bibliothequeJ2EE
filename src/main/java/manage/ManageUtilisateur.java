package manage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import beans.Utilisateur;
import utils.JPAUtil;

public class ManageUtilisateur {

    public static List<Utilisateur> getAllUtilisateur() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Utilisateur> result = null;
        try {
            // Check database version
            String sql = "from Utilisateur";

            TypedQuery<Utilisateur> q = entityManager.createQuery(sql, Utilisateur.class);
            result = q.getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;

    }

    public static String createUtilisateur(String login, String pass) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Utilisateur u = new Utilisateur(login, pass);
            entityManager.persist(u);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "created";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static Utilisateur getAUtilisateur(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Utilisateur result = null;
        try {
            // Check database version
            String sql = "from Utilisateur where id = " + id;

            TypedQuery<Utilisateur> q = entityManager.createQuery(sql, Utilisateur.class);
            result = q.getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static String deleteAUtilisateur(Integer id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "delete from Utilisateur where id = " + id;

            entityManager.createNativeQuery(sql).executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();
            return "delete";

        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    public static String updateAUtilisateur(String id, String login, String pass) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            String sql = "UPDATE Utilisateur set login = '" + login + "', pass = '" + pass + "' WHERE id = "
                    + Integer.parseInt(id);

            entityManager.createNativeQuery(sql).executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();
            return "update";
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    public static String isUser(String login, String pass) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Utilisateur result = null;
        try {
            // Check database version
            String sql = "from Utilisateur where login = '" + login + "' and pass = '" + pass + "'";

            TypedQuery<Utilisateur> q = entityManager.createQuery(sql, Utilisateur.class);
            result = q.getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();

            if (result != null) {
                return "is user";
            } else {
                return "is not user";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "error";
    }

}