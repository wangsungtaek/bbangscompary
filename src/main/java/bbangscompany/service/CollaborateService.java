package bbangscompany.service;

import bbangscompany.domain.Collaborate;
import bbangscompany.repository.CollaborateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CollaborateService {

    private final CollaborateRepository collaborateRepository;

    /**
     * 협력사 등록
     */
    @Transactional
    public Long collaborateSave(Collaborate collaborate) {
        collaborateRepository.save(collaborate);
        return collaborate.getId();
    }

    /**
     * 협력사 전체 조회
     */
    public List<Collaborate> findCollaborates() {
        return collaborateRepository.findAll();
    }

    /**
     * 협력사 단건 조회
     */
    public Collaborate findOne(Long collaborateId) {
        return collaborateRepository.findOne(collaborateId);
    }

    /**
     * 협력사 수정
     */
    @Transactional
    public void updateCollaborate(Long id, String link) {
        Collaborate collaborate = collaborateRepository.findOne(id);
        collaborate.changeCollaborate(link);
    }

    /**
     * 협력사 삭제
     */
    @Transactional
    public void deleteCollaborate(Long id) {
        collaborateRepository.delete(id);
    }

}
