package bbangscompany.service;

import bbangscompany.domain.Collaborate;
import bbangscompany.repository.CollaborateRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CollaborateServiceTest {

    @Autowired
    CollaborateService collaborateService;

    @Autowired
    CollaborateRepository collaborateRepository;

    @Test
    //@Rollback(value = false)
    public void 협력사_전체_조회() throws Exception {
        // given
        Collaborate collaborate1 = new Collaborate();
        collaborate1.setName("협력사1");
        Collaborate collaborate2 = new Collaborate();
        collaborate2.setName("협력사2");

        // when
        collaborateService.collaborateSave(collaborate1);
        collaborateService.collaborateSave(collaborate2);

        // then
        assertThat(2).isEqualTo(collaborateService.findCollaborates().size());
     }

     @Test
     public void 협력사_단건_조회() throws Exception {
         // given
         Collaborate collaborate = new Collaborate();
         collaborate.setName("협력사1");

         // when
         collaborateService.collaborateSave(collaborate);

         // then
         assertThat(collaborate).isEqualTo(collaborateService.findOne(collaborate.getId()));
      }
}