package bbangscompany.bbangscompany.brandMarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("brandMarketing")
public class BrandMarketingController {

    @GetMapping("")
    public String brandMarketingPage() {

        return "brandMarketing/brandMarketingPage";
    }
}
