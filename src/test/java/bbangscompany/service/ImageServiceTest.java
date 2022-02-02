package bbangscompany.service;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
import bbangscompany.domain.Image;
import bbangscompany.repository.ImageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ImageServiceTest {

    @Autowired
    ImageService imageService;

    @Autowired
    ImageRepository imageRepository;

    @Test
    //@Rollback(value = false)
    public void 이미지_저장() throws Exception {
        // given
        Image image = new Image();
        image.setTitle("1번 이미지");
        image.setDivision(Division.blog);
        image.setChannelName(ChannelName.블로그);

        // whenR
        Long saveId = imageService.imgSave(image);

        // then
        assertEquals(image, imageRepository.findOne(saveId));
     }

    @Test
    @Rollback(value = false)
    public void 이미지_조회() throws Exception {
        // given
        Image image = new Image();
        image.setTitle("2번 이미지");

        // when
        Long saveId = imageService.imgSave(image);

        // then
        Image findImg = imageRepository.findOne(1L);
        Assertions.assertThat(saveId).isEqualTo(findImg.getId());
    }

}