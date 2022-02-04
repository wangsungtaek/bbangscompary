package bbangscompany.controller.admin;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    @GetMapping("/images/new")
    public String createImageForm(Model model) {
        model.addAttribute("imageForm", new ImageForm());
        log.info("image page");
        return "admin/createImageForm";
    }

    @PostMapping("/images/new")
    public String createImage(@Valid ImageForm form, BindingResult result) throws IOException {

        log.info("create Image");

        if (result.hasErrors()) {
            return "admin/createImageForm";
        }
        MultipartFile file = form.getFile();

        String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
        String basePath = rootPath + "/" + "images";

        File imagePath = new File(basePath);
        if( !imagePath.exists()) {
            imagePath.mkdir();
        }

        String filePath = basePath + "/" + file.getOriginalFilename();
        File dest = new File(filePath);
        file.transferTo(dest); // 파일 업로드

        String title = form.getTitle();
        System.out.println("title = " + title);

        String link = form.getLink();
        System.out.println("link = " + link);

        System.out.println("file = " + file);

        return "redirect:/admin";
    }
}
