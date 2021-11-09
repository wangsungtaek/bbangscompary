package bbangscompany.bbangscompany.main.service;

import bbangscompany.bbangscompany.main.domain.Picture;
import bbangscompany.bbangscompany.main.repository.MainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    /*
     * 사진 저장
     */
    public Long save(Picture picture) {

        mainRepository.save(picture);
        return picture.getId();
    }

    /*
     * 전체 사진 조회
     */
    public List<Picture> findPictures() {

        return mainRepository.findAll();
    }

    public void remove() {

        mainRepository.remove();
    }

}
