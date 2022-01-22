package bbangscompany;

import bbangscompany.domain.User;
import bbangscompany.domain.UserType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            User user = new User();
            user.setUid("ab");
            user.setUpw("1234!!");
            user.setUserType(UserType.USER);

            em.persist(user);

            tx.commit();
        } catch (Exception e) {
            em.close();
        } finally {
            emf.close();
        }
    }
}
