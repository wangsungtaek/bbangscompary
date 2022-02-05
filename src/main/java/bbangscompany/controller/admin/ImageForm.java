package bbangscompany.controller.admin;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ImageForm {

    @NotEmpty(message = "이미지 이름은 필수 입니다.")
    private String title;

    @NotEmpty(message = "링크를 선택해 주세요.")
    private String link;

    private ChannelName channelName;

    private MultipartFile file;

    private String imgName;
}
