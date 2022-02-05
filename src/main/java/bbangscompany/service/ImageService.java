package bbangscompany.service;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
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

    /**
     * 이미지 수정
     */
    @Transactional
    public void updateImg(Long id, ChannelName channelName, String link) {
        Image image = imageRepository.findOne(id);
        image.setChannelName(channelName);
        image.setLink(link);

        if (channelName == ChannelName.블로그) {
            image.setDivision(Division.blog);
        } else if (channelName == ChannelName.인스타그램) {
            image.setDivision(Division.instagram);
        } else if (channelName == ChannelName.유튜브) {
            image.setDivision(Division.youtube);
        }
    }

    /**
     * 이미지 삭제
     */
    @Transactional
    public void deleteImg(Long id) {
        imageRepository.delete(id);
    }
}
