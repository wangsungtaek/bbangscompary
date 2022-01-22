package bbangscompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//@RequestMapping("/login")
public class LoginController {

    //@GetMapping("")
    public String getLoginPage(
            Model model,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception
    ) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "/login/loginPage";
    }
}
