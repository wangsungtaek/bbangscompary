package bbangscompany.controller;

import bbangscompany.domain.Image;
import bbangscompany.domain.Picture;
import bbangscompany.domain.ContactUs;
import bbangscompany.service.ContactUsService;
import bbangscompany.service.ImageService;
import bbangscompany.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class MainController {

    private final MainService mainService;
    private final ContactUsService contactUsService;
    private final ImageService imageService;

    @GetMapping("")
    public String savePicture(Model model) {

        List<Picture> pictures = new ArrayList<>();

        // 블로그
        pictures.add(new Picture(1L, "하임리프티", "블로그", "/img/blog/하임리프티.JPG", "https://blog.naver.com/zxasqw1935/222405049067", "filter-blog"));
        pictures.add(new Picture(2L, "오프바운더리", "블로그", "/img/blog/오프바운더리.JPG", "https://blog.naver.com/yyyy5428/222422979389", "filter-blog"));
        pictures.add(new Picture(3L, "오프리케어", "블로그", "/img/blog/오프리케어.JPG", "https://blog.naver.com/goeun061133/221389143510", "filter-blog"));
        pictures.add(new Picture(4L, "gee 호텔", "블로그", "/img/blog/GEE호텔.JPG", "https://blog.naver.com/pangramer/222516706362", "filter-blog"));
        pictures.add(new Picture(5L, "SK X ADT", "블로그", "/img/blog/SK X ADT.JPG", "https://blog.naver.com/hyunjung5340/222505102322", "filter-blog"));
        pictures.add(new Picture(6L, "서민갑부가구 시흥점", "블로그", "/img/blog/서민갑부가구 시흥점.JPG", "https://blog.naver.com/nameleader1/222491316072", "filter-blog"));
        pictures.add(new Picture(7L, "키퍼미", "블로그", "/img/blog/키퍼미.JPG", "https://blog.naver.com/mhlee0487/222456059807", "filter-blog"));
        pictures.add(new Picture(8L, "27호텔", "블로그", "/img/blog/27호텔.JPG", "https://blog.naver.com/mh205021/222573730901", "filter-blog"));
        pictures.add(new Picture(9L, "레드락 비어하우스", "블로그", "/img/blog/레드락 비어하우스.JPG", "https://blog.naver.com/lovelovemg/222163072524", "filter-blog"));
        pictures.add(new Picture(10L, "마피아 쥬스", "블로그", "/img/blog/마피아쥬스.JPG", "https://m.blog.naver.com/choijihye7/222145166954", "filter-blog"));
        pictures.add(new Picture(11L, "부에노 떡볶이", "블로그", "/img/blog/부에노떡볶이.JPG", "https://blog.naver.com/minnie926/222003081168", "filter-blog"));
        pictures.add(new Picture(12L, "명가 냉면", "블로그", "/img/blog/명가냉면.JPG", "https://blog.naver.com/mytofls20/222004767268", "filter-blog"));
        pictures.add(new Picture(13L, "유메참치", "블로그", "/img/blog/유메참치.JPG", "https://blog.naver.com/mytofls7/222167385256", "filter-blog"));
        pictures.add(new Picture(14L, "논현비비뷰티", "블로그", "/img/blog/논현비비뷰티.JPG", "https://blog.naver.com/fullmoon1983/222336781554", "filter-blog"));
        pictures.add(new Picture(15L, "안양 댕리단 커피", "블로그", "/img/blog/댕리단커피.JPG", "https://blog.naver.com/b319/222187823759", "filter-blog"));
        pictures.add(new Picture(16L, "강남 플래너 성형외과", "블로그", "/img/blog/강남플래너성형외과.JPG", "https://blog.naver.com/sool920/222228688785", "filter-blog"));
        pictures.add(new Picture(17L, "노벨북", "블로그", "/img/blog/노벨북.JPG", "https://blog.naver.com/ok870814/222279407830", "filter-blog"));
        pictures.add(new Picture(18L, "데이플랜노트북거치대", "블로그", "/img/blog/데이플랜 노트북 거치대(블로그).JPG", "https://blog.naver.com/hms080315/222609839046", "filter-blog"));
        pictures.add(new Picture(19L, "데이플랜아이폰케이스", "블로그", "/img/blog/데이플랜아이폰케이스(블로그).JPG", "https://blog.naver.com/ericayoun77/222610800529", "filter-blog"));
        pictures.add(new Picture(20L, "망고드랍(에센스)", "블로그", "/img/blog/망고드랍에센스(블로그).JPG", "https://blog.naver.com/oioi3030/222488976196", "filter-blog"));
        pictures.add(new Picture(21L, "망고드랍(크림)", "블로그", "/img/blog/망고드랍크림(블로그).JPG", "https://blog.naver.com/leehoney_g/222406321724", "filter-blog"));
        pictures.add(new Picture(22L, "모메이(립케어)", "블로그", "/img/blog/모메이립케어(블로그).JPG", "https://blog.naver.com/mythya0730/222516475792", "filter-blog"));
        pictures.add(new Picture(23L, "모메이(워터리)", "블로그", "/img/blog/모메이 워터리(블로그).JPG", "https://blog.naver.com/wlgysnl23/222598857053", "filter-blog"));
        pictures.add(new Picture(24L, "모메이(벨벳틴트)", "블로그", "/img/blog/모메이 벨벳틴트(블로그).JPG", "https://blog.naver.com/elleest486/222599105486", "filter-blog"));
        pictures.add(new Picture(25L, "모에이(아이팔레트)", "블로그", "/img/blog/모메이 아이팔레트(블로그).JPG", "https://blog.naver.com/minip2/222597977970", "filter-blog"));
        pictures.add(new Picture(26L, "장수촌", "블로그", "/img/blog/장수촌(블로그).JPG", "https://blog.naver.com/lovely_227/222521295415", "filter-blog"));
        pictures.add(new Picture(27L, "북매니아", "블로그", "/img/blog/북매니아.JPG", "https://blog.naver.com/yaeeun0301/222599525571", "filter-blog"));
        pictures.add(new Picture(28L, "고기굽는형제", "블로그", "/img/blog/고기굽는형제.JPG", "https://blog.naver.com/wa7454/222560236914", "filter-blog"));
        pictures.add(new Picture(29L, "돈포포", "블로그", "/img/blog/돈포포.JPG", "https://blog.naver.com/csa2001/222561726486", "filter-blog"));
        pictures.add(new Picture(30L, "센텔라모어크림", "블로그", "/img/blog/센텔라모어크림(블로그).JPG", "https://blog.naver.com/nimoforever/222533523516", "filter-blog"));
        pictures.add(new Picture(31L, "플라코샴푸", "블로그", "/img/blog/플라코샴푸(블로그).JPG", "https://blog.naver.com/mj06261004/222569235920", "filter-blog"));
        pictures.add(new Picture(32L, "즐거운 돈까스", "블로그", "/img/blog/즐거운 돈까스.JPG", "https://blog.naver.com/k890902/222606087990", "filter-blog"));
        pictures.add(new Picture(33L, "플러스82 헤어", "블로그", "/img/blog/플러스82 헤어.JPG", "https://blog.naver.com/akejdcn/222108554684", "filter-blog"));
        pictures.add(new Picture(34L, "피니쉬 골프", "블로그", "/img/blog/피니쉬골프.JPG", "https://m.blog.naver.com/docukang/222120765577", "filter-blog"));
        pictures.add(new Picture(35L, "마이워크스페이스", "블로그", "/img/blog/마이워크스페이스.JPG", "https://blog.naver.com/taekstory/222554700317", "filter-blog"));
        pictures.add(new Picture(36L, "한국가스안전공사", "블로그", "/img/blog/한국가스안전공사(블로그).JPG", "https://blog.naver.com/mytofls7/222595353850", "filter-blog"));

        // 인스타
        pictures.add(new Picture(37L, "인천광역시", "인스타그램", "/img/instagram/인천국제디자인페어.JPG", "https://www.instagram.com/p/CIOCOYqFeAu", "filter-instagram"));
        pictures.add(new Picture(38L, "인천국제공항공사", "인스타그램", "/img/instagram/인천국제공항사.JPG", "https://www.instagram.com/p/CIPMJhZjee-", "filter-instagram"));
        pictures.add(new Picture(39L, "어나니머스아티스트", "인스타그램", "/img/instagram/어나니머스아티스트.JPG", "https://www.instagram.com/p/CHxTLeZD1lM/", "filter-instagram"));
        pictures.add(new Picture(40L, "웅진플레이", "인스타그램", "/img/instagram/웅진플레이도시.JPG", "https://www.instagram.com/p/CFhXAuLhP0o", "filter-instagram"));
        pictures.add(new Picture(41L, "에이아일랜드", "인스타그램", "/img/instagram/에이아일랜드.JPG", "https://www.instagram.com/p/CM4jRSDhges/", "filter-instagram"));
        pictures.add(new Picture(42L, "다봄", "인스타그램", "/img/instagram/다봄.JPG", "https://www.instagram.com/p/CKtQzwjFmm0/", "filter-instagram"));
        pictures.add(new Picture(43L, "세레치피", "인스타그램", "/img/instagram/세레치피.JPG", "https://www.instagram.com/p/CR-pam0JEQD/", "filter-instagram"));
        pictures.add(new Picture(44L, "데이플랜노트북거치대", "인스타그램", "/img/instagram/데이플랜 노트북 거치대(인스타그램).JPG", "https://www.instagram.com/p/CUPKw5llLYY/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(45L, "데이플랜아이폰케이스", "인스타그램", "/img/instagram/데이플랜 아이폰케이스(인스타그램).JPG", "https://www.instagram.com/p/CX5Dd1WBISt/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(46L, "망고드랍(에센스)", "인스타그램", "/img/instagram/망고드랍에센스(인스타그램).JPG", "https://www.instagram.com/p/CTa7vstJmPE/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(47L, "망고드랍(크림)", "인스타그램", "/img/instagram/망고드랍크림(인스타그램).JPG", "https://www.instagram.com/p/CQXDvR8A_G6/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(48L, "모메이(립케어)", "인스타그램", "/img/instagram/모메이 립케어(인스타그램).JPG", "https://www.instagram.com/p/CXdYHnXh0b8/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(49L, "모메이(워터리)", "인스타그램", "/img/instagram/모메이 워터리(인스타그램).JPG", "https://www.instagram.com/p/CXq4yNIBVyi/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(50L, "모메이(벨벳틴트)", "인스타그램", "/img/instagram/모메이 벨벳틴트(인스타그램).JPG", "https://www.instagram.com/p/CXUyqgqpAmN/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(51L, "모에이(아이팔레트)", "인스타그램", "/img/instagram/모메이 아이팔레트(인스타그램).JPG", "https://www.instagram.com/p/CXtD9s7JS8X/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(52L, "장수촌", "인스타그램", "/img/instagram/장수촌(인스타그램).JPG", "https://www.instagram.com/p/CWYXoJ9h7C3/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(53L, "서울 월화고기", "인스타그램", "/img/instagram/서울 월화고기.JPG", "https://www.instagram.com/p/CVUPD42ps3B/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(54L, "센텔라모어크림", "인스타그램", "/img/instagram/센텔라모어크림(인스타그램).JPG", "https://www.instagram.com/p/CU9hVXQFg_e/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(55L, "플라코샴푸", "인스타그램", "/img/instagram/플라코샴푸(인스타그램).JPG", "https://www.instagram.com/p/CWLs9jOh1SC/?utm_source=ig_web_copy_link", "filter-instagram"));
        pictures.add(new Picture(56L, "한국가스안전공사", "인스타그램", "/img/instagram/한국가스안전대상(인스타그램).JPG", "https://www.instagram.com/p/CXaYQvqPL8u/", "filter-instagram"));

        // 유튜브
        pictures.add(new Picture(57L, "경기도주식회사", "유튜브", "/img/youtube/경기도주식회사.JPG", "https://www.youtube.com/watch?v=J-vnifYfyOE", "filter-youtube"));
        pictures.add(new Picture(58L, "LOTTE", "유튜브", "/img/youtube/LOTTE.JPG", "https://www.youtube.com/watch?v=G_3T6Atrhlw", "filter-youtube"));

        List<Image> images = imageService.findImages();
        model.addAttribute("images", images);
        model.addAttribute("pictures", pictures);
        Object contactUs = model.getAttribute("contactUs");
        System.out.println("contactUs = " + contactUs);
        return "main";
    }

    @PostMapping("contactUs")
    @ResponseBody
    public ContactUs contactUs(ContactUs contactUs, Model model) {

        contactUsService.contactUs(contactUs);
        model.addAttribute("contactUs", "Y");

        return contactUs;
    }
}
