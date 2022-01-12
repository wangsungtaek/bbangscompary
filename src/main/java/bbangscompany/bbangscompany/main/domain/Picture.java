package bbangscompany.bbangscompany.main.domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Picture {

    private Long id;
    private String name;
    private String channelName;
    private String imgPath;
    private String link;
    private String division;

}
