package bbangscompany.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    @GetMapping("/images/new")
    public String createImageForm(Model model) {
        model.addAttribute("imageForm", new ImageForm());
        return "admin/createImageForm";
    }
}
