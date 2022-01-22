package bbangscompany.repository;

import bbangscompany.domain.Picture;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMainRepository implements MainRepository {

    private static Map<Long, Picture> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Picture save(Picture picture) {

        picture.setId(++sequence);
        store.put(picture.getId(), picture);

        return picture;
    }

    @Override
    public Optional<Picture> findbyId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Picture> findByName(String name) {
        return store.values().stream()
                .filter(picture -> picture.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Picture> findAll() {
        System.out.println("findAll");
        return new ArrayList<>(store.values());
    }

    @Override
    public void remove() {
        store = new HashMap<>();
    }
}
