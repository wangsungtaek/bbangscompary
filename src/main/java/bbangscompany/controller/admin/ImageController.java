package bbangscompany.controller.admin;

import bbangscompany.domain.ChannelName;
import bbangscompany.domain.Division;
import bbangscompany.domain.Image;
import bbangscompany.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

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

    @Value("${file.upload.mainImg}")
    private String imageBasePath;

    /**
     * 이미지 조회 화면
     */
    @GetMapping("/images")
    public String imageList(Model model) {
        List<Image> images = imageService.findImages();
        model.addAttribute("images", images);
        model.addAttribute("imageForm", new ImageForm());
        return "admin/imageList";
    }

    /**
     * 이미지 등록 화면
     */
    @GetMapping("/images/new")
    public String createImageForm(Model model) {
        model.addAttribute("imageForm", new ImageForm());
        log.info("image page");
        return "admin/createImageForm";
    }

    /**
     * 이미지 등록
     */
    @PostMapping("/images/new")
    public String createImage(@Valid ImageForm form, BindingResult result) throws IOException {

        log.info("create Image");

        if (result.hasErrors()) {
            return "admin/createImageForm";
        }
        MultipartFile file = form.getFile();

        File imagePath = new File(imageBasePath);
        if( !imagePath.exists()) {
            imagePath.mkdir();
        }

        String filePath = imageBasePath + "/" + file.getOriginalFilename();

        log.info("imageBasePath : " + imageBasePath);
        log.info("filePath : " + filePath);
        File dest = new File(filePath);
        file.transferTo(dest); // 파일 업로드

        Image image = new Image();
        image.setTitle(form.getTitle());
        image.setLink(form.getLink());
        image.setChannelName(form.getChannelName());
        image.setImgName(file.getOriginalFilename());
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


    /**
     * 이미지 수정
     */
    @PostMapping("/images/{imageId}/edit")
    public String editImage(
            @PathVariable("imageId") Long imageId,
            @Valid ImageForm form)
    {

        imageService.updateImg(imageId, form.getChannelName(), form.getLink());

        return "redirect:/images";
    }

    /**
     * 이미지 삭제
     */
    @PostMapping("/images/{imageId}/delete")
    public String deleteImage(
            @PathVariable("imageId") Long imageId,
            @Valid ImageForm form)
    {

        imageService.deleteImg(imageId);

        String imgPath = imageBasePath + "/" + form.getImgName();

        File file = new File(imgPath);
        file.delete();

        return "redirect:/images";
    }

}
