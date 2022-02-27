package bbangscompany.controller.admin;

import bbangscompany.domain.CoverImage;
import bbangscompany.service.CoverImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CoverImageController {

    private final CoverImageService coverImageService;

    @Value("${file.upload.coverImg}")
    private String coverImageBasePath;

    /**
     * 커버 이미지 조회 화면
     */
    @GetMapping("/coverImage")
    public String coverImageHome(Model model) {
        log.info("cover Image management Page");

        CoverImage coverImage = coverImageService.findOne(1L);

        model.addAttribute("coverImage", coverImage);
        model.addAttribute("coverImgForm", new CoverImageForm());
        return "admin/coverImage";
    }

    /**
     * 커버 이미지 변경
     */
    @PostMapping("/coverImage")
    public String editCoverImage(@Valid CoverImageForm form, BindingResult result) throws IOException {

        log.info("edit Cover Image");

        if(result.hasErrors()) {
            return "admin/coverImage";
        }

        MultipartFile file = form.getFile();

        File coverImgPath = new File(coverImageBasePath);
        log.info("ssCoverImgPath : " + coverImgPath.exists());
        if (!coverImgPath.exists()) {
           if(coverImgPath.mkdirs()) {
               log.info("create Directory : success");
           } else {
               log.info("create Directory : fail");
           }
        }

        // 기존 파일 삭제
        CoverImage findCoverImage = coverImageService.findOne(1L);
        if (findCoverImage != null) {
            String orignCoverImgNm = findCoverImage.getImgName();
            String rmFilePath = coverImageBasePath + "/" + orignCoverImgNm;
            File rmFile = new File(rmFilePath);

            rmFile.delete();
        }

        // 추가할 파일 ( 절대경로 )
        String filePath = coverImageBasePath + "/" + file.getOriginalFilename();

        log.info("coverImageBasePath : " + coverImageBasePath);
        log.info("filePath : " + filePath);
        File dest = new File(filePath);
        file.transferTo(dest); // 파일 업로드

        CoverImage coverImage = new CoverImage();
        coverImage.setImgName(file.getOriginalFilename());
        coverImage.setUpdate_date(LocalDateTime.now());
        coverImage.setDescription(form.getDescription());

        coverImageService.createOrUpdate(coverImage);

        return "redirect:/coverImage";
    }

}
