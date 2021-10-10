package bangsCompany.bangsCompany.main.controller;

import bangsCompany.bangsCompany.main.domain.Picture;
import bangsCompany.bangsCompany.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bangsCompany")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("")
    public String savePicture() {

        String[] channelNames = { "블로그", "블로그", "블로그" };
        String[] names = { "하임리프티", "모메이", "망고드랍"};
        String[] links = { "https://blog.naver.com/zxasqw1935/222405049067"
                         , "https://blog.naver.com/mythya0730/222516475792"
                         , "https://blog.naver.com/oioi3030/222488976196"};
        String[] imgLink = { "/img/blog/하임리프티.JPG"
                           , "/img/blog/모메이.JPG"
                           , "/img/blog/망고드랍.JPG"};

        for( int i = 0; i < channelNames.length; i++ ) {

            Picture picture = new Picture();
            picture.setChannelName(channelNames[i]);
            picture.setName(names[i]);
            picture.setLink(links[i]);
            picture.setImgPath(imgLink[i]);
            mainService.save(picture);
        }

        return "redirect:/bangsCompany/main";
    }

    @GetMapping("main")
    public String mainPage(Model model) {

        List<Picture> pictures = mainService.findPictures();
        model.addAttribute("pictures", pictures);
        for(Picture picture : pictures) {
            System.out.println(picture.getName());
        }
        return "main";
    }

}
