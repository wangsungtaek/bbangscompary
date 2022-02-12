package bbangscompany.controller.admin;

import bbangscompany.service.CoverImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CoverImageController {

    private final CoverImageService coverImageService;

    /**
     * 커버 이미지 조회 화면
     */
    @GetMapping("/coverImage")
    public String coverImageHome(Model model) {
        log.info("cover Image management Page");
        return "admin/coverImage";
    }

}
