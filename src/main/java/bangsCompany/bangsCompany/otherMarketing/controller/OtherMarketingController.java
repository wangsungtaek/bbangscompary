package bangsCompany.bangsCompany.otherMarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/otherMarketing")
public class OtherMarketingController {

    @GetMapping("otherService")
    public String otherServiceView() {

        return "onlineMarketing/otherService";
    }

    @GetMapping("article")
    public String articleView() {

        return "onlineMarketing/article";
    }

    @GetMapping("shot")
    public String shotView() {

        return "onlineMarketing/shot";
    }

    @GetMapping("autoRegistration")
    public String autoRegistrationView() {

        return "onlineMarketing/autoRegistration";
    }
}
