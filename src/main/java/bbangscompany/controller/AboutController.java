package bbangscompany.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping("")
    public String aboutPage(Model model) {


        List<String> imgPaths = new ArrayList<String>();

        imgPaths.add("/img/collaborate/collaborate_01.png");
        imgPaths.add("/img/collaborate/collaborate_02.png");
        imgPaths.add("/img/collaborate/collaborate_03.png");
        imgPaths.add("/img/collaborate/collaborate_04.png");
        imgPaths.add("/img/collaborate/collaborate_05.png");
        imgPaths.add("/img/collaborate/collaborate_06.png");
        imgPaths.add("/img/collaborate/collaborate_07.png");
        imgPaths.add("/img/collaborate/collaborate_08.png");
        imgPaths.add("/img/collaborate/collaborate_09.png");
        imgPaths.add("/img/collaborate/collaborate_10.png");
        imgPaths.add("/img/collaborate/collaborate_11.png");
        imgPaths.add("/img/collaborate/collaborate_12.png");
        imgPaths.add("/img/collaborate/collaborate_13.png");
        imgPaths.add("/img/collaborate/collaborate_14.png");
        imgPaths.add("/img/collaborate/collaborate_15.png");
        imgPaths.add("/img/collaborate/collaborate_16.png");
        imgPaths.add("/img/collaborate/collaborate_17.png");
        imgPaths.add("/img/collaborate/collaborate_18.png");
        imgPaths.add("/img/collaborate/collaborate_19.png");
        imgPaths.add("/img/collaborate/collaborate_20.png");
        imgPaths.add("/img/collaborate/collaborate_21.png");
        imgPaths.add("/img/collaborate/collaborate_22.png");
        imgPaths.add("/img/collaborate/collaborate_23.png");
        imgPaths.add("/img/collaborate/collaborate_24.png");
        imgPaths.add("/img/collaborate/collaborate_25.png");
        imgPaths.add("/img/collaborate/falco.png");
        imgPaths.add("/img/collaborate/abc.png");
        imgPaths.add("/img/collaborate/동아.png");

        // 파일 읽어오기
//        File rw = new File("/img/collaborate");
//        File[] fileList = rw.listFiles();
//        String[] fileNames = new String[ fileList.length ];
//        String fileName = "";

//        for( int i = 0; i < fileList.length; i++ ) {
//            if( fileList[i].isFile()) {
//                fileName = fileList[i].getName();
//                fileNames[i] = fileName;
//            }
//        }

        // 순서 정렬
//        Arrays.sort(fileNames);

        // 결과 저장
//        for( String file : fileNames ) {
//            imgPaths.add("/img/collaborate/" + file);
//        }

        model.addAttribute("collaborates", imgPaths);

        return "about/aboutPage";
    }
}
