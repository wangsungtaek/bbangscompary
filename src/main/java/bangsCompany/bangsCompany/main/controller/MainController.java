package bangsCompany.bangsCompany.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bangsCompany")
public class MainController {

    @GetMapping("main")
    public String mainPage(Model model) {
        System.out.println("11");
        return "main";
    }
}
