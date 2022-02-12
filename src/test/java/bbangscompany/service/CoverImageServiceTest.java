package bbangscompany.service;

import bbangscompany.config.WebConfig;
import bbangscompany.controller.admin.CollaborateController;
import bbangscompany.controller.admin.ImageController;
import bbangscompany.domain.CoverImage;
import bbangscompany.repository.CoverImageRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.config.location=classpath:application-test.yml")
@Transactional
public class CoverImageServiceTest {

    @Autowired
    CoverImageService coverImageService;

    @Autowired
    CoverImageRepository coverImageRepository;

    @Autowired
    EntityManager em;

    @MockBean
    WebConfig webConfig;

    @MockBean
    CollaborateController collaborateController;

    @MockBean
    ImageController imageController;


    @Test
    public void 커버이미지_등록() throws Exception {
        // given
        CoverImage coverImage = new CoverImage();
        coverImage.setName("커버01");
        coverImage.setImgName("cover01.png");
        coverImage.setWidth(100);
        coverImage.setHeight(100);
        coverImage.setUpdate_date(LocalDateTime.now());

        // when
        Long saveId = coverImageService.createOrUpdate(coverImage);

        // then
        assertThat(coverImage.getId()).isEqualTo(saveId);
     }

     @Test
     @Rollback(value = false)
     public void 커버이미지_업데이트() throws Exception {
         // given
         CoverImage coverImage = new CoverImage();
         coverImage.setName("커버01");
         coverImage.setImgName("cover01.png");
         coverImage.setWidth(100);
         coverImage.setHeight(100);
         coverImage.setUpdate_date(LocalDateTime.now());
         coverImageRepository.save(coverImage);

         // when
         CoverImage findCoverImage = coverImageService.findOne(coverImage.getId());
         findCoverImage.setWidth(120);

         // then
         assertThat(120).isEqualTo(coverImageRepository.findOne(coverImage.getId()).getWidth());
      }

}