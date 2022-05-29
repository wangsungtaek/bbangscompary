package bbangscompany.controller;

import bbangscompany.domain.Collaborate;
import bbangscompany.domain.Image;
import bbangscompany.domain.Picture;
import bbangscompany.domain.ContactUs;
import bbangscompany.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class MainController {

    private final MainService mainService;
    private final ContactUsService contactUsService;
    private final ImageService imageService;
    private final CoverImageService coverImageService;
    private final CollaborateService collaborateService;

    @GetMapping("")
    public String savePicture(Model model) {

        List<Image> images = imageService.findImages();
        List<Collaborate> collaborates = collaborateService.findCollaborates();

        model.addAttribute("coverImage", coverImageService.findOne(1L));
        model.addAttribute("collaborates", collaborates);
        model.addAttribute("images", images);

        return "main";
    }

    @PostMapping("contactUs")
    @ResponseBody
    public ContactUs contactUs(ContactUs contactUs, Model model) {

        contactUsService.contactUs(contactUs);
        model.addAttribute("contactUs", "Y");

        return contactUs;
    }
}
