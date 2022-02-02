package bbangscompany.service;

import bbangscompany.domain.Image;
import bbangscompany.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    /**
     * 이미지 등록
     */
    @Transactional
    public Long imgSave(Image image) {
        imageRepository.save(image);
        return image.getId();
    }

    /**
     * 이미지 전체 조회
     */
    public List<Image> findImages() {
        return imageRepository.findAll();
    }

    /**
     * 이미지 단건 조회
     */
    public Image findOne(Long imageId) {
        return imageRepository.findOne(imageId);
    }

}
