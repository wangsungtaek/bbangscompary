package bangsCompany.bangsCompany.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("about")
public class AboutController {

    @GetMapping("main")
    public String aboutMain() {

        return "about/main";
    }
}
