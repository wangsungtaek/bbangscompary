package bbangscompany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class User {

    @Id @GeneratedValue
    @Column(name = "u_id")
    private Long id;

    @Column(name = "user_id", length = 20, nullable = false)
    private String uid;

    @Column(name = "user_pw", length = 20, nullable = false)
    private String upw;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    private LocalDateTime createDate;

    public User() {
    }
}
