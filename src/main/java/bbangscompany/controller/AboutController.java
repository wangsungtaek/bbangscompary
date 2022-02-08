package bbangscompany.controller;


import bbangscompany.domain.Collaborate;
import bbangscompany.service.CollaborateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/about")
public class AboutController {

    private final CollaborateService collaborateService;

    @GetMapping("")
    public String aboutPage(Model model) {

        List<Collaborate> collaborates = collaborateService.findCollaborates();
        model.addAttribute("collaborates", collaborates);

        return "about/aboutPage";
    }
}
