package bbangscompany.repository;

import bbangscompany.domain.Collaborate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CollaborateRepository {

    private final EntityManager em;

    public void save(Collaborate collaborate) {
        em.persist(collaborate);
    }

    public Collaborate findOne(Long id) {
        return em.find(Collaborate.class, id);
    }

    public List<Collaborate> findAll() {
        return em.createQuery("select c from Collaborate c", Collaborate.class)
                .getResultList();
    }

    public List<Collaborate> findName(String name) {
        return em.createQuery("select c from Collaborate c where c.name = :name", Collaborate.class)
                .setParameter("name", name)
                .getResultList();
    }

    public void delete(Long id) {
        Collaborate collaborate = em.find(Collaborate.class, id);
        em.remove(collaborate);
    }
}
