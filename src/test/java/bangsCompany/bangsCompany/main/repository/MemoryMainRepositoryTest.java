package bangsCompany.bangsCompany.main.repository;

import bangsCompany.bangsCompany.main.domain.Picture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMainRepositoryTest {

    MemoryMainRepository repository = new MemoryMainRepository();

    @Test
    void save() {
        Picture picture = new Picture();
        picture.setName("test");

        repository.save(picture);

        Picture result = repository.findbyId(picture.getId()).get();
        Assertions.assertThat(picture).isEqualTo(result);
    }

    @Test
    void findbyId() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
        Picture picture1 = new Picture();
        picture1.setName("test1");
        repository.save(picture1);

        Picture picture2 = new Picture();
        picture2.setName("test2");
        repository.save(picture2);

        List<Picture> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}