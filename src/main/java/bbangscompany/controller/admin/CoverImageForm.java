package bbangscompany.controller.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class CoverImageForm {

    private String title;

    private MultipartFile file;

    private String description;
}
