package bangsCompany.bangsCompany.main.controller;

import bangsCompany.bangsCompany.main.domain.Picture;
import bangsCompany.bangsCompany.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bangsCompany")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("main")
    public String savePicture() {

        String[] channelNames = { "블로그", "블로그" };
        String[] names = { "하임리프티", "모메이"};
        String[] links = { "https://blog.naver.com/zxasqw1935/222405049067"
                         , "https://blog.naver.com/mythya0730/222516475792" };
        String[] imgLink = { "/img/blog/하임리프티.JPG"
                           , "/img/blog/모메이.JPG"};

        for( int i = 0; i < channelNames.length; i++ ) {

            Picture picture = new Picture();
            picture.setChannelName(channelNames[i]);
            picture.setName(names[i]);
            picture.setLink(links[i]);
            picture.setImgLink(imgLink[i]);
            mainService.save(picture);
        }

        return "redirect:/";
    }
}
