package bangsCompany.bangsCompany.onlineMarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlineMarketing")
public class OnlineMarketingController {

    @GetMapping("main")
    public String onlineMarketingMain() {

        return "onlineMarketing/main";
    }

    @GetMapping("reviewViral.view")
    public String reviewViralView() {

        return "onlineMarketing/reviewViral";
    }

    @GetMapping("snsManager.view")
    public String snsManagerView() {

        return "onlineMarketing/snsManager";
    }

    @GetMapping("powerPage.view")
    public String powerPageView() {

        return "onlineMarketing/powerPage";
    }

    @GetMapping("snsLecture.view")
    public String snsLectureView() {

        return "onlineMarketing/snsLecture";
    }
}
