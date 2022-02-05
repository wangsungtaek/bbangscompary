package bbangscompany.controller.admin;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
import bbangscompany.domain.Image;
import bbangscompany.service.ImageService;
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
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    private final ImageService imageService;

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

        Image image = new Image();
        image.setTitle(form.getTitle());
        image.setLink(form.getLink());
        image.setChannelName(form.getChannelName());
        image.setImgPath(filePath);
        image.setCreateDate(LocalDateTime.now());

        if (image.getChannelName() == ChannelName.블로그) {
            image.setDivision(Division.blog);
        } else if (image.getChannelName() == ChannelName.유튜브) {
            image.setDivision(Division.youtube);
        } else if (image.getChannelName() == ChannelName.인스타그램) {
            image.setDivision(Division.instagram);
        }

        imageService.imgSave(image);

        return "redirect:/images/new";
    }

    @GetMapping("/images")
    public String imageList(Model model) {
        List<Image> images = imageService.findImages();
        model.addAttribute("images", images);

        return "admin/imageList";
    }


}
