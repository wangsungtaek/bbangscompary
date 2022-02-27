package bbangscompany.service;

import bbangscompany.domain.Collaborate;
import bbangscompany.domain.CoverImage;
import bbangscompany.repository.CoverImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CoverImageService {

    private final CoverImageRepository coverImageRepository;

    /**
     * 커버 이미지 등록 or 업데이트
     */
    @Transactional
    public Long createOrUpdate(CoverImage coverImage) {

        log.info("coverImage.getId() : " + coverImage.getId() );
        CoverImage findCoverImage = coverImageRepository.findOne(1L);

        if (findCoverImage == null) {
            log.info("커버 이미지 등록");
            coverImageRepository.save(coverImage);
        } else {
            log.info("커버 이미지 수정");
            findCoverImage.setName(coverImage.getName());
            findCoverImage.setImgName(coverImage.getImgName());
            findCoverImage.setWidth(coverImage.getWidth());
            findCoverImage.setHeight(coverImage.getHeight());
            findCoverImage.setDescription(coverImage.getDescription());
            findCoverImage.setUpdate_date(LocalDateTime.now());
        }

        return coverImage.getId();
    }

    /**
     * 커버 이미지 조회
     */
    public CoverImage findOne(Long coverImageId) {
        return coverImageRepository.findOne(coverImageId);
    }

}
