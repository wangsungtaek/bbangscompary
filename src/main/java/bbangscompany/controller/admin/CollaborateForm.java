package bbangscompany.controller.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class CollaborateForm {

    private String name;

    private String link;

    private MultipartFile file;

    private String imgName;
}
