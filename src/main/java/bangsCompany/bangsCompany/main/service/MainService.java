package bangsCompany.bangsCompany.main.service;

import bangsCompany.bangsCompany.main.domain.Picture;
import bangsCompany.bangsCompany.main.repository.MainRepository;

import java.util.List;

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

}
