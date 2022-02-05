package bbangscompany.repository;

import bbangscompany.domain.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImageRepository {

    private final EntityManager em;

    public void save(Image image) {
        em.persist(image);
    }

    public Image findOne(Long id) {
        return em.find(Image.class, id);
    }

    public List<Image> findAll() {
        return em.createQuery("select i from Image i", Image.class)
                .getResultList();
    }

    public List<Image> findTitle(String title) {
        return em.createQuery("select i from Image i where i.title = :title", Image.class)
                .setParameter("title", title)
                .getResultList();
    }

    public void delete(Long id) {
        Image image = findOne(id);
        em.remove(image);
    }


}
