package bbangscompany.controller.admin;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ImageForm {

    @NotEmpty(message = "이미지 이름은 필수 입니다.")
    private String title;

    private String link;
    private ChannelName channelName;
    private Division division;
}
