package bangsCompany.bangsCompany.main.repository;

import bangsCompany.bangsCompany.main.domain.Picture;

import java.util.List;
import java.util.Optional;

public interface MainRepository {

    Picture save(Picture picture);
    Optional<Picture> findbyId(Long id);
    Optional<Picture> findByName(String name);
    List<Picture> findAll();
}
