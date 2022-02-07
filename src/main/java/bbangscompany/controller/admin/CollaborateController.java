package bbangscompany.controller.admin;

import bbangscompany.domain.Collaborate;
import bbangscompany.service.CollaborateService;
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
public class CollaborateController {

    private final CollaborateService collaborateService;

    @Value("${file.upload.collaboImg}")
    private String collaboImgPath;

    /**
     * 협력사 조회 화면
     */
    @GetMapping("/collaborates")
    public String collaboImgList(Model model) {
        List<Collaborate> collaborates = collaborateService.findCollaborates();
        model.addAttribute("collaborates", collaborates);
        model.addAttribute("collaborateForm", new CollaborateForm());
        return "admin/collaborateList";
    }

    /**
     * 협력사 등록 확면
     */
    @GetMapping("/collaborates/new")
    public String createCollaborateForm(Model model) {
        model.addAttribute("collaborateForm", new CollaborateForm());
        log.info("create collaborate Page");
        return "admin/createCollaborateForm";
    }

    /**
     * 협력사 등록
     */
    @PostMapping("/collaborates/new")
    public String createCollaborate(@Valid CollaborateForm form, BindingResult result) throws IOException {

        log.info("collaborate create Form");

        if (result.hasErrors()) {
            return "admin/createCollaborateForm";
        }
        MultipartFile file = form.getFile();

        File collaboPath = new File(collaboImgPath);
        if (!collaboPath.exists()) {
            collaboPath.mkdir();
        }

        String filePath = collaboImgPath + "/" + file.getOriginalFilename();

        File dest = new File(filePath);
        file.transferTo(dest); // 파일 업로드

        Collaborate collaborate = new Collaborate();
        collaborate.setName(form.getName());
        collaborate.setLink(form.getLink());
        collaborate.setImgName(file.getOriginalFilename());
        collaborate.setCreateDate(LocalDateTime.now());

        collaborateService.collaborateSave(collaborate);

        return "redirect:/collaborates/new";
    }


    /**
     * 협력사 수정
     */
    @PostMapping("/collaborates/{collaboId}/edit")
    public String editCollabo(
            @PathVariable("collaboId") Long collaboId,
            @Valid CollaborateForm form)
    {
        collaborateService.updateCollaborate(collaboId, form.getLink());

        return "redirect:/collaborates";
    }

    /**
     * 협력사 삭제
     */
    @PostMapping("/collaborates/{collaboId}/delete")
    public String deleteCollaborate(
            @PathVariable("collaboId") Long collaboId,
            @Valid CollaborateForm form)
    {
        collaborateService.deleteCollaborate(collaboId);

        String imgPath = collaboImgPath + "/" + form.getImgName();

        File file = new File(imgPath);
        file.delete();

        return "redirect:/collaborates";
    }
}
