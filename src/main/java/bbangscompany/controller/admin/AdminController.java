package bbangscompany.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    @GetMapping("/admin")
    public String loginHome() {
        log.info("login Page");
        return "admin/login";
    }

    @PostMapping("/admin")
    public String adminHome(@Valid String id, @Valid String password) {
        log.info("admin Page");
        if (id.equals("admin") && password.equals("admin1!")) {
            return "admin/home";
        }
        return "redirect:/";
    }
}
