package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Image {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imgPath;
    private String link;

    @Enumerated(EnumType.STRING)
    private ChannelName channelName;

    @Enumerated(EnumType.STRING)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    private LocalDateTime createDate;

    public Image() {

    }
}
