package bbangscompany.bbangscompany.onlineMarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlineMarketing")
public class OnlineMarketingController {

    @GetMapping("")
    public String onlineMarketingPage() {

        return "onlineMarketing/onlineMarketingPage";
    }
}
