package bbangscompany.repository;

import bbangscompany.domain.CoverImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CoverImageRepository {

    private final EntityManager em;

    public void save(CoverImage coverImage) {
        em.persist(coverImage);
    }

    public CoverImage findOne(Long id) {

        CoverImage coverImage = null;

        try {
            coverImage = em.find(CoverImage.class, id);
        } catch (Exception e) {
            log.info("error : ", e.toString());
        }

        return coverImage;
    }
}
