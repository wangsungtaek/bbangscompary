package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
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

    /**
     * 이미지 업데이트
     */
    public void changeImage(ChannelName channelName, String link) {
        this.channelName = channelName;
        this.link = link;

        if (channelName == ChannelName.블로그) {
            this.division = Division.blog;
        } else if (channelName == ChannelName.인스타그램) {
            this.division = Division.instagram;
        } else if (channelName == ChannelName.유튜브) {
            this.division = Division.youtube;
        }
    }
}
