package manage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import beans.Livre;
import utils.JPAUtil;

public class ManageLivre {

    public static List<Livre> getAllBook() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Livre> result = null;
        try {
            // Check database version
            String sql = "from Livre";

            TypedQuery<Livre> q = entityManager.createQuery(sql, Livre.class);
            result = q.getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;

    }

    public static Livre getABook(Integer id) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Livre result = null;
        try {
            // Check database version
            String sql = "from Livre where id = " + id;

            TypedQuery<Livre> q = entityManager.createQuery(sql, Livre.class);
            result = q.getSingleResult();

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static String createABook(String titre, String annee, String auteur, String prix, String img) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Livre l = new Livre(titre, Integer.parseInt(annee), auteur, Float.parseFloat(prix), img);
            entityManager.persist(l);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "created";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String updateABook(String id, String titre, String annee, String auteur, String prix, String img) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "UPDATE Livre set titre = '" + titre + "', auteur = '" + auteur + "', prix = '" + prix
                    + "', annee = '" + annee + "', img = '" + img + "' WHERE id = " + Integer.parseInt(id);

            entityManager.createNativeQuery(sql).executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();
            return "update";
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    public static String deleteABook(Integer id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            // Check database version
            String sql = "delete from Livre where id = " + id;

            entityManager.createNativeQuery(sql).executeUpdate();

            entityManager.getTransaction().commit();
            entityManager.close();
            return "delete";

        } catch (Exception e) {
            return "error " + e.toString();
        }
    }
}