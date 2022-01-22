package bbangscompany.repository;

import bbangscompany.domain.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MainRepository {

    Picture save(Picture picture);
    Optional<Picture> findbyId(Long id);
    Optional<Picture> findByName(String name);
    List<Picture> findAll();
    void remove();
}
