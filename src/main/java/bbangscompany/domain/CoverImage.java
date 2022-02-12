package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class CoverImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "coverImage_id")
    private Long id;

    private String name;
    private String imgName;
    private String description;

    private int width;
    private int height;

    private LocalDateTime update_date;

}
