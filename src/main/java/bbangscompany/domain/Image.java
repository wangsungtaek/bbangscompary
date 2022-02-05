package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@Entity
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    private String title;
    private String imgName;
    private String link;

    @Enumerated(EnumType.STRING)
    private ChannelName channelName;

    @Enumerated(EnumType.STRING)
    private Division division;

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "u_id")
//    private User user;

    private LocalDateTime createDate;
}
