package bbangscompany.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    @GetMapping("/admin")
    public String adminHome() {
        log.info("admin Home");
        return "admin/home";
    }
}
