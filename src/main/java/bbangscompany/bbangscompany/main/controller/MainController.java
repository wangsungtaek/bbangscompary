package bbangscompany.bbangscompany.main.controller;

import bbangscompany.bbangscompany.main.domain.Picture;
import bbangscompany.bbangscompany.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("")
    public String savePicture() {

        String[] channelNames = { "블로그", "블로그", "블로그", "블로그", "블로그", "블로그", "블로그", "블로그", "블로그", "블로그",
            "인스타그램", "인스타그램", "인스타그램", "인스타그램", "인스타그램", "인스타그램", "인스타그램", "유튜브", "유튜브"};
        String[] names = { "하임리프티", "모메이", "망고드랍", "오프바운더리", "오프리케어", "gee 호텔", "SK X ADT", "장수촌",
            "서민갑부가구 시흥점", "키퍼미", "인천광역시", "인천국제공항공사", "어나니머스아티스트", "웅진플레이", "에이아일랜드", "다봄", "세레치피", "경기도주식회사",
            "LOTTE"};
        String[] links = { "https://blog.naver.com/zxasqw1935/222405049067"
                , "https://blog.naver.com/mythya0730/222516475792"
                , "https://blog.naver.com/oioi3030/222488976196"
                , "https://blog.naver.com/yyyy5428/222422979389"
                , "https://blog.naver.com/goeun061133/221389143510"
                , "https://blog.naver.com/pangramer/222516706362"
                , "https://blog.naver.com/hyunjung5340/222505102322"
                , "https://blog.naver.com/lovely_227/222521295415"
                , "https://blog.naver.com/nameleader1/222491316072"
                , "https://blog.naver.com/mhlee0487/222456059807"
                , "https://www.instagram.com/p/CIOCOYqFeAu"
                , "https://www.instagram.com/p/CIPMJhZjee-"
                , "https://www.instagram.com/p/CHxTLeZD1lM/"
                , "https://www.instagram.com/p/CFhXAuLhP0o"
                , "https://www.instagram.com/p/CM4jRSDhges/"
                , "https://www.instagram.com/p/CKtQzwjFmm0/"
                , "https://www.instagram.com/p/CR-pam0JEQD/"
                , "https://www.youtube.com/watch?v=J-vnifYfyOE"
                , "https://www.youtube.com/watch?v=G_3T6Atrhlw" };
        String[] imgLink = { "/img/blog/하임리프티.JPG"
                , "/img/blog/모메이.JPG"
                , "/img/blog/망고드랍.JPG"
                , "/img/blog/오프바운더리.JPG"
                , "/img/blog/오프리케어.JPG"
                , "/img/blog/GEE호텔.JPG"
                , "/img/blog/SK X ADT.JPG"
                , "/img/blog/장수촌.JPG"
                , "/img/blog/서민갑부가구 시흥점.JPG"
                , "/img/blog/키퍼미.JPG"
                , "/img/instagram/인천국제디자인페어.JPG"
                , "/img/instagram/인천국제공항사.JPG"
                , "/img/instagram/어마니머스아티스트.JPG"
                , "/img/instagram/웅진플레이도시.JPG"
                , "/img/instagram/에이아일랜드.JPG"
                , "/img/instagram/다봄.JPG"
                , "/img/instagram/세레치피.JPG"
                , "/img/youtube/경기도주식회사.JPG"
                , "/img/youtube/LOTTE.JPG" };

        String[] division = { "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-blog"
                , "filter-instagram"
                , "filter-instagram"
                , "filter-instagram"
                , "filter-instagram"
                , "filter-instagram"
                , "filter-instagram"
                , "filter-instagram"
                , "filter-youtube"
                , "filter-youtube" };
        mainService.remove();
        System.out.println("channelNames size : " + channelNames.length);
        for( int i = 0; i < channelNames.length; i++ ) {

            Picture picture = new Picture();
            picture.setChannelName(channelNames[i]);
            picture.setName(names[i]);
            picture.setLink(links[i]);
            picture.setImgPath(imgLink[i]);
            picture.setImgPath(imgLink[i]);
            picture.setDivision(division[i]);
            mainService.save(picture);
        }
        return "redirect:/main";
    }

    @GetMapping("main")
    public String mainPage(Model model) {

        List<Picture> pictures = mainService.findPictures();
        System.out.println(pictures.size());
        for( Picture p : pictures) {
            System.out.println(p.getName());
        }

        model.addAttribute("pictures", pictures);
        for(Picture picture : pictures) {
            System.out.println(picture.getName());
        }
        return "main";
    }
}
