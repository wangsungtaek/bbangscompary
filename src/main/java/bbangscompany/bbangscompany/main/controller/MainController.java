package bbangscompany.bbangscompany.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("")
    public String home() {

        return "main";
    }

    @GetMapping("mvc")
    public String mvc(Model model) {

        model.addAttribute("data", "zzzzzzz");
        return "home";
    }

}
