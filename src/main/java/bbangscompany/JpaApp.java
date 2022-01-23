package bbangscompany;

import bbangscompany.domain.*;

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
            user.setUid("aaaa");
            user.setUpw("see111");
            user.setUserType(UserType.ADMIN);
            em.persist(user);

            Image image = new Image();
            image.setUser(user);
            image.setChannelName(ChannelName.블로그);
            image.setDivision(Division.blog);
            em.persist(image);

            tx.commit();
        } catch (Exception e) {
            em.close();
        } finally {
            emf.close();
        }
    }
}
