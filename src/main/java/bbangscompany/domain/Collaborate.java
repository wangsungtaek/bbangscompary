package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Collaborate {

    @Id
    @GeneratedValue
    @Column(name = "collaborate_id")
    private Long id;

    private String name;
    private String imgName;
    private String link;

    private LocalDateTime createDate;

    /**
     * 협력사 업데이트
     */
    public void changeCollaborate(String link) {
        this.link = link;
    }
}
