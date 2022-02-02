package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String uid;

    @Column(length = 20, nullable = false)
    private String upw;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    private LocalDateTime createDate;
}
